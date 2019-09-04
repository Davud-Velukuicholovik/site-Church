package com.davyd.site.repository;


import com.davyd.site.entity.ProductZbut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductZbutRepository extends JpaRepository<ProductZbut, Long> {
    @Query("from ProductZbut p join p.categoryZbut c where c.id=:categoryZbutId")
    List<ProductZbut> findAllByCategoryZbutId(@Param("categoryZbutId") Long categoryZbutId);
}
