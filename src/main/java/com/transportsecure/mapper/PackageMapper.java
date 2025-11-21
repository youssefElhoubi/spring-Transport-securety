package com.transportsecure.mapper;

import com.transportsecure.dto.Pakage.CreatePackageDTO;
import com.transportsecure.entity.Package;
import org.mapstruct.Mapper;

@Mapper
public interface PackageMapper {
    Package toEntity(CreatePackageDTO dto);
    CreatePackageDTO toDto(Package entity);
}
