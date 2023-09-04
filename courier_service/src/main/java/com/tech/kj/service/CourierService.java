package com.tech.kj.service;

import com.tech.kj.dto.UserRegistrationDto;
import com.tech.kj.entity.CourierEntity;

public interface CourierService {
    public CourierEntity register(UserRegistrationDto userRegistrationDto);
}
