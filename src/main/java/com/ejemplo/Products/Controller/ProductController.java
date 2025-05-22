package com.ejemplo.Products.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.Products.Dto.ProductDto;
import com.ejemplo.Products.Entity.Product;
import com.ejemplo.Products.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("API/v1/product")
public class ProductController {

    private ProductService productService;
    
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto producto) {
        Product createdProduct = productService.createProduct(producto);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }
   
    

}
