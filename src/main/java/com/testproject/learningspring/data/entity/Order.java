package com.testproject.learningspring.data.entity;

import javax.persistence.*;

@Entity
@Table(name="ORDERZ")
public class Order {

    @Id
    @Column(name="ORDER_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long orderId;

    @Column(name="CLIENT_ID")
    private long clientId;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }
}
