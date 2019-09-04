package com.davyd.site.dto.response;

import com.davyd.site.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String name;
    private String textDescription;
    private String image;
    private SubcategoryResponse subcategoryResponse;


    public ProductResponse(Product product) {
        id = product.getId();
        name = product.getName();
        textDescription = product.getTextDescription();
        image = product.getImage();
        subcategoryResponse = new SubcategoryResponse(product.getSubcategory());
    }
}
