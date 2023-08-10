package com.example.Furrl.service;

import com.example.Furrl.entity.Campaign;
import com.example.Furrl.entity.PricingHistory;
import com.example.Furrl.entity.Product;
import com.example.Furrl.repo.CampaignRepository;
import com.example.Furrl.repo.PricingHistoryRepository;
import com.example.Furrl.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CampaignService {
    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private ProductService productService;
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    public List<Campaign> getPastCampaigns(LocalDateTime currentDate) {
        return campaignRepository.findByEndDateLessThan(currentDate);
    }

    public List<Campaign> getCurrentCampaigns(LocalDateTime currentDate) {
        return campaignRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(currentDate, currentDate);
    }

    public List<Campaign> getUpcomingCampaigns(LocalDateTime currentDate) {
        return campaignRepository.findByStartDateGreaterThan(currentDate);
    }

    public Campaign createCampaign(Campaign campaign){
        List<Product> allProducts = productService.getAllProducts();
        List<Campaign> campaigns = campaignRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDateTime.now(),LocalDateTime.now());
        double discountpercentage = 0;
        for(int i=0;i<campaigns.size();i++){
            discountpercentage += campaigns.get(i).getDiscountPercentage();
        }

        for(int j=0;j<allProducts.size();j++){
            Product product = allProducts.get(j);
            double finalDisCal = product.getBasePrice() - (discountpercentage*product.getBasePrice())/100;
            product.setDiscountedPrice(finalDisCal);
        }

        return campaignRepository.save(campaign);
    }
}