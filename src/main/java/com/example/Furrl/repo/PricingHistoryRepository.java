package com.example.Furrl.repo;

import com.example.Furrl.entity.PricingHistory;
import com.example.Furrl.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PricingHistoryRepository extends JpaRepository<PricingHistory,Long> {
    List<PricingHistory> findByProduct(Product product);
}
