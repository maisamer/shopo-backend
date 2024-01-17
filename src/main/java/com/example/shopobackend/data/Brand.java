package com.example.shopobackend.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Brand extends BaseEntity{
    private String name;
    private String logoUrl;
    private String mobileNumber;
    @OneToMany(mappedBy = "brand")
    @JsonIgnore
    private List<Product> products;
}
