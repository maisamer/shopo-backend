package com.example.shopobackend.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Invoice extends BaseEntity{
    Double totalAmount;
    @OneToMany(mappedBy = "invoice")
    @JsonIgnore
    List<Item> items;
}
