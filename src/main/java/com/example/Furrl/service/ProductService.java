package com.example.Furrl.service;

import com.example.Furrl.entity.Campaign;
import com.example.Furrl.entity.PricingHistory;
import com.example.Furrl.entity.Product;
import com.example.Furrl.repo.CampaignRepository;
import com.example.Furrl.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private PricingService pricingService;
    @Autowired
    private CampaignRepository campaignRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {

        List<Product> allProducts = productRepository.findAll();
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

        return productRepository.findAll();
    }
    public String addnewproduct(Product product){
//        List<Campaign> campaigns = campaignService.getCurrentCampaigns(LocalDateTime.now());
//        List<PricingHistory> pricingHistories = new ArrayList<>();
//        double discountpercentage = 0;
//        for(int i=0;i<campaigns.size();i++){
//            discountpercentage += campaigns.get(i).getDiscountPercentage();
//            PricingHistory pricingHistory = new PricingHistory();
//            pricingHistory.setStartDate(campaigns.get(i).getStartDate());
//            pricingHistory.setEndDate(campaigns.get(i).getEndDate());
//            pricingHistory.setProduct(product);
//            pricingHistory.setPrice(product.getBasePrice());
//            pricingHistories.add(pricingHistory);
//        }
//        pricingService.addpricinghistory(pricingHistories);
        product.setDiscountedPrice(product.getBasePrice());
        productRepository.save(product);
        return "Product created successfully";
    }
}
