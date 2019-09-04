package com.davyd.site.controller;

import com.davyd.site.dto.request.CategoryRequest;
import com.davyd.site.dto.response.CategoryResponse;
import com.davyd.site.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public void save(@Valid @RequestBody CategoryRequest request) {
        categoryService.save(request);
    }

    @GetMapping
    public List<CategoryResponse> findAll(@RequestParam(defaultValue = "id") String fieldName) {
        return categoryService.findAll(fieldName);
    }

    @GetMapping("/one/{id}")
    public CategoryResponse findOne(@PathVariable Long id) {
        return categoryService.findOneResponse(id);
    }

    @GetMapping("/byName")
    public List<CategoryResponse> findAllByName(@RequestParam String value) {
        return categoryService.findAllByName(value);
    }

    @PutMapping
    public void update(@Valid @RequestBody CategoryRequest request, Long id) {
        categoryService.update(request, id);
    }

    @DeleteMapping
    public void delete(Long id) {
        categoryService.delete(id);
    }

}

