package com.tech.kj.service;

import com.tech.kj.controller.dto.SellerRegistrationDto;
import com.tech.kj.controller.dto.UserRegDto;
import com.tech.kj.entity.ContactEntity;
import com.tech.kj.entity.SellerEntity;
import com.tech.kj.exception.RecordAleadyExistException;
import com.tech.kj.exception.ServiceNAException;
import com.tech.kj.repository.SellerEntityRepo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Map;

@Slf4j
@Service
public class SellerServiceImpl implements SellerService{

    @Autowired
    private SellerEntityRepo sellerRepo;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.name.auth}")
    private String authServiceName;
    private final ModelMapper modelMapper = new ModelMapper();
    @Override
    @Transactional
    public SellerEntity register(SellerRegistrationDto sellerRegistrationDto) {
        SellerEntity seller = modelMapper.map(sellerRegistrationDto,SellerEntity.class);
        seller.setEmailAddress(sellerRegistrationDto.getEmail());
        ContactEntity contact = new ContactEntity(sellerRegistrationDto.getContactNumber());
        seller.getContactNumber().add(contact);
        contact.setPrimary(true);
        contact.setUser(seller);
        log.info("entity object after dto mapping {}",seller);
        if(sellerRepo.findByUserName(seller.getUserName()).isPresent()){
            log.info("duplicate record found with username "+seller.getUserName());
            RecordAleadyExistException recordAleadyExistException= new RecordAleadyExistException();
            recordAleadyExistException.setErrorCode("ERR-002");
            recordAleadyExistException.setTimestamp(new Timestamp(System.currentTimeMillis()));
            recordAleadyExistException.setErrorMessage("Record already exist with "+seller.getUserName());
            throw recordAleadyExistException;
        }
        SellerEntity createdSeller = sellerRepo.save(seller);
        log.info("saving seller into db with id"+ (null != createdSeller.getId() ? createdSeller.getId(): "empty"));
        UserRegDto userRegDto = new UserRegDto();
        userRegDto.setUserName(seller.getUserName());
        userRegDto.setPassword(seller.getPassword());
        userRegDto.setId(seller.getId());
        //http://AUTH-STORE/auth/store
        ResponseEntity<Object> authCreationResponse = postDataToExternalService("http://"+authServiceName+"/auth/store",userRegDto,restTemplate);
        if(null == authCreationResponse || authCreationResponse.getStatusCode() != HttpStatus.CREATED ){
            //send error response and roll back the current transaction
            ServiceNAException exception = new ServiceNAException();
            exception.setTimestamp(new Timestamp(System.currentTimeMillis()));
            exception.setErrorCode("ERR-001");
            exception.setErrorMessage("Something went wrong please try again");
            throw exception;
        }

        return createdSeller;
    }

    public <T> ResponseEntity<Object> postDataToExternalService(String serviceName, T requestData, RestTemplate restTemplate){
        return restTemplate.postForEntity(serviceName,requestData,Object.class);
    }


}
