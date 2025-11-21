package com.transportsecure.service;

import com.transportsecure.MapperImplementation.PackageMapperImplm;
import com.transportsecure.dto.Pakage.CreatePackageDTO;
import com.transportsecure.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transportsecure.entity.Package;

@Service
public class PackageService {
    private PackageRepository packageRepository;
    private PackageMapperImplm packageMapper;

    public PackageService(PackageRepository packageRepository, PackageMapperImplm packageMapper) {
        this.packageRepository = packageRepository;
        this.packageMapper = packageMapper;
    }
    public Package createPackage(CreatePackageDTO createPackageDTO) {
        Package packag = packageMapper.toEntity(createPackageDTO);
        return packageRepository.save(packag);
    }
}
