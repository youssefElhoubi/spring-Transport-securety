package com.transportsecure.dto.transtorter;

import com.transportsecure.enums.Role;
import com.transportsecure.enums.Specialty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class ListTransporters {
    private String id;
    private String email;
    private Role role;
    private boolean active;
    private Specialty specialty;
}
