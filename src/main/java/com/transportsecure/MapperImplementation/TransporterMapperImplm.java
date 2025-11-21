package com.transportsecure.MapperImplementation;

import com.transportsecure.dto.transtorter.ListTransporters;
import com.transportsecure.entity.User;
import com.transportsecure.mapper.TransporterMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransporterMapperImplm implements TransporterMapper {
    @Override
    public List<ListTransporters> entityToDto(Page<User> users) {
        return users.stream().map(user ->{
            ListTransporters transporters = new ListTransporters();
            transporters.setId(user.getId());
            transporters.setEmail(user.getEmail());
            transporters.setRole(user.getRole());
            transporters.setSpecialty(user.getSpecialty());
            return transporters;
        }).toList();
    }
}
