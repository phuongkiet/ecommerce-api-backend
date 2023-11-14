package com.tutorial.ecommerceapi.service;

import com.tutorial.ecommerceapi.model.LocalUser;
import com.tutorial.ecommerceapi.model.WebOrder;
import com.tutorial.ecommerceapi.model.dao.WebOrderDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private WebOrderDAO webOrderDAO;

    public OrderService(WebOrderDAO webOrderDAO) {
        this.webOrderDAO = webOrderDAO;
    }

    public List<WebOrder> getOrders(LocalUser localUser){
        return webOrderDAO.findByUser(localUser);
    }
}
