package cn.pandayao.demo;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //hello模型
    // 1.点对点
    // 2.没有交换机
    // 3.生产者直接将消息发送给队列  消费者通过队列拿到消息
    @Test
    void hello() {
        rabbitTemplate.convertAndSend("hello","hello world!");
    }

    //work模型
    // 相较于hello模型
    // 1.一对多
    // 2.也没有没有交换机
    // 3.生产者直接将消息发送给队列 多个消费者从队列依次轮询取消息  默认公平消费  比如消息1 2 3 4 5 6  消费者a b c  消费者a得到1，4   b得到2，5  c得到3，6
    @Test
    void work() {
        for(int i=0;i<10;i++){
            rabbitTemplate.convertAndSend("work","work"+i);
        }
    }

    //广播模型
    //1.需要绑定交换机
    //2.不用指定路由key
    //3.消费者将消息发送到交换机，交换机将消息发送到队列，多个消费者从队列获得消息   一对多
    @Test
    void fanout() {
        rabbitTemplate.convertAndSend("fanout","","我是fanout模式");
    }


    //路由模型
    //1.需要绑定交换机
    //2.需要指定路由key  消费者通过路由key来消费指定消息
    //3.消费者将消息发送到交换机，交换机将消息发送到队列，通过路由key来消费指定消息   一对多  相较于广播模型可以更具模块化
    @Test
    void routing() {
        rabbitTemplate.convertAndSend("routing","info","我是routing模式");
    }

    //订阅模式 （动态路由模式）
    //1.需要绑定交换机
    //2.需要指定路由key  消费者通过路由key来消费指定消息
    //3.相较于路由模式  多了通配符 *表示通配一个单词 #表示通配0-多个单词
    @Test
    void topics() {
        rabbitTemplate.convertAndSend("topics","wo.shi.java.zhi.fu","我是topics模式");
    }


}
