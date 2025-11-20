package com.transportsecure.dto.transtorter;

import com.transportsecure.enums.Role;
import com.transportsecure.enums.Specialty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListTransporters {
    private String id;
    private String email;
    private Role role;
    private boolean active;
    private Specialty specialty;
}
