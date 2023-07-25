package com.example.cardservice.controller;

import com.example.cardservice.dto.request.CustomerRequest;
import com.example.cardservice.dto.response.CustomerResponse;
import com.example.cardservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    private CustomerResponse create(@RequestBody CustomerRequest request) {
        return customerService.create(request);
    }

    @PutMapping("/{id}")
    private CustomerResponse update(@PathVariable(name = "id") Long id, @RequestBody CustomerRequest request) {
        return customerService.update(id, request);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable(name = "id") Long id) {
        customerService.delete(id);
    }

    @GetMapping("/{id}")
    private CustomerResponse update(@PathVariable(name = "id") Long id) {
        return customerService.getCustomerById(id);
    }

}
