package online.luffyk.rabbitmqlearn.service;

import online.luffyk.rabbitmqlearn.domain.User;
import org.springframework.amqp.core.Message;

public interface OurMessageReceiveService {
//    public void receiveRabiitMqMessage(String message);
//
//    public void receiveRabiitMqMessage2(String message);
//
//    public void receiveRabiitMqMessage3(String message);
//
//    public void receiveRabiitMqTopicMessage1(String message);
//
//    public void receiveRabiitMqTopicMessage2(String message);
//
//    public void receiveRabiitMqTopicMessage3(String message);

    /**
     * 企业微信端从消息队列中接收消息
     * @param message 消息队列中的消息
     */
    public void receiveRabbitMqTopicForWeChat(String message);

    /**
     * 钉钉端从消息队列中接收消息
     * @param message 消息队列中的消息
     */
    public void receiveRabbitMqTopicForDingTalk(String message);

    /**
     * 短信端从消息队列中接收消息
     * @param message 消息队列中的消息
     */
    public void receiveRabbitMqTopicForSMS(String message);

    /**
     * 其他端从消息队列中接收消息
     * @param message 消息队列中的消息
     */
    public void receiveRabbitMqTopicForOther(String message);
}
