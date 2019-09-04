package com.davyd.site.entity;


import com.davyd.site.dto.response.ProductCountResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "__Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime time;
    private String phoneNumber;
    private String address;
    private Boolean finished;
//    private ProductCountResponse productCountResponse;
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order")
    private List<ProductCount> productCounts = new ArrayList<>();

    @ManyToMany(mappedBy = "orders")
    private List<ProductZbut> productZbuts = new ArrayList<>();

}
