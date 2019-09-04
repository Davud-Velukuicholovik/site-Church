package com.davyd.site.controller;

import com.davyd.site.dto.request.CategoryRequest;
import com.davyd.site.dto.request.CategoryZbutRequest;
import com.davyd.site.dto.response.CategoryResponse;
import com.davyd.site.dto.response.CategoryZbutResponse;
import com.davyd.site.entity.CategoryZbut;
import com.davyd.site.service.CategoryService;
import com.davyd.site.service.CategoryZbutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("categoryProduct")
public class CategoryZbutController {

    @Autowired
    private CategoryZbutService categoryZbutService;

    @PostMapping
    public void save(@Valid @RequestBody CategoryZbutRequest request) {
        categoryZbutService.save(request);
    }

    @GetMapping
    public List<CategoryZbutResponse> findAll(@RequestParam(defaultValue = "id") String fieldName) {
        return categoryZbutService.findAll(fieldName);
    }

    @GetMapping("/one/{id}")
    public CategoryZbutResponse findOne(@PathVariable Long id) {
        return categoryZbutService.findOneResponse(id);
    }

    @GetMapping("/byName")
    public List<CategoryZbutResponse> findAllByName(@RequestParam String value) {
        return categoryZbutService.findAllByName(value);
    }

    @PutMapping
    public void update(@Valid @RequestBody CategoryZbutRequest request, Long id) {
        categoryZbutService.update(request, id);
    }

    @DeleteMapping
    public void delete(Long id) {
        categoryZbutService.delete(id);
    }

}

