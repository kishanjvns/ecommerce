package com.tech.kj.service;

import com.tech.kj.dto.UserRegistrationDto;
import com.tech.kj.entity.ContactEntity;
import com.tech.kj.entity.UserEntity;
import com.tech.kj.repository.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo adminRepo;
    private final ModelMapper modelMapper = new ModelMapper();
    @Override
    public UserEntity register(UserRegistrationDto userRegistrationDto) {
        UserEntity admin = modelMapper.map(userRegistrationDto, UserEntity.class);
        admin.setEmailAddress(userRegistrationDto.getEmail());
        ContactEntity contact = new ContactEntity(userRegistrationDto.getContactNumber());
        admin.getContactNumber().add(contact);
        contact.setPrimary(true);
        contact.setUser(admin);
        log.info("entity object after dto mapping {}",admin);

        return adminRepo.save(admin);
    }
}
