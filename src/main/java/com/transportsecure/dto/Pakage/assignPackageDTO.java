package com.transportsecure.dto.Pakage;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class assignPackageDTO {
    @NotBlank
    private String transporterId;
}
