package com.davyd.site.repository;



import com.davyd.site.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("from Product p join p.subcategory s join s.category c where c.id=:categoryId")
    List<Product> findAllByCategoryId(@Param("categoryId") Long categoryId);
}
