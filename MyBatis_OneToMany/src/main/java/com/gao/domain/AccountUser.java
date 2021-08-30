package com.gao.domain;

import java.io.Serializable;

/**
 * @author gaols
 * @version 1.0
 * @date 2021/8/22 18:07
 */
public class AccountUser extends Account implements Serializable {
    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString()+"       AccountUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
