package com.transportsecure.service;

import com.transportsecure.dto.CreateUserDTO;
import com.transportsecure.enums.Role;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service("validationService")
public class ValidationService {
    public boolean isValidSpecialty(CreateUserDTO user) {
        if (user.getRole().equals(Role.ADMIN)) {
            return user.getSpecialty() == null;
        }else  {
            return user.getSpecialty() != null;
        }
    }
}
