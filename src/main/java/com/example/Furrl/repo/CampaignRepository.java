package com.example.Furrl.repo;

import com.example.Furrl.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign,Long> {
    List<Campaign> findByEndDateLessThan(LocalDateTime currentDate);
    List<Campaign> findByStartDateGreaterThan(LocalDateTime currentDate);
    List<Campaign> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDateTime currentDate, LocalDateTime date);
}
