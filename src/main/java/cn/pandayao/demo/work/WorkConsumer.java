package cn.pandayao.demo.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkConsumer {
    @RabbitListener(queuesToDeclare = @Queue(value = "work"))
    public void consumer1(String msg){
        System.out.println("消费者1消费"+msg);
    }

    @RabbitListener(queuesToDeclare = @Queue(value = "work"))
    public void consumer2(String msg){
        System.out.println("消费者2消费"+msg);
    }
}
