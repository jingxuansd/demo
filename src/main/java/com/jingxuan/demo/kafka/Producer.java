package com.jingxuan.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @Author: Xuan Jing
 * @Date: 2021/1/29 9:15 PM
 */
@Slf4j
public class Producer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String payload) {
        log.info("sending payload='{}'", payload);
        kafkaTemplate.send("helloworld.t", payload);
    }
}
