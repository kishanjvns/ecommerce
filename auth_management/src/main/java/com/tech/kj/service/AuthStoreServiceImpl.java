package com.tech.kj.service;

import com.tech.kj.controller.dto.UserRegDto;
import com.tech.kj.entity.BaseUserEntity;
import com.tech.kj.entity.UserEntity;
import com.tech.kj.repository.AuthStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthStoreServiceImpl implements AuthStoreService{
    @Autowired
    private AuthStoreRepository authStoreRepository;
    @Override
    public UserEntity saveAuthDetail(UserRegDto userRegDto) {
        UserEntity baseUserEntity = new UserEntity();
        baseUserEntity.setUserName(userRegDto.getUserName());
        baseUserEntity.setPassword(userRegDto.getPassword());
        baseUserEntity.setUserId(userRegDto.getId().toString());
        UserEntity createdUserEntity = authStoreRepository.save(baseUserEntity);
        return createdUserEntity;
    }
}
