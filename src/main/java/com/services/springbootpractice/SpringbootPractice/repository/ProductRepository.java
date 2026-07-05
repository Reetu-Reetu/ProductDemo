package com.services.springbootpractice.SpringbootPractice.repository;

import com.services.springbootpractice.SpringbootPractice.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);

}
