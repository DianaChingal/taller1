package com.ejemplo.Products.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.Products.Dto.ProductDto;
import com.ejemplo.Products.Entity.Product;
import com.ejemplo.Products.Repository.ProductRepository;

@Service
public class ProductService {

    private ProductRepository productRepository; 
    
    public ProductService(ProductRepository productRepository ){
        this.productRepository = productRepository;
    }

     public Product createProduct(ProductDto producto) {
        Product product = new Product();
        product.setNombre(producto.getNombre());
        product.setDescripcion(producto.getDescripcion());
        product.setValor(producto.getValor());
        return productRepository.save(product);
    }
}
