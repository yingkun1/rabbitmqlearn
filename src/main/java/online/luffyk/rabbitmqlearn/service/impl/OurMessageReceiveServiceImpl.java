package online.luffyk.rabbitmqlearn.service.impl;

import online.luffyk.rabbitmqlearn.domain.User;
import online.luffyk.rabbitmqlearn.service.OurMessageReceiveService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Service;

/**
 * 消息队列的消费端
 */
@Service
public class OurMessageReceiveServiceImpl implements OurMessageReceiveService {
    @RabbitListener(queues = "topic_queue_weChat")
    @Override
    public void receiveRabbitMqTopicForWeChat(String message) {
        System.out.println("接收消息成功");
        System.out.println(message);
        System.out.println("主题订阅消费者之企业微信端，接收到的消息为："+message);
    }

    @RabbitListener(queues = "topic_queue_dingTalk")
    @Override
    public void receiveRabbitMqTopicForDingTalk(String message) {
        System.out.println("接收消息成功");
        System.out.println("主题订阅消费者之钉钉端，接收到的消息为："+message);
    }

    @RabbitListener(queues = "topic_queue_sms")
    @Override
    public void receiveRabbitMqTopicForSMS(String message) {
        System.out.println("接收消息成功");
        System.out.println("主题订阅消费者之短信端，接收到的消息为："+message);
    }

    @RabbitListener(queues = "topic_queue_other")
    @Override
    public void receiveRabbitMqTopicForOther(String message) {
        System.out.println("接收消息成功");
        System.out.println("主题订阅消费者之其他端，接收到的消息为："+message);
    }

//    @RabbitListener(queues = "test_queue01")
//    @Override
//    public void receiveRabiitMqMessage(String message) {
//        System.out.println("消费者1接收到的消息为："+message);
//    }
//
//    @RabbitListener(queues = "test_queue02")
//    @Override
//    public void receiveRabiitMqMessage2(String message) {
//        System.out.println("消费者2接收到的消息为："+message);
//    }
//
//    @RabbitListener(queues = "test_queue03")
//    @Override
//    public void receiveRabiitMqMessage3(String message) {
//        System.out.println("消费者3接收到的消息为："+message);
//    }
//
//    @RabbitListener(queues = "test_topic_queue01")
//    @Override
//    public void receiveRabiitMqTopicMessage1(String message) {
//        System.out.println("主题订阅消费者01，接收到的消息为："+message);
//    }
//
//    @RabbitListener(queues = "test_topic_queue02")
//    @Override
//    public void receiveRabiitMqTopicMessage2(String message) {
//        System.out.println("主题订阅消费者02,接收到的消息为："+message);
//    }
//
//    @RabbitListener(queues = "test_topic_queue03")
//    @Override
//    public void receiveRabiitMqTopicMessage3(String message) {
//        System.out.println("主题订阅消费者03，接收到的消息为："+message);
//    }




}
