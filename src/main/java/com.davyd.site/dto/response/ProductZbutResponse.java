package com.davyd.site.dto.response;

import com.davyd.site.entity.Product;
import com.davyd.site.entity.ProductZbut;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductZbutResponse {
    private Long id;
    private String name;
    private String description;
    private String image;
    private Long price;
    private CategoryZbutResponse categoryZbutResponse;


    public ProductZbutResponse(ProductZbut productZbut) {
        id = productZbut.getId();
        name = productZbut.getName();
        description = productZbut.getDescription();
        image = productZbut.getImage();
        price = productZbut.getPrice();
        categoryZbutResponse = new CategoryZbutResponse(productZbut.getCategoryZbut());
    }
}
