package com.csr.simpleauth.responseDataType;

import com.csr.simpleauth.entity.User;

public class UserResponse {
    private String responseStatus;
    private int responseCode;
    private User data;

    public UserResponse(String responseStatus, int responseCode, User data) {
        this.responseStatus = responseStatus;
        this.responseCode = responseCode;
        this.data = data;
    }

    public UserResponse() {
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
