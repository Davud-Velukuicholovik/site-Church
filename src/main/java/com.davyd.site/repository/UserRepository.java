package com.davyd.site.repository;


import com.davyd.site.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    List<User> findAllByCategoryId(Long categoryId);
}
