package com.tech.kj.repository;

import com.tech.kj.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepo extends CrudRepository<UserEntity, UUID> {
    Optional<UserEntity> findByUserName(String userName);
}
