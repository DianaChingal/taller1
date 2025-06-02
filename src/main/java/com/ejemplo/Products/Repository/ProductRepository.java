package com.ejemplo.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.products.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Long>{

   List<Product> findByValorGreaterThanEqual(double valor);
   Product findByNombre(String nombre);
   
}
