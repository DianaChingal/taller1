package com.ejemplo.Products.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.Products.Entity.Product;



public interface ProductRepository extends JpaRepository<Product, Long>{

   List<Product> findByValorGreaterThanEqual(double valor);
}
