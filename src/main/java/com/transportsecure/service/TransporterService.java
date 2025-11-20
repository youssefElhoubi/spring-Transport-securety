package com.transportsecure.service;

import com.transportsecure.MapperImplementation.TransporterMapperImplm;
import com.transportsecure.dto.transtorter.ListTransporters;
import com.transportsecure.dto.transtorter.UpdateTransporter;
import com.transportsecure.entity.User;
import com.transportsecure.enums.Role;
import com.transportsecure.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransporterService {
    private UserRepository userService;
    private TransporterMapperImplm transporterMapper;

    public TransporterService(UserRepository userService, TransporterMapperImplm transporterMapper) {
        this.userService = userService;
        this.transporterMapper = transporterMapper;
    }

    public User updateTransporter(UpdateTransporter updateTransporter, String id) {
        User transporter = userService.findById(id).orElseThrow(() -> new RuntimeException("user was not found"));
        transporter.setSpecialty(updateTransporter.getSpecialty());
        transporter.setActive(updateTransporter.isActive());
        userService.save(transporter);
        return transporter;
    }
    public List<ListTransporters> ListTransporters(){
        List<User> list = userService.findAllByRole(Role.ADMIN);
        return transporterMapper.entityToDto(list);
    }
}
