package com.example.cardservice.mapper;

import com.example.cardservice.domain.Customer;
import com.example.cardservice.dto.request.CustomerRequest;
import com.example.cardservice.dto.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );

    @Mapping(target = "name", source = "name")
    @Mapping(target = "surname", source = "surname")
    Customer customerRequestToCustomer(CustomerRequest request);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "surname", source = "surname")
    CustomerResponse customerToCustomerResponse(Customer customer);
}
