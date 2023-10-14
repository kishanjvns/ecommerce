package com.tech.kj.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name= "user_table")
@Setter
@Getter
public class UserEntity extends BaseUserEntity{
    @Column(name = "user_id",unique = true)
    private String userId;

}
