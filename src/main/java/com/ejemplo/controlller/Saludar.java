package com.ejemplo.controlller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/student")
public class Saludar {
    @GetMapping("saludar")
    
    public String saludar(){
        return "hola mundo";
    }

}
