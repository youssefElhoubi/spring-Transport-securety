package com.transportsecure.controller;

import com.transportsecure.dto.Pakage.AssignPackageDTO;
import com.transportsecure.dto.Pakage.CreatePackageDTO;
import com.transportsecure.service.PackageService;
import jakarta.validation.Valid;
import org.hibernate.validator.internal.util.stereotypes.ThreadSafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/colis/{id}/assign")
    public ResponseEntity<?> assignPackage(@PathVariable("id") String id, @Valid @RequestBody AssignPackageDTO dto) {
        packageService.assignPackage(id, dto);
        return ResponseEntity.ok("Package assigned successfully");
    }

    @DeleteMapping("colis/delete/{id}")
    public ResponseEntity<?> deletePackage(@PathVariable("id") String id) {
        String result = packageService.deletePackage(id);
        HashMap<String, Object> response = new HashMap<String, Object>();
        response.put("message", result);
        return ResponseEntity.ok("Package deleted successfully");
    }
}
