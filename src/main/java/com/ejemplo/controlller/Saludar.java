package com.ejemplo.controlller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/v1")
public class Saludar {
    @GetMapping("saludar")
    
    public String saludar(){
        return "hola mundo";
    }

}
