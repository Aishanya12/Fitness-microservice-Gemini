package com.example.aiservice.service;

import com.example.aiservice.model.Activity;
import com.example.aiservice.model.Recommendation;
import com.example.aiservice.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityMessageListener {
    private final ActivityAIService aiService;
    private final RecommendationRepository recommendationRepository;
    @RabbitListener(queues="activity.queue")
    public void processActivity(Activity activity){
        log.info("Recieved activity for processing : {}", activity.getId());
        //log.info("generate rec : {}", aiService.generateRecommendation(activity));
        Recommendation recommendation= aiService.generateRecommendation(activity);
        recommendationRepository.save(recommendation);
    }

}
