package com.davyd.site.service;

import com.davyd.site.dto.request.ProductRequest;
import com.davyd.site.dto.response.PageResponse;
import com.davyd.site.dto.response.ProductResponse;
import com.davyd.site.entity.Product;
import com.davyd.site.exception.NoMatchesException;
import com.davyd.site.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SubcategoryService subcategoryService;

    @Autowired
    private FileService fileService;

    public void save(ProductRequest request) throws IOException {
   productRepository.save(productRequestToProduct(null, request));
    }
    public void update(ProductRequest request, Long id) throws IOException {
        productRepository.save(productRequestToProduct(findOne(id), request));
    }

    public PageResponse<ProductResponse> findPage(Integer page, Integer size, String fieldName, Sort.Direction direction) {
        Page<Product> data = productRepository.findAll(PageRequest.of(page, size, direction, fieldName));
        List<ProductResponse> collect = data.get().map(ProductResponse::new).collect(Collectors.toList());
        return new PageResponse<>(data.getTotalElements(),data.getTotalPages(),collect);

    }
    public ProductResponse findOneResponse(Long id) {
        return new ProductResponse(findOne(id));
    }
    public Product findOne(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NoMatchesException("Product with id " + id + " not exists"));
    }

    private Product productRequestToProduct(Product product, ProductRequest request) throws IOException {
        if (product == null) {
            product = new Product();
        }
        if (request.getImage() != null) {
            product.setImage(fileService.saveFile(request.getImage()));
        }
        product.setName(request.getName());
        product.setTextDescription(request.getTextDescription());
        product.setSubcategory(subcategoryService.findOne(request.getSubcategoryId()));
        return product;
    }

}
