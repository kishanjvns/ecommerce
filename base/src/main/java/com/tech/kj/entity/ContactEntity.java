package com.tech.kj.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ContactEntity extends BaseEntity {

    private String contactNumber;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private UserEntity user;

    private boolean isPrimary;

    public ContactEntity(String contactNumber){
        this.contactNumber = contactNumber;
    }
}
