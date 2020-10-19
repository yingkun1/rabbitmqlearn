package online.luffyk.rabbitmqlearn.service;

public interface OurMessageSentService {
    /**
     * 主题模式，将消息以主题模式进行发送
     */
    public void RabbitTopicSendService(String softwareName,String message);
}
