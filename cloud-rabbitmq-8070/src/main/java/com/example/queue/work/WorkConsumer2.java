package com.example.queue.work;

import com.example.queue.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author xue
 * @date 2020-06-14 13:37
 */
public class WorkConsumer2 {
    public static void main(String[] args) throws IOException {
        Connection connection= RabbitMQUtils.getConnection();
        Channel channel=connection.createChannel();
        channel.queueDeclare("hello",true,false,false,null);
        //一次只允许消费1个
        channel.basicQos(1);
        channel.basicConsume("hello",false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    Thread.sleep(1000);
                    System.out.println("消费者2========="+new String(body));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //消费确认
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}
