package com.transportsecure.MapperImplementation;

import com.transportsecure.dto.Pakage.CreatePackageDTO;
import com.transportsecure.entity.Package;
import org.springframework.stereotype.Component;

@Component
public class PackageMapperImplm {
    public Package toEntity(CreatePackageDTO dto) {
        if (dto == null) {
            return null;
        }

        Package entity = new Package();

        entity.setType(dto.getType());
        entity.setWeight(dto.getWeight());
        entity.setDestination_address(dto.getDestination_address());
        entity.setCarrierId(dto.getCarrierId());

        switch (dto.getType()) {
            case FRAGILE:
                entity.setHandling_instructions(dto.getHandling_instructions());
                break;
            case FRIGO:
                entity.setTemperature_min(dto.getTemperature_min());
                entity.setTemperature_max(dto.getTemperature_max());
                break;
            case STANDARD:
                break;
            default:
                break;
        }

        return entity;
    }

    /**
     * Convertit une entité Package en un PackageResponseDTO (pour la réponse API).
     * @param entity L'entité Package à mapper.
     * @return Le DTO de réponse correspondant.
     */
    public CreatePackageDTO toDto(Package entity) {
        if (entity == null) {
            return null;
        }

        CreatePackageDTO dto = new CreatePackageDTO();

        dto.setType(entity.getType());
        dto.setWeight(entity.getWeight());
        dto.setDestination_address(entity.getDestination_address());
        dto.setCarrierId(entity.getCarrierId());
        if (entity.getHandling_instructions() != null) {
            dto.setHandling_instructions(entity.getHandling_instructions());
        }
        if (entity.getTemperature_min() != null) {
            dto.setTemperature_min(entity.getTemperature_min());
        }
        if (entity.getTemperature_max() != null) {
            dto.setTemperature_max(entity.getTemperature_max());
        }
        return dto;
    }
}
