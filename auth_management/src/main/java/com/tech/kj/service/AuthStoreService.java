package com.tech.kj.service;

import com.tech.kj.controller.dto.UserRegDto;
import com.tech.kj.entity.BaseUserEntity;
import com.tech.kj.entity.UserEntity;

public interface AuthStoreService {
    public UserEntity saveAuthDetail(UserRegDto userRegDto);
}
