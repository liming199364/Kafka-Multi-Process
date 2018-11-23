package com.lm.kafka.consumer;

import com.lm.kafka.config.KafkaConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author:liming
 * @data:2018/11/23
 * @decription
 */
//@Component
public class MsgConsumer {
    @PostConstruct
    void init() {
        Properties props = new Properties();
        props.put("bootstrap.servers", config.getBootstrap_servers());
        props.put("group.id", config.getGroup_id());
        props.put("enable.auto.commit", config.getEnable_auto_commit());
        props.put("auto.commit.interval.ms", config.getAuto_commit_interval_ms());
        props.put("session.timeout.ms", config.getSession_timeout_ms());
        props.put("key.deserializer",
                config.getKey_deserializer());
        props.put("value.deserializer",
                config.getValue_deserializer());
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        consumer.subscribe(Arrays.asList(topic));
        System.out.println("Subscribed to topic " + topic);
        int i = 0;

        while (true)
        {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records){
                System.out.printf("offset = {}, key = {}, value = {} , partition = {}\n",
                        record.offset(), record.key(), record.value() , record.partition());
            }
        }
    }

    private static final String topic = "kafka-multi";

    @Autowired
    private KafkaConfig config;
}
