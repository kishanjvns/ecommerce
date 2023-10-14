package com.tech.kj.repository;

import com.tech.kj.entity.BaseUserEntity;
import com.tech.kj.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthStoreRepository extends CrudRepository<UserEntity, UUID> {

}
