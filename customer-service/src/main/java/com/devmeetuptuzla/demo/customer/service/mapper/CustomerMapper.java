package com.devmeetuptuzla.demo.customer.service.mapper;

import com.devmeetuptuzla.demo.customer.entity.Customer;
import com.devmeetuptuzla.demo.customer.service.dto.CustomerCreateDTO;
import com.devmeetuptuzla.demo.customer.service.dto.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    Customer toEntity(CustomerCreateDTO customerCreateDTO);

    @Mapping(target = "accounts", ignore = true)
    CustomerDTO toDTO(Customer customer);
}
