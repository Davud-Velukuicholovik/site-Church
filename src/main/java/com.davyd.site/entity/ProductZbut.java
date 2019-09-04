package com.davyd.site.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

@Entity
public class ProductZbut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    private String image;
    @Positive
    private Long price;
    @Column(columnDefinition = "text")
    private String description;
    @ManyToOne
    private CategoryZbut categoryZbut;
    @OneToMany(mappedBy = "productZbut")
    private List<ProductCount> productCounts = new ArrayList<>();
    @ManyToMany
    private List <Order> orders = new ArrayList<>();
//    @ManyToMany(mappedBy = "productZbuts")
//    private List<User> users = new ArrayList<>();
}
