package com.lm.kafka.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author:liming
 * @data:2018/11/23
 * @decription
 */
@ConfigurationProperties(prefix = "kafka-consumer")
@Configuration
@Data
public class KafkaConfig {
    private String bootstrap_servers;
    private String group_id;
    private String enable_auto_commit;
    private String auto_commit_interval_ms;
    private String session_timeout_ms;
    private String key_deserializer;
    private String value_deserializer;
}
