package com.tech.kj.service;

import com.tech.kj.dto.UserRegistrationDto;
import com.tech.kj.entity.UserEntity;

public interface CustomerService {
    public UserEntity register(UserRegistrationDto userRegistrationDto);
}
