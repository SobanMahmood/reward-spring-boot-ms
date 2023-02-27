package com.reward.model;

import java.util.HashMap;
import java.util.Map;

public class RewardPoints {
    private Integer customerId;
    private Integer totalRewardPoints;
    private Map<String, Integer> monthlyRewardPoints;

    public RewardPoints(Integer cId, Integer totalPoints, Map<String, Integer> monthlyPoints) {
        this. customerId = cId;
        this.totalRewardPoints = totalPoints;
        this.monthlyRewardPoints = monthlyPoints;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setTotalRewardPoints(Integer totalRewardPoints) {
        this.totalRewardPoints = totalRewardPoints;
    }

    public void setMonthlyRewardPoints(Map<String, Integer> monthlyRewardPoints) {
        this.monthlyRewardPoints = monthlyRewardPoints;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getTotalRewardPoints() {
        return totalRewardPoints;
    }

    public Map<String, Integer> getMonthlyRewardPoints() {
        return monthlyRewardPoints;
    }
}
