package com.tutorial.ecommerceapi.api.model;

public class LoginResponse {
    private String jwt;
    private boolean success;
    private String getFailureReason;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getGetFailureReason() {
        return getFailureReason;
    }

    public void setGetFailureReason(String getFailureReason) {
        this.getFailureReason = getFailureReason;
    }
}
