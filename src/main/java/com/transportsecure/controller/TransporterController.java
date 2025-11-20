package com.transportsecure.controller;

import com.transportsecure.dto.transtorter.ListTransporters;
import com.transportsecure.dto.transtorter.UpdateTransporter;
import com.transportsecure.entity.User;
import com.transportsecure.mapper.TransporterMapper;
import com.transportsecure.service.TransporterService;
import com.transportsecure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/transporter")
public class TransporterController {
    private UserService userService;
    private TransporterService transporterService;

    public TransporterController(UserService userService, TransporterService transporterService) {
        this.userService = userService;
        this.transporterService = transporterService;
    }

    @GetMapping("/List")
    public List<ListTransporters> ListTransporters(Pageable pageable) {
        return transporterService.ListTransporters(pageable);
    }

    @PatchMapping("/{id}")
    public User updateTransporter(@PathVariable String id, @Validated @RequestBody UpdateTransporter updateTransporter) {
        return transporterService.updateTransporter(updateTransporter, id);
    }


}
