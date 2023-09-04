package com.tech.kj.repository;

import com.tech.kj.entity.CourierEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface CourierRepo extends CrudRepository<CourierEntity, UUID> {
    Optional<CourierEntity> findByUserName(String userName);
}
