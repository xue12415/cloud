package com.example.queue.work;

import com.example.queue.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;

/**
 * @author xue
 * @date 2020-06-14 13:37
 */
public class WorkProvider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("hello", true, false, false, null);
        for (int i = 1; i <= 100; i++) {
            channel.basicPublish("", "hello", MessageProperties.PERSISTENT_BASIC,
                    (i+"=====hello-work-Rabbit").getBytes());
        }
        RabbitMQUtils.closeChannelAndConnection(channel, connection);
    }
}
