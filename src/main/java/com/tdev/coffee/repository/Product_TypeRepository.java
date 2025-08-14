package com.tdev.coffee.repository;

import com.tdev.coffee.entity.Product_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_TypeRepository extends JpaRepository<Product_Type, Integer> {

}
