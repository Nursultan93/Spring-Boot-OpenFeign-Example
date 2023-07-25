package com.example.cardservice.service;

import com.example.cardservice.dto.request.CustomerRequest;
import com.example.cardservice.dto.response.CustomerResponse;
import com.example.cardservice.mapper.CustomerMapper;
import com.example.cardservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    CustomerMapper mapper = CustomerMapper.INSTANCE;

    public CustomerResponse create(CustomerRequest request) {

        var entity = mapper.customerRequestToCustomer(request);

        var customer = customerRepository.save(entity);

        return mapper.customerToCustomerResponse(customer);
    }

    public CustomerResponse update(Long id, CustomerRequest request) {

        var entity = customerRepository.findById(id).get();

        entity = mapper.customerRequestToCustomer(request);
        entity.setId(id);

        return mapper.customerToCustomerResponse(entity);


    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public CustomerResponse getCustomerById(Long id) {

        var customer = customerRepository.findById(id).get();

        return mapper.customerToCustomerResponse(customer);

    }
}
