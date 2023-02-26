package com.reward.model;

import java.util.HashMap;
import java.util.Map;

public class RewardPoints {
    private Long customerId;
    private Integer totalRewardPoints;
    private Map<String, Integer> monthlyRewardPoints;

    public RewardPoints(Long cId, Integer totalPoints, Map<String, Integer> monthlyPoints) {
        this. customerId = cId;
        this.totalRewardPoints = totalPoints;
        this.monthlyRewardPoints = monthlyPoints;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setTotalRewardPoints(Integer totalRewardPoints) {
        this.totalRewardPoints = totalRewardPoints;
    }

    public void setMonthlyRewardPoints(Map<String, Integer> monthlyRewardPoints) {
        this.monthlyRewardPoints = monthlyRewardPoints;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Integer getTotalRewardPoints() {
        return totalRewardPoints;
    }

    public Map<String, Integer> getMonthlyRewardPoints() {
        return monthlyRewardPoints;
    }
}
