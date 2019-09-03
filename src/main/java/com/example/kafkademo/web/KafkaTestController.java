package com.example.kafkademo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author <a href="mailto:luojianwei@qiancangkeji.cn">LuoJianwei</a>
 * @since 1.0.0
 */
@RestController
public class KafkaTestController {

    /**
     * If the property spring.kafka.producer.transaction-id-prefix is defined,
     * a KafkaTransactionManager is automatically configured. Also,
     * if a RecordMessageConverter bean is defined, it is automatically associated
     * to the auto-configured KafkaTemplate
     */
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/sendMsg")
    public String send (String msg) {
        kafkaTemplate.send("kafka.demo.first", msg);
        for (int i=0; i<5; i++){
            kafkaTemplate.send("kafka.demo.second", msg+":"+i);
        }
        return "send success";
    }

    @PostMapping("/send")
    public String sendMsg(String topic, Integer times, String content){
        for (int i=0; i<times; i++) {
            kafkaTemplate.send(topic, content+i);
        }
        return "success";
    }
}
