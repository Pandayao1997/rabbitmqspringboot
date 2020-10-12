package cn.pandayao.demo.routing;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RoutingConsumer {
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue,exchange = @Exchange(value = "routing",type = "direct"),key = {"info","error","warning"}))
    public void consumer1(String msg){
        System.out.println("所有日志："+msg);
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue,exchange = @Exchange(value = "routing",type = "direct"),key = {"error"}))
    public void consumer2(String msg){
        System.out.println("错误："+msg);
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue,exchange = @Exchange(value = "routing",type = "direct"),key = {"warning"}))
    public void consumer3(String msg){
        System.out.println("警告："+msg);
    }
}
