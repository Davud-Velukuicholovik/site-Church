package com.davyd.site.repository;

import com.davyd.site.entity.Category;
import com.davyd.site.entity.CategoryZbut;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryZbutRepository extends JpaRepository<CategoryZbut, Long> {
    List<CategoryZbut> findAllByNameLike(String name, Sort sort);

}
