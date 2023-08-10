package com.example.Furrl.controller;

import com.example.Furrl.entity.Campaign;
import com.example.Furrl.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {
    @Autowired
    private CampaignService campaignService;

    @PostMapping("/AddCampaign")
    public Campaign createCampaign(@RequestBody Campaign campaign){
        return campaignService.createCampaign(campaign);
    }

    @GetMapping
    public List<Campaign> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }

    @GetMapping("/past")
    public List<Campaign> getPastCampaigns() {
        return campaignService.getPastCampaigns(LocalDateTime.now());
    }

    @GetMapping("/current")
    public List<Campaign> getCurrentCampaigns() {
        return campaignService.getCurrentCampaigns(LocalDateTime.now());
    }

    @GetMapping("/upcoming")
    public List<Campaign> getUpcomingCampaigns() {
        return campaignService.getUpcomingCampaigns(LocalDateTime.now());
    }
}

