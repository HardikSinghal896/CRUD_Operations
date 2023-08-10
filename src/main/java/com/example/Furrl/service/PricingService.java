package com.example.Furrl.service;

import com.example.Furrl.entity.PricingHistory;
import com.example.Furrl.entity.Product;
import com.example.Furrl.repo.PricingHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingService {
    @Autowired
    private final PricingHistoryRepository pricingHistoryRepository;

    public PricingService(PricingHistoryRepository pricingHistoryRepository) {
        this.pricingHistoryRepository = pricingHistoryRepository;
    }

    public List<PricingHistory> getPricingHistoryForProduct(Product product) {
        return pricingHistoryRepository.findByProduct(product);
    }
    public List<PricingHistory> addpricinghistory(List<PricingHistory> pricingHistories)
    {
        return pricingHistoryRepository.saveAll(pricingHistories);
    }
}