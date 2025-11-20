package com.transportsecure.mapper;

import com.transportsecure.dto.transtorter.ListTransporters;
import com.transportsecure.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TransporterMapper {
    List<ListTransporters> entityToDto(List<User> User);

}
