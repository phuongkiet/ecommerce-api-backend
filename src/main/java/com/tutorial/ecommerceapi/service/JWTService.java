package com.tutorial.ecommerceapi.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tutorial.ecommerceapi.model.LocalUser;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JWTService {

    @Value("${jwt.algorithm.key}")
    private String secretKey;
    @Value("${jwt.issuer}")
    private String issuer;
    @Value("${jwt.expiryInSeconds}")
    private int expiryInSeconds;
    private static final String USERNAME_KEY = "USERNAME";
    private static final String VERIFICATION_EMAIL_KEY = "VERIFICATION_EMAIL";
    private static final String RESET_PASSWORD_EMAIL_KEY = "RESET_PASSWORD_EMAIL";

    @PostConstruct
    public void postConstruct(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String generateJWT(LocalUser user){
        // Get the authorities from the user
        List<String> authorities = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return JWT.create().withClaim(USERNAME_KEY, user.getUsername())
                .withClaim("roles", authorities)
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000 * expiryInSeconds)))
                .withIssuer(issuer)
                .sign(Algorithm.HMAC256(secretKey));
    }

    public String generateVerificationJWT(LocalUser user){

        return JWT.create().withClaim(VERIFICATION_EMAIL_KEY, user.getEmail())
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000 * expiryInSeconds)))
                .withIssuer(issuer)
                .sign(Algorithm.HMAC256(secretKey));
    }

    public String generatePasswordResetJWT(LocalUser user){
        return JWT.create().withClaim(RESET_PASSWORD_EMAIL_KEY, user.getEmail())
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000 * 60 * 30)))
                .withIssuer(issuer)
                .sign(Algorithm.HMAC256(secretKey));
    }

    public String getResetPasswordEmail(String token){
        DecodedJWT jwt = JWT.require(Algorithm.HMAC256(secretKey)).withIssuer(issuer).build().verify(token);
        return jwt.getClaim(RESET_PASSWORD_EMAIL_KEY).asString();
    }

    public String getUsername(String token){
        DecodedJWT jwt = JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token);
        return JWT.decode(token).getClaim(USERNAME_KEY).asString();
    }

 }
