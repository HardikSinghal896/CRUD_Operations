package com.example.Furrl.controller;

import com.example.Furrl.entity.Product;
import com.example.Furrl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getproduct")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/newproduct")
    public String CreateProduct(@RequestBody Product product){
        productService.addnewproduct(product);
        return "Poduct Created successfully";
    }
}