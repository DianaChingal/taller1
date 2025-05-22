package com.ejemplo.Products.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {
    
    private String nombre;
    
    private String descripcion;
    private double valor;

}
