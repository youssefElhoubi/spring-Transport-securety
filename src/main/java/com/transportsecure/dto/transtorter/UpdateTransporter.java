package com.transportsecure.dto.transtorter;

import com.transportsecure.enums.Specialty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTransporter {
    @NotNull(message = "specialty should not be empty")
    @NotBlank(message = "specialty should not be blank")
    private Specialty specialty;
    private boolean active;
}
