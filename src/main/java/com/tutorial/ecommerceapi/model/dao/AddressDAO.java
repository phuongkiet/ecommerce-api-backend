package com.tutorial.ecommerceapi.model.dao;

import com.tutorial.ecommerceapi.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressDAO extends JpaRepository<Address, Long> {
    List<Address> findByLocalUser_Id(Long id);

}
