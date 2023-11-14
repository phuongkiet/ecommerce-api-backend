package com.tutorial.ecommerceapi.model.dao;

import com.tutorial.ecommerceapi.model.LocalUser;
import com.tutorial.ecommerceapi.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerificationTokenDAO extends JpaRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);

    public void deleteByUser(LocalUser user);



}
