package com.davyd.site.controller;

import com.davyd.site.dto.request.ProductRequest;
import com.davyd.site.dto.request.ProductZbutRequest;
import com.davyd.site.dto.response.PageResponse;
import com.davyd.site.dto.response.ProductResponse;
import com.davyd.site.dto.response.ProductZbutResponse;
import com.davyd.site.entity.ProductZbut;
import com.davyd.site.service.ProductService;
import com.davyd.site.service.ProductZbutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("productZbut")
public class ProductZbutController {

    @Autowired
    private ProductZbutService productZbutService;

    @PostMapping
    public void save(@Valid @RequestBody ProductZbutRequest request) throws IOException {
        productZbutService.save(request);
    }
    @PutMapping
    public void update(@Valid @RequestBody ProductZbutRequest request, Long id) throws IOException {
        productZbutService.update(request, id);
    }
    @GetMapping
    public PageResponse<ProductZbutResponse> findPage(
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam(defaultValue = "name") String fieldName,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction
            ) {
        return productZbutService.findPage(page, size, fieldName, direction);
    }


    @GetMapping("/one/{id}")
    public ProductZbutResponse findOne(@PathVariable Long id) {
        return productZbutService.findOneResponse(id);
    }

    //    @PostMapping("/findByFilter")
//    public List<ProductResponse> findByFilter(@Valid @RequestBody ProductCriteria productCriteria) {
//        return productService.findByCriteria(productCriteria);
//    }
}
