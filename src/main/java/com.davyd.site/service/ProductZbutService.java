package com.davyd.site.service;

import com.davyd.site.dto.request.ProductRequest;
import com.davyd.site.dto.request.ProductZbutRequest;
import com.davyd.site.dto.response.PageResponse;
import com.davyd.site.dto.response.ProductResponse;
import com.davyd.site.dto.response.ProductZbutResponse;
import com.davyd.site.entity.Product;
import com.davyd.site.entity.ProductZbut;
import com.davyd.site.exception.NoMatchesException;
import com.davyd.site.repository.ProductRepository;
import com.davyd.site.repository.ProductZbutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductZbutService {

    @Autowired
    private ProductZbutRepository productZbutRepository;

    @Autowired
    private CategoryZbutService categoryZbutService;

    @Autowired
    private FileService fileService;

    public void save(ProductZbutRequest request) throws IOException {
        productZbutRepository.save(productZbutRequestToProductZbut(null, request));
    }
    public void update(ProductZbutRequest request, Long id) throws IOException {
        productZbutRepository.save(productZbutRequestToProductZbut(findOne(id), request));
    }

    public PageResponse<ProductZbutResponse> findPage(Integer page, Integer size, String fieldName, Sort.Direction direction) {
        Page<ProductZbut> data = productZbutRepository.findAll(PageRequest.of(page, size, direction, fieldName));
        List<ProductZbutResponse> collect = data.get().map(ProductZbutResponse::new).collect(Collectors.toList());
        return new PageResponse<>(data.getTotalElements(),data.getTotalPages(),collect);

    }
    public ProductZbutResponse findOneResponse(Long id) {
        return new ProductZbutResponse(findOne(id));
    }
    public ProductZbut findOne(Long id) {
        return productZbutRepository.findById(id).orElseThrow(() -> new NoMatchesException("Product with id " + id + " not exists"));
    }

    private ProductZbut productZbutRequestToProductZbut(ProductZbut productZbut, ProductZbutRequest request) throws IOException {
        if (productZbut == null) {
            productZbut = new ProductZbut();
        }
        if (request.getImage() != null) {
            productZbut.setImage(fileService.saveFile(request.getImage()));
        }
        productZbut.setName(request.getName());
        productZbut.setDescription(request.getDescription());
        productZbut.setCategoryZbut(categoryZbutService.findOne(request.getSubcategoryId()));
        return productZbut;
    }
//    public List<ProductResponse> findByCriteria(ProductCriteria criteria) {
//        return productRepository.findAll(new ProductSpecification(criteria), criteria.getPaginationRequest().toPageable())
//                .stream().map(ProductResponse::new).collect(Collectors.toList());
//    }
//    public PageResponse<ProductResponse> findPage(PaginationRequest paginationRequest) {
//        Page<Product> page = productRepository.findAll(paginationRequest.toPageable());
//        return new PageResponse<>(page.getTotalPages(),
//                page.getTotalElements(),
//                page.get().map(ProductResponse::new).collect(Collectors.toList()));
//    }

}
