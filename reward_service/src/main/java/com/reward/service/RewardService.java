package com.reward.service;

import com.reward.model.RewardPoints;

public interface RewardService {
    RewardPoints getRewardPointsFor(Integer customerId);
}
