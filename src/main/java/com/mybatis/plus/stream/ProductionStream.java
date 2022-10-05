package com.mybatis.plus.stream;

import org.redisson.Redisson;
import org.redisson.api.RStream;
import org.redisson.api.RedissonClient;
import org.redisson.api.StreamMessageId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ProductionStream {

    @Autowired
    private RedissonClient redisson;

    public void a(){



        RStream<String, String> stream = redisson.getStream("test3");
        //初始化，不知为啥，但不这样做create不到group
        stream.add("0","0");
        //创建一个group，一个group需要在stream数据添加前创建，否则这个group只能读它创建以后写入stream的数据
        stream.createGroup("testGroup31");
        //往stream添加消息
        for(Integer i=0;i<30;i++){
            stream.add(i.toString(), i.toString());
        }

        //消费消息
        for(Integer i=0;i<6;i++) {
            Integer finalI = i;
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }

                Map<StreamMessageId, Map<String, String>> s = stream.readGroup("testGroup31", "consumer" + finalI.toString(), 1);
                if (s != null && s.size() > 0) {
                    for (Map.Entry<StreamMessageId, Map<String, String>> entry : s.entrySet()) {
                        Map<String, String> m2 = entry.getValue();
                        for (Map.Entry<String, String> entry1 : m2.entrySet()) {
                            System.out.println(Thread.currentThread().getName() + " : Key = " + entry1.getKey() + ", Value = " + entry1.getValue());
                        }
                        //消费了消息，要应答一下
                        stream.ack("testGroup31", entry.getKey());
                        //如果消费了消息想删除，可以删除掉
                        stream.remove(entry.getKey());
                    }
                }

            });
            t.start();
        }
    }


}
