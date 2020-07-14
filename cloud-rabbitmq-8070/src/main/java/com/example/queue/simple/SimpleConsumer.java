package com.example.queue.simple;


import com.example.queue.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author xue
 * @date 2020-06-13 10:22
 */
public class SimpleConsumer {
    public static void main(String[] args) throws IOException {
    //创建连接
        Connection connection = RabbitMQUtils.getConnection();
    //创建通道对象
        Channel channel = connection.createChannel();
    //创建队列
        channel.queueDeclare("hello", true, false, false, null);
    //消费消息
        /**
         * 参数1：队列名称
         * 参数2：自动确认机制
         * 参数3：消费时接口回调
         */
        channel.basicConsume("hello", true, new DefaultConsumer(channel) {
            /**
             *channe
             * @param consumerTag
             * @param envelope
             * @param properties
             * @param body
             * @throws IOException
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费消息====" + new String(body));
            }
        });
        //关闭之后  不再监听新消息，所以不建议关闭
        // RabbitMQUtils.closeChannelAndConnection(channel,connection);
    }
}
