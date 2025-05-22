package com.ejemplo.Products.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.Products.Entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
    
}
