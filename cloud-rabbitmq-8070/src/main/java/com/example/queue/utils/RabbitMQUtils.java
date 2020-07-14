package com.example.queue.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author xue
 * @date 2020-06-13 10:03
 */
public class RabbitMQUtils {
    private static ConnectionFactory factory;

    static {
        factory = new ConnectionFactory();
        factory.setVirtualHost("/msg");
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("123456");
    }

    public static Connection getConnection() {
        try {
            return factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeChannelAndConnection(Channel channel, Connection connection) {

        try {
            if (channel != null) {
                channel.close();
            }
            if (connection!=null)
                connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
