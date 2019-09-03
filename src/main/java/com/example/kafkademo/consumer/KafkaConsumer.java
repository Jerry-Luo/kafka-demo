package com.example.kafkademo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * When the Apache Kafka infrastructure is present,
 * any bean can be annotated with @KafkaListener to create a listener endpoint.
 * If no KafkaListenerContainerFactory has been defined,
 * a default one is automatically configured with keys defined in spring.kafka.listener.*.
 *
 * @author <a href="mailto:luojianwei@qiancangkeji.cn">LuoJianwei</a>
 * @since 1.0.0
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = {"kafka.demo.first", "kafka.demo.second"})
    public void processMessage(String content) {
        System.err.println("[" + Thread.currentThread().getName() + "] 0 receive msg: " + content);
    }

    @KafkaListener(topics = {"kafka.demo.first", "kafka.demo.second"})
    public void processMessage1(String content) {
        System.err.println("[" + Thread.currentThread().getName() + "] 1 receive msg: " + content);
    }

//    @KafkaListener(topicPartitions = @TopicPartition(
//            topic = "kafka.demo.concurrent.consumer",
//            partitions = "0"))
//    public void concurrentConsumer1(String content) {
//        System.err.println("[" + Thread.currentThread().getName() + "] partition-0 receive msg: " + content);
//    }
//
//    @KafkaListener(topicPartitions = @TopicPartition(
//            topic = "kafka.demo.concurrent.consumer",partitions = "1"))
//    public void concurrentConsumer2(String content) {
//        System.err.println("[" + Thread.currentThread().getName() + "] partition-1 receive msg: " + content);
//    }
//
//    @KafkaListener(topicPartitions =
//            @TopicPartition(topic = "kafka.demo.concurrent.consumer", partitions = { "2" }))
//    public void concurrentConsumer3(String content) {
//        System.err.println("[" + Thread.currentThread().getName() + "] partition-2 receive msg: " + content);
//    }
}
