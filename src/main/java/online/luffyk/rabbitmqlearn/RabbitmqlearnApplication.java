package online.luffyk.rabbitmqlearn;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class RabbitmqlearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqlearnApplication.class, args);
    }

}
