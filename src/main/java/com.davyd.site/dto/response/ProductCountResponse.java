package com.davyd.site.dto.response;

import com.davyd.site.entity.ProductCount;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductCountResponse {

    private Long id;
    @JsonProperty("productZbut")
    private ProductZbutResponse productZbutResponse;
    private Integer count;

    public ProductCountResponse(ProductCount productCount) {
        id = productCount.getId();
        productZbutResponse = new ProductZbutResponse(productCount.getProductZbut());
        count = productCount.getCount();
    }

}
