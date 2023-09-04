package com.tech.kj.service;

import com.tech.kj.dto.UserRegistrationDto;
import com.tech.kj.entity.AdminEntity;

public interface AdminService {
    public AdminEntity register(UserRegistrationDto userRegistrationDto);
}
