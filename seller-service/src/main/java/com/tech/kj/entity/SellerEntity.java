package com.tech.kj.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SellerEntity extends UserEntity {
    @Column(unique = true)
    private String gstNo;
}
