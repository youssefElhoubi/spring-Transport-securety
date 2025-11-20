package com.transportsecure.MapperImplementation;

import com.transportsecure.dto.transtorter.ListTransporters;
import com.transportsecure.entity.User;
import com.transportsecure.mapper.TransporterMapper;

import java.util.ArrayList;
import java.util.List;

public class TransporterMapperImplm implements TransporterMapper {
    @Override
    public List<ListTransporters> entityToDto(List<User> users) {
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
