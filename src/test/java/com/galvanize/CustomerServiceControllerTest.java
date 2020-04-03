package com.galvanize;

import com.galvanize.entities.CustomerService;
import com.galvanize.repositories.CustomerServiceDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.io.File;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerServiceControllerTest {
    @Autowired
    CustomerServiceDao customerServiceDao;

    @Test
    @Transactional
    void count() {
        Long count = customerServiceDao.count();
        assertEquals(2L, count);
    }

    @Test
    @Transactional
    void findAllServices() {
        List<CustomerService> customerServices = customerServiceDao.findAll();
        assertFalse(customerServices.isEmpty());
    }

    @Test
    @Transactional
    void existsById() {
        boolean exists = customerServiceDao.existsById(5L);
        assertTrue(exists);
    }

    @Test
    @Transactional
    void findServiceById() {
        Optional<CustomerService> customerService = customerServiceDao.findById(6L);
        assertTrue(customerService.isPresent());
        assertNotNull(customerService.get().getRequestNumber());
    }

    @Test
    @Transactional
    void createNewCustomerService() {
        CustomerService customerService = new CustomerService(2L, "Wanda Blake", "334 Westchester Rd. New York, NY 10103", "1234567890", "Tv is broken, please come fix");
        customerServiceDao.save(customerService);
        assertNotNull(customerService.getRequestNumber());
    }

    @Test
    @Transactional
    void deleteCustomerService() {
        CustomerService customerService = new CustomerService(2L, "Wanda Blake", "334 Westchester Rd. New York, NY 10103","1234567890", "Tv is broken, please come fix");
        customerService = customerServiceDao.save(customerService);
        long requestNumber = customerService.getRequestNumber();
        assertNotNull(requestNumber);
    }
}
