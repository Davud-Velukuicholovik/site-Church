package com.davyd.site.controller;

import com.davyd.site.dto.request.SubcategoryRequest;
import com.davyd.site.dto.response.SubcategoryResponse;
import com.davyd.site.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("subcategory")
public class SubcategoryController {

    @Autowired
    private SubcategoryService subcategoryService;

    @PostMapping
    public void save(@Valid @RequestBody SubcategoryRequest request) {
        subcategoryService.save(request);
    }

    @GetMapping("/byCategoryId/{categoryId}")
    public List<SubcategoryResponse> findAllByCategoryId(@PathVariable Long categoryId) {
        return subcategoryService.findAllByCategoryId(categoryId);
    }
    @GetMapping
    public List<SubcategoryResponse> findAll() {
        return subcategoryService.findAll();
    }
}
