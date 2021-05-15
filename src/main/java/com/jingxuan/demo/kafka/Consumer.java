package com.jingxuan.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Xuan Jing
 * @Date: 2021/1/29 9:15 PM
 */
@Component
@Slf4j
public class Consumer {
    @KafkaListener(topics = {"topic_a"}, groupId = "test_group_1")
    public void onMessage1(ConsumerRecord<?, ?> record) {
        log.info("record : {}", record.toString());
    }
}
