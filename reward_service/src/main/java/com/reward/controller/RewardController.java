package com.reward.controller;

import com.reward.model.RewardPoints;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;

@RestController
@RequestMapping("/reward")
public class RewardController {
    @RequestMapping("/{customerId}")
    public RewardPoints getReward(@PathVariable("customerId") String customerId) {
        // TODO: replace the dummy data with original data
        return new RewardPoints(1, 100, Collections.singletonMap("Feb2023", 100));
    }
}
