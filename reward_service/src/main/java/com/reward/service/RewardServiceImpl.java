package com.reward.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reward.model.RewardPoints;
import com.reward.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class RewardServiceImpl implements RewardService{
    @Autowired
    private RestTemplate restTemplate;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");

    @Override
    public RewardPoints getRewardPointsFor(Integer customerId) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode transactionsJson = restTemplate.getForObject("http://localhost:9002/api/v1/transactions/customer/" + customerId, JsonNode.class);
        List<Transaction> transactions = mapper.convertValue(
                transactionsJson,
                new TypeReference<List<Transaction>>(){}
        );

        int totalPoints = 0;
        HashMap<String, Integer> monthlyRewards = new HashMap<>();
        for(int i=0;i<transactions.size();i++) {
            int above50 = 0;
            int above100 = 0;
            Transaction transaction = transactions.get(i);
            if(transaction.getAmount()>100) {
                above100 = (int)Math.floor(transaction.getAmount()) - 100;
            }
            if(transaction.getAmount()>50) {
                above50 = (int)Math.floor(transaction.getAmount()) - 50;
            }

            int points = above50 + above100;
            if(points>0) {
                String stringDate = dateFormat.format(transaction.getDate());
                monthlyRewards.put(stringDate, monthlyRewards.getOrDefault(stringDate, 0) + points);
            }
            totalPoints += points;
        }
        RewardPoints rewardPoints = new RewardPoints(customerId, totalPoints, monthlyRewards);
        return rewardPoints;
    }
}
