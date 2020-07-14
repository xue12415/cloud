package com.example.queue.simple;

import com.example.queue.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;


/**
 * @author xue
 * @date 2020-06-13 10:01
 */
public class SimpleProvider {
    public static void main(String[] args) throws IOException {
        //创建连接
        Connection connection= RabbitMQUtils.getConnection();
        // 创建队列
        Channel channel=connection.createChannel();

        /**
         * 参数1：队列名称，如果队列不存在自动创建队列
         * 参数2：是否持久化，只持久化队列，不持久化消息
         * 参数3：是否独占队列
         * 参数4：消费完成后是否关闭队列（如果不关闭消费者则无法关闭队列，因为队列中有消息）
         * 参数5：附加参数
         */
        channel.queueDeclare("hello",true,false,false,null);


        //发送消息
        /**
         * 参数1：交换机名称
         * 参数2：队列名称
         * 参数3：持久化方式
         * 参数4：消息内容
         */
        channel.basicPublish("","hello", MessageProperties.PERSISTENT_TEXT_PLAIN,"hello_rabbit_mq".getBytes());

        //关闭连接
        RabbitMQUtils.closeChannelAndConnection(channel,connection);
    }
}
