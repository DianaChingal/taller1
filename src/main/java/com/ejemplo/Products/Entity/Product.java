package com.ejemplo.Products.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    private String id;
    private String nombre;
    private String descripcion;
    private double valor;
}
