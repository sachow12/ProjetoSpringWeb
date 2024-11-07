package com.webservices.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.webservices.Model.Enum.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor

@EqualsAndHashCode
@Entity
@Table(name ="tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant buyMoment;
    private Integer orderStatus;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getBuyMoment() {
        return buyMoment;
    }

    public void setBuyMoment(Instant buyMoment) {
        this.buyMoment = buyMoment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Order(Long id, Instant buyMoment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.buyMoment = buyMoment;
        setOrderStatus(orderStatus);
        this.client = client;
    }
}
