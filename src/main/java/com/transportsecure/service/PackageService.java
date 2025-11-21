package com.transportsecure.service;

import com.transportsecure.MapperImplementation.PackageMapperImplm;
import com.transportsecure.dto.Pakage.AssignPackageDTO;
import com.transportsecure.dto.Pakage.CreatePackageDTO;
import com.transportsecure.entity.User;
import com.transportsecure.repository.PackageRepository;
import com.transportsecure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transportsecure.entity.Package;

@Service
public class PackageService {
    private PackageRepository packageRepository;
    private PackageMapperImplm packageMapper;
    private UserRepository userRepository;

    public PackageService(PackageRepository packageRepository, PackageMapperImplm packageMapper, UserRepository userRepository) {
        this.packageRepository = packageRepository;
        this.packageMapper = packageMapper;
        this.userRepository = userRepository;
    }
    public Package createPackage(CreatePackageDTO createPackageDTO) {
        Package packag = packageMapper.toEntity(createPackageDTO);
        return packageRepository.save(packag);
    }
    public Package assignPackage(String id, AssignPackageDTO dto) {
        User user = userRepository.findById(dto.getTransporterId()).orElseThrow(() -> new RuntimeException("User not found"));
        Package packag = packageRepository.findById(id).orElseThrow(() -> new RuntimeException("Package not found"));
        packag.setCarrierId(user.getId());
        packageRepository.save(packag);
        return packag;
    }
}
