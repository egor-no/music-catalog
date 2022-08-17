package com.testproject.learningspring.business.domain;

import com.testproject.learningspring.data.entity.Format;

import java.util.HashMap;
import java.util.Map;

public class OrderDAO {

    private Map<Long, Integer> items;
    private String firstName;
    private String lastName;
    private String address;

    public Map<Long, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Long, Integer> items) {
        this.items = items;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
