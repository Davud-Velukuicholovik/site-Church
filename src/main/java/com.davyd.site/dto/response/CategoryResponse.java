package com.davyd.site.dto.response;

import com.davyd.site.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponse {
    private Long id;
    private String name;

    public CategoryResponse(Category category) {
        id = category.getId();
        name = category.getName();
    }
}
