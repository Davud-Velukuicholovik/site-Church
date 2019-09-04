package com.davyd.site.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class OrderRequest {
    @NotNull
    @NumberFormat
    private String phoneNumber;
    @NotNull
    private String address;
    @NotEmpty
    @JsonProperty("products")
    private List<ProductCountRequest> productCountRequests;
}
