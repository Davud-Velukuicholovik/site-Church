package com.davyd.site.dto.response;

import com.davyd.site.entity.Subcategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubcategoryResponse {
    private Long id;
    private String name;
    private Long categoryId;

    public SubcategoryResponse(Subcategory subcategory) {
        id = subcategory.getId();
        name = subcategory.getName();
        categoryId = subcategory.getCategory().getId();
    }
}
