package com.jingxuan.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Xuan Jing
 * @Date: 2021/1/31 4:14 PM
 */
@Component
@Profile("dev")
@Slf4j
public class Consumer2 {
    @KafkaListener(topics = {"topic_a"}, groupId = "test_group_2")
    public void onMessage1(ConsumerRecord<?, ?> record) {
        log.info("record : {}", record.toString());
    }
}
