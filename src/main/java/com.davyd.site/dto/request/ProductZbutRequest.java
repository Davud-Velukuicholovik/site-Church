package com.davyd.site.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class ProductZbutRequest {
    @NotBlank
    private String name;
    @NotBlank
    @Column(columnDefinition = "text")
    private String description;
    private String image;
    @Positive
    private Long price;
    @NotNull
    private Long subcategoryId;


}
