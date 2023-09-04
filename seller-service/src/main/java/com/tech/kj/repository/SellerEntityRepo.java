package com.tech.kj.repository;

import com.tech.kj.entity.SellerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SellerEntityRepo extends CrudRepository<SellerEntity, UUID> {
    Optional<SellerEntity> findByUserName(String userName);
}
