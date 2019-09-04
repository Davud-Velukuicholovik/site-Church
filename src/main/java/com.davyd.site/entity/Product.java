package com.davyd.site.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    private String image;
    @Column(columnDefinition = "text")
    private String textDescription;
    @ManyToOne
    private Subcategory subcategory;
}
