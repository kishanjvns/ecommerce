package com.tech.kj.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AdminEntity extends UserEntity {
    @Column(name = "is_root")
    private boolean isRootAdmin;
}
