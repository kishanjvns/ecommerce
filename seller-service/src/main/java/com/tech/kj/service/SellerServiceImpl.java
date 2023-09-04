package com.tech.kj.service;

import com.tech.kj.controller.dto.SellerRegistrationDto;
import com.tech.kj.entity.ContactEntity;
import com.tech.kj.entity.SellerEntity;
import com.tech.kj.repository.SellerEntityRepo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SellerServiceImpl implements SellerService{

    @Autowired
    private SellerEntityRepo sellerRepo;
    private final ModelMapper modelMapper = new ModelMapper();
    @Override
    public SellerEntity register(SellerRegistrationDto sellerRegistrationDto) {
        SellerEntity seller = modelMapper.map(sellerRegistrationDto,SellerEntity.class);
        seller.setEmailAddress(sellerRegistrationDto.getEmail());
        ContactEntity contact = new ContactEntity(sellerRegistrationDto.getContactNumber());
        seller.getContactNumber().add(contact);
        contact.setPrimary(true);
        contact.setSeller(seller);
        log.info("entity object after dto mapping {}",seller);
        return sellerRepo.save(seller);
    }
}
