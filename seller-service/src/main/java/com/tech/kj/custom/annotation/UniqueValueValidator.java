package com.tech.kj.custom.annotation;

import com.tech.kj.entity.SellerEntity;
import com.tech.kj.repository.SellerEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Optional;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue,  Object> {
    @Autowired
    private SellerEntityRepo sellerRepo;
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        boolean flag = false;
        if(value instanceof String){
          Optional<SellerEntity> sellers = sellerRepo.findByUserName((String) value);// findAll().stream().parallel().filter(e->e.getUserName().equals((String) value) ).findAny();
          if(sellers.isEmpty()){
              flag = true;
          }
        }
        return flag;
    }
}
