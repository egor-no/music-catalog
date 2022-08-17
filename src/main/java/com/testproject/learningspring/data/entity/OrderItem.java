package com.testproject.learningspring.data.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ORDER_ITEMS")
@IdClass(OrderItem.class)
public class OrderItem implements Serializable {

    @Id
    @Column(name="ORDER_ID")
    private long orderId;

    @Id
    @Column(name="FORMAT_ID")
    private long formatId;

    @Column(name="QUANTITY")
    private int quantity;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getFormatId() {
        return formatId;
    }

    public void setFormatId(long formatId) {
        this.formatId = formatId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
