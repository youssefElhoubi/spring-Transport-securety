package com.transportsecure.controller;

import com.transportsecure.dto.Pakage.CreatePackageDTO;
import com.transportsecure.service.PackageService;
import org.hibernate.validator.internal.util.stereotypes.ThreadSafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/admin")
public class PackageController {
    private PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }
    @PostMapping("colis")
    public ResponseEntity<?> createPackage(CreatePackageDTO dto) {
        packageService.createPackage(dto);
        HashMap<String, Object> response = new HashMap<String, Object>();
        response.put("message", "Package created successfully");

        return ResponseEntity.ok(response);
    }
}
