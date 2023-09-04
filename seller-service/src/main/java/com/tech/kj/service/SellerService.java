package com.tech.kj.service;

import com.tech.kj.controller.dto.SellerRegistrationDto;
import com.tech.kj.entity.SellerEntity;

public interface SellerService {
    public SellerEntity register(SellerRegistrationDto sellerRegistrationDto);
}
