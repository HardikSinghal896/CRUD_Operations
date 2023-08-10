package com.example.Furrl.controller;

import com.example.Furrl.entity.PricingHistory;
import com.example.Furrl.entity.Product;
import com.example.Furrl.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pricing-history")
public class PricingHistoryController {
    @Autowired
    private  PricingService pricingService;


    @GetMapping("/{productId}")
    public List<PricingHistory> getPricingHistory(@PathVariable Long productId) {
        Product product = new Product();
        product.setId(productId); // Fetch the actual product using ProductService
        return pricingService.getPricingHistoryForProduct(product);
    }
}