package com.tech.kj.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserEntity extends BaseEntity {
    private String firstName;
    private String lastName;

    private String country;

    @OneToMany(mappedBy ="user" ,cascade = CascadeType.ALL)
    private List<ContactEntity> contactNumber = new ArrayList<>();

    private String emailAddress;

    private String profilePictureUrl;

    @Column(unique = true)
    private String userName;

}
