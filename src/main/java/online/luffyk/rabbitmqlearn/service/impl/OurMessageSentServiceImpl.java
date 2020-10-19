package online.luffyk.rabbitmqlearn.service.impl;

import online.luffyk.rabbitmqlearn.service.OurMessageSentService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 该接口用于向消息队列发送消息，是消息的生产者
 */
@Service
public class OurMessageSentServiceImpl implements OurMessageSentService {
    @Resource
    private RabbitTemplate rabbitTemplate;      //给rabbitMq发送和接收消息时使用

    /**
     *
     * @param softwareName 软件名称
     * @param message 需要发送的消息
     * 将消息以主题模式进行发送，并发送到服务器端
     */
    @Override
    public void RabbitTopicSendService(String softwareName,String message) {
        System.out.println("software:"+softwareName);
        System.out.println("message:"+message);
        if("weChat".equals(softwareName)){
            //将消息发送给企业微信
            this.RabbitTopicSendToWeChatService(message);
        }else if ("dingTalk".equals(softwareName)) {
            //将消息发送给钉钉端
            this.RabbitTopicSendToDingTalkService(message);
        }else if("sms".equals(softwareName)){
            //将消息发送给短信端
            this.RabbitTopicSendToSMSService(message);
        }else if("other".equals(softwareName)){
            //将消息发送给其他端
            this.RabbitTopicSendToOtherService(message);
        }
        else if("all".equals(softwareName)){
            //将消息发送给所有已经订阅了的软件
            this.RabbitTopicSendToAllService(message);
        }
    }

    /**
     *
     * @param message 发往消息队列的消息，该消息只有企业微信端接收
     */
    private void RabbitTopicSendToWeChatService(String message){
        System.out.println("准备往消息队列上发送一个消息，该消息是发往企业微信端的");
        rabbitTemplate.convertAndSend("software_topic_exchange","software.weChat",message);
    }

    /**
     *
     * @param message 发往消息队列的消息，该消息只有钉钉端接收
     */
    private void RabbitTopicSendToDingTalkService(String message){
        System.out.println("准备往消息队列上发送一个消息，该消息是发往企业微信端的");
        rabbitTemplate.convertAndSend("software_topic_exchange","software.dingTalk",message);
    }

    /**
     *
     * @param message 发往消息队列的消息，该消息只有短信端接收
     */
    private void RabbitTopicSendToSMSService(String message){
        System.out.println("准备往消息队列上发送一个消息，该消息是发往短信端的");
        rabbitTemplate.convertAndSend("software_topic_exchange","software.sms",message);
    }

    /**
     *
     * @param message 发往消息队列的消息，该消息只有短信端接收
     */
    private void RabbitTopicSendToOtherService(String message){
        System.out.println("准备往消息队列上发送一个消息，该消息是发往其他端的");
        rabbitTemplate.convertAndSend("software_topic_exchange","software.sms",message);
    }

    /**
     *
     * @param message 发往消息队列的消息，该消息所有软件端接收
     */
    private void RabbitTopicSendToAllService(String message){
        rabbitTemplate.convertAndSend("software_fanout_exchange","",message);
    }
}
