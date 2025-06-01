package com.ejemplo.products.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ejemplo.products.dto.ProductDto;
import com.ejemplo.products.entity.Product;
import com.ejemplo.products.repository.ProductRepository;

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
        product.setStock(producto.getStock());
        return productRepository.save(product);
    }

    public List<Product> listProducts(){
        return productRepository.findAll();
    }

    public Product updateProduct(Long id, ProductDto productDto) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setNombre(productDto.getNombre());
            product.setDescripcion(productDto.getDescripcion());
            product.setValor(productDto.getValor());
            product.setStock(productDto.getStock());
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Producto con ID " + id + " no encontrado.");
        }
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Producto con ID " + id + " no encontrado.");
        }
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto con ID " + id + " no encontrado."));
    }
    
    public List<ProductDto> getProductsByValor(double valor) {
        List<Product> productos = productRepository.findByValorGreaterThanEqual(valor);

        return productos.stream().map(product -> new ProductDto(
                product.getNombre(),
                product.getDescripcion(),
                product.getValor(),
                product.getStock()
        )).collect(Collectors.toList());
    }

    public Product getByNombre( String nombre){
        return productRepository.findByNombre(nombre);
    }
    
}
