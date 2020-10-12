package cn.pandayao.demo.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//RabbitListener 指定目标方法（类）来作为消费消息的方法（类）
//queuesToDeclare 没有hello队列就创建hello
@RabbitListener(queuesToDeclare = @Queue(value = "hello"))
public class HelloConsumer {
    //RabbitHandler 指定目标方法为消费者获得消息的方法
    @RabbitHandler
    public void getMessage(String msg){
        System.out.println("message:"+msg);
    }
}
