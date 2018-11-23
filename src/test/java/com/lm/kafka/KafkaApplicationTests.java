package com.lm.kafka;

import com.lm.kafka.producer.MsgProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaApplicationTests {

    @Autowired
    private MsgProducer msgProducer;

    @Test
    public void test() throws Exception {

        while (true){
            msgProducer.send();
            Thread.sleep(1000);
        }
    }
}
