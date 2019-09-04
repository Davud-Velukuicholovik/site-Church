package com.davyd.site.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductRequest {
    @NotBlank
    private String name;
    @NotBlank
    @Column(columnDefinition = "text")
    private String textDescription;
    private String image;
    @NotNull
    private Long subcategoryId;


}
