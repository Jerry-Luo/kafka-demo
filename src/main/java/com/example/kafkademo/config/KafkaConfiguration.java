package com.example.kafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author <a href="mailto:luojianwei@qiancangkeji.cn">LuoJianwei</a>
 * @since 1.0.0
 */
@Configuration
public class KafkaConfiguration {

    /**
     * To create a topic on startup, add a bean of type NewTopic.
     * If the topic already exists, the bean is ignored.
     * @return {@link NewTopic}
     */
    @Bean
    public NewTopic firstTopic(){
        return new NewTopic("kafka.demo.first", 1, (short)1);
    }

    @Bean
    public NewTopic secondTopic(){
        return new NewTopic("kafka.demo.second", 3, (short)1);
    }

    @Bean
    public NewTopic concurrentConsumer(){
        return new NewTopic("kafka.demo.concurrent.consumer", 3, (short)1);
    }

}
