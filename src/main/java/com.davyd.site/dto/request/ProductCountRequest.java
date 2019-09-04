package com.davyd.site.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCountRequest {
    private Long productZbutId;
    private Integer count;
}
