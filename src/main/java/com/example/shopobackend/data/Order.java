package com.example.shopobackend.data;

import com.example.shopobackend.enums.OrderStatus;
import com.example.shopobackend.enums.PaymentType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order extends BaseEntity{
    @Enumerated(EnumType.STRING)
    PaymentType paymentType;
    @Enumerated(EnumType.STRING)
    OrderStatus status;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    Invoice invoice;
    @ManyToOne
    ShopoUser user;
}
