package com.transportsecure.controller;

import com.transportsecure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/transporter")
public class TransporterController {
    private UserService userService;

    public TransporterController(UserService userService) {
        this.userService = userService;
    }




}
