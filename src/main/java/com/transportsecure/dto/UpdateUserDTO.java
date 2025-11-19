package com.transportsecure.dto;

import com.transportsecure.enums.Specialty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserDTO {
    @NotBlank(message = "Id is required to complete this process")
    private String id;
    @Size(min = 6,message = "password must at leat 6 characters ")
    private String oldPassword;
    @Size(min = 6,message = "password must at leat 6 characters ")
    private String newPassword;
    @Size(min = 6,message = "password must at leat 6 characters ")
    private String confirmPassword;
    private boolean active;
    private Specialty specialty;
}
