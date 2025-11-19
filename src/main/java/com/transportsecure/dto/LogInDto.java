package com.transportsecure.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogInDto {
    @NotBlank(message = "email must not be blank")
    private String  email;
    @Size(min = 6,message = "password must be at least 6 characters long")
    private String password;
}
