package com.ejemplo.products.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.products.dto.ProductDto;
import com.ejemplo.products.entity.Product;
import com.ejemplo.products.service.ProductService;



@RestController
@RequestMapping("api/v1/product")
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
    
    @GetMapping
    public ResponseEntity<List<Product>> listProduct() {
        List<Product> listProduct = productService.listProducts();
        return new ResponseEntity<>(listProduct, HttpStatus.OK);
    }
    
   @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,  @RequestBody ProductDto productDto) {
        Product updatedProduct = productService.updateProduct(id, productDto);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204: Eliminado con éxito
    }

    @GetMapping("/valor")
    public ResponseEntity<List<ProductDto>> getProductsByValor(@RequestParam double valor) {
        List<ProductDto> productos = productService.getProductsByValor(valor);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/name/{nombre}")
    public Product getByNombre(@PathVariable String nombre) {
        return productService.getByNombre(nombre);
    }

    @PutMapping("/stock/{id}")
    public ResponseEntity<Void> updateStock(@PathVariable Long id, @RequestParam int cantidad) {
        Product product = productService.getProductById(id);
        
        if (product.getStock() < cantidad) {
            return ResponseEntity.badRequest().build();
        }

        product.setStock(product.getStock() - cantidad);
        productService.save(product);
        return ResponseEntity.ok().build();
    }
    

}
