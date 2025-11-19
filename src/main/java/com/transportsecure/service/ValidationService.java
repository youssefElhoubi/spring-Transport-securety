package com.transportsecure.service;

import com.transportsecure.dto.CreateUserDTO;
import com.transportsecure.enums.Role;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service("validationService")
public class ValidationService {
    public void isValidSpecialty(CreateUserDTO user) {
        if (user.getRole().equals(Role.AMINE)) {
            if (user.getSpecialty()!=null){
                throw new RuntimeException("admin should not have a Specialty");
            }
        }else  {
            if (user.getSpecialty()==null){
                throw new RuntimeException("TRANSPORTER should have a Specialty");
            }
        }
    }
}
