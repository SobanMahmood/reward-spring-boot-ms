package com.reward.controller;

import com.reward.model.RewardPoints;
import com.reward.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1")
public class RewardController {
    @Autowired
    private RewardService rewardService;

    @CrossOrigin
    @RequestMapping("reward/customer/{customerId}")
    public RewardPoints getReward(@PathVariable("customerId") Integer customerId) {
        return rewardService.getRewardPointsFor(customerId);
    }
}
