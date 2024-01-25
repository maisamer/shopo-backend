package com.example.shopobackend.data;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Item extends BaseEntity{
    Integer quantity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    Product product;
    @ManyToOne
    Invoice invoice;
}
