package com.davyd.site.service;

import com.davyd.site.dto.request.CategoryRequest;
import com.davyd.site.dto.request.CategoryZbutRequest;
import com.davyd.site.dto.response.CategoryResponse;
import com.davyd.site.dto.response.CategoryZbutResponse;
import com.davyd.site.entity.Category;
import com.davyd.site.entity.CategoryZbut;
import com.davyd.site.exception.HasDependenciesException;
import com.davyd.site.exception.NoMatchesException;
import com.davyd.site.repository.CategoryRepository;
import com.davyd.site.repository.CategoryZbutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryZbutService {

    @Autowired
    private CategoryZbutRepository categoryZbutRepository;

    public void save(CategoryZbutRequest request) {
        categoryZbutRepository.save(
                categoryZbutRequestToCategoryZbut(null, request));
    }
    public void update(CategoryZbutRequest request, Long id) {
        categoryZbutRepository.save(categoryZbutRequestToCategoryZbut(findOne(id), request));
    }

    public List<CategoryZbutResponse> findAll(String fieldName) {
        return categoryZbutRepository.findAll(Sort.by(fieldName)).stream()
                .map(CategoryZbutResponse::new)
                .collect(Collectors.toList());
    }
    public List<CategoryZbutResponse> findAllByName(String value) {
        return categoryZbutRepository.findAllByNameLike('%' + value + '%', Sort.by("name")).stream()
                .map(CategoryZbutResponse::new)
                .collect(Collectors.toList());
    }

    public CategoryZbutResponse findOneResponse(Long id) {
        return new CategoryZbutResponse(findOne(id));
    }


    public CategoryZbut findOne(Long id) {
        return categoryZbutRepository.findById(id).orElseThrow(() -> new NoMatchesException("Category with id " + id + " not exists"));
    }

    public void delete(Long id) {
      CategoryZbut categoryZbut = findOne(id);
        if (categoryZbut.getProductZbuts().isEmpty()) {
            categoryZbutRepository.delete(categoryZbut);
        } else {
            throw new HasDependenciesException("Cannot delete category with id " + id + " because it has dependencies");
        }
    }

    private CategoryZbut categoryZbutRequestToCategoryZbut(CategoryZbut categoryZbut, CategoryZbutRequest request) {
        if (categoryZbut == null) {
            categoryZbut = new CategoryZbut();
        }
        categoryZbut.setName(request.getName());
        return categoryZbut;
    }
}
