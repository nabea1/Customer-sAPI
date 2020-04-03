package com.galvanize;

import java.util.List;
import java.util.Optional;

import com.galvanize.entities.CustomerService;
import com.galvanize.repositories.CustomerServiceDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerServiceController {
    private CustomerServiceDao customerServiceDao;

    CustomerServiceController(CustomerServiceDao customerServiceDao) {
        this.customerServiceDao = customerServiceDao;
    }

    // POST
    @PostMapping("/api/service")
    CustomerService newCustomer(@RequestBody CustomerService newCustomerService) {
        return customerServiceDao.save(newCustomerService);
    }

    // GET all Customers
    @GetMapping("/api/service")
    List<CustomerService> all() {
        return customerServiceDao.findAll();
    }

    // GET single Customer
    @GetMapping("/api/service/{id}")
    Optional<CustomerService>one(@PathVariable Long id) {
        return customerServiceDao.findById(id);
    }

    // UPDATE
    @PutMapping("/api/service/{id}")
    Optional<CustomerService>assign(@RequestBody CustomerService newCustomer, @PathVariable Long id) {
        return customerServiceDao.findById(id)
                .map(customerService -> {
                    customerService.setTechnician(newCustomer.getTechnician());
                    return customerServiceDao.save(customerService);
                });
    }
}
