package cn.pandayao.demo.topics;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicsConsumer {
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue,exchange = @Exchange(name = "topics",type = "topic"),key = {"wo.#"}))
    public void consumer(String msg){
        System.out.println("消费者1："+msg);
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue,exchange = @Exchange(name = "topics",type = "topic"),key = {"cnm.*"}))
    public void consumer2(String msg){
        System.out.println("消费者2："+msg);
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue,exchange = @Exchange(name = "topics",type = "topic"),key = {"*.shi.#","ni.*.hao"}))
    public void consumer3(String msg){
        System.out.println("消费者3："+msg);
    }
}
