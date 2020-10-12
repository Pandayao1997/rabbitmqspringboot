package cn.pandayao.demo.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutConsumer {
    @RabbitListener(bindings =
        @QueueBinding(value =
            @Queue,exchange =
                @Exchange(value = "fanout",type = "fanout")))
    public void consumer1(String msg){
        System.out.println("消费者1消费"+msg);
    }

    @RabbitListener(bindings =
        @QueueBinding(value =
            @Queue,exchange =
                @Exchange(value = "fanout",type = "fanout")))
    public void consumer2(String msg){
        System.out.println("消费者2消费"+msg);
    }
}
