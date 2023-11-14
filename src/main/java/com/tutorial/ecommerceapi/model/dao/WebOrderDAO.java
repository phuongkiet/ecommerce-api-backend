package com.tutorial.ecommerceapi.model.dao;

import com.tutorial.ecommerceapi.model.LocalUser;
import com.tutorial.ecommerceapi.model.WebOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WebOrderDAO extends JpaRepository<WebOrder, Long> {
    List<WebOrder> findByUser(LocalUser user);

}
