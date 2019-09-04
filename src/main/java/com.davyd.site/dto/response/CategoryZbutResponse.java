package com.davyd.site.dto.response;

import com.davyd.site.entity.Category;
import com.davyd.site.entity.CategoryZbut;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryZbutResponse {
    private Long id;
    private String name;

    public CategoryZbutResponse(CategoryZbut categoryZbut) {
        id = categoryZbut.getId();
        name = categoryZbut.getName();
    }
}
