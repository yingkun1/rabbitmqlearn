package online.luffyk.rabbitmqlearn;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class RabbitTemplateTest {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private RabbitMessagingTemplate rabbitMessagingTemplate;

    @Test
    public void testRabbitTemplateSend(){
        rabbitMessagingTemplate.convertAndSend("test_queue01","hello world555");
    }

    @Test
    public void testRabbitFanoutSend(){
        rabbitTemplate.convertAndSend("test_fanout_exchange","","test_fanout_exchange111");
    }

    @Test
    public void testRabbitTopicSend(){
        rabbitTemplate.convertAndSend("test_topic_exchange","aaa.bbb","test_topic_exchange111");
        rabbitTemplate.convertAndSend("test_topic_exchange","aaa.bbb.ccc","test_topic_exchange111");
        rabbitTemplate.convertAndSend("test_topic_exchange","bbb.aaa","test_topic_exchange111");
    }

    @Test
    public void testRabbitTopicSend2(){
        rabbitTemplate.convertAndSend("test_topic_exchange","aaa.bbb.ccc","test_topic_exchange111");
    }

    @Test
    public void testRabbitTopicSend3(){
        rabbitTemplate.convertAndSend("test_topic_exchange","bbb.aaa","test_topic_exchange111");
    }

    @Test
    public void testRabbitTopicSend4(){
        rabbitTemplate.convertAndSend("test_topic_exchange","weixing","test_topic_exchange111");
    }

    @Test
    public void testRabbitTopicSend5(){
        rabbitTemplate.convertAndSend("test_topic_exchange","dingding","test_topic_exchange111");
    }
}
