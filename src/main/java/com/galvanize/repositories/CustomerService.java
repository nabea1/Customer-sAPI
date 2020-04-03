package com.galvanize.repositories;

import com.galvanize.entities.CustomerService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerServiceDao extends JpaRepository<CustomerService, Long > {

}
