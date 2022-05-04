package com.mlr.mail;

import com.mlr.server.pojo.MailConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Queue;

/**
 * 启动类
 * @author: mlr
 * @date: 2022/4/16 15:13
 * @since: 1.0.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MailApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailApplication.class,args);
    }

    @Bean
    public Queue queue(){
        return new Queue(MailConstants.MAIL_QUEUE_NAME);
    }
}
