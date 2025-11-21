package com.transportsecure.dto.Pakage;

import com.transportsecure.enums.Type;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePackageDTO {
    @NotEmpty
    @NotBlank(message = "type Should not be empty")
    private Type type;
    @NotNull
    @Min(value = 10,message = "weight should not be less than 10")
    @Max(value=20,message = "weight should not be over than 20")
    private Double weight;
    @NotEmpty
    @NotBlank(message = "destination_address should not be empty")
    private String destination_address;
    private String handling_instructions;
    private Double temperature_min;
    private Double temperature_max;
    @NotBlank(message = "carrierId should not be empty")
    private String carrierId;
}
