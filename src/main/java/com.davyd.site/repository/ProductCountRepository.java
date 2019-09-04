package com.davyd.site.repository;

import com.davyd.site.entity.ProductCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCountRepository extends JpaRepository<ProductCount, Long> {
}
