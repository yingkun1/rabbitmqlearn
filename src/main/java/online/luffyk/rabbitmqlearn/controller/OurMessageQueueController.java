package online.luffyk.rabbitmqlearn.controller;

import online.luffyk.rabbitmqlearn.domain.User;
import online.luffyk.rabbitmqlearn.service.OurMessageSentService;
import online.luffyk.rabbitmqlearn.utils.ResponseResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OurMessageQueueController {
    @Resource
    private OurMessageSentService ourMessageSentService;

    @RequestMapping("messageQueue/{software}")
    public ResponseResult MessageQueueForWeChat(@PathVariable("software") String software){
//        User user = new User("张三", "zhangsan9257", 22, true);
        ourMessageSentService.RabbitTopicSendService(software,"这是一条测试的消息，等下放到参数中");
        return new ResponseResult("调用微信接口成功",null,0);
    }
}
