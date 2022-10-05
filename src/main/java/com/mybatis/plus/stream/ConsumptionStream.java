package com.mybatis.plus.stream;

import org.redisson.api.RStream;
import org.redisson.api.RedissonClient;
import org.redisson.api.StreamMessageId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ConsumptionStream {


    @Autowired
    private RedissonClient redisson;


    public void a(){



        RStream<String, String> stream = redisson.getStream("test3");



                Map<StreamMessageId, Map<String, String>> s = stream.readGroup("testGroup31", "consumer", 1);
                if (s != null && s.size() > 0) {
                    for (Map.Entry<StreamMessageId, Map<String, String>> entry : s.entrySet()) {
                        Map<String, String> m2 = entry.getValue();
                        for (Map.Entry<String, String> entry1 : m2.entrySet()) {
                            System.out.println(Thread.currentThread().getName() + " : Key = " + entry1.getKey() + ", Value = " + entry1.getValue());
                        }
                        //消费了消息，要应答一下
                        stream.ack("testGroup31", entry.getKey());
                        //如果消费了消息想删除，可以删除掉
                        //stream.remove(entry.getKey());
                    }
                }
    }




}
