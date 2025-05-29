package com.ejemplo.Products.Controller;

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

import com.ejemplo.Products.Dto.ProductDto;
import com.ejemplo.Products.Entity.Product;
import com.ejemplo.Products.Service.ProductService;



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

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/valor")
    public ResponseEntity<List<ProductDto>> getProductsByValor(@RequestParam double valor) {
        List<ProductDto> productos = productService.getProductsByValor(valor);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

}
