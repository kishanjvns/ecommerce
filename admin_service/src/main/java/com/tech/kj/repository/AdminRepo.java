package com.tech.kj.repository;

import com.tech.kj.entity.AdminEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface AdminRepo extends CrudRepository<AdminEntity, UUID> {
    Optional<AdminEntity> findByUserName(String userName);
}
