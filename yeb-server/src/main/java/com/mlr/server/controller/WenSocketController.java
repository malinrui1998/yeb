package com.mlr.server.controller;

import com.mlr.server.pojo.Admin;
import com.mlr.server.pojo.ChatMsg;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author: mlr
 * @date: 2022/4/17 23:43
 * @since: 1.0.0
 */
public class WenSocketController {
    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/ws/chat")
    public void handleMsg(Authentication authentication, ChatMsg chatMsg) {
        Admin admin = (Admin) authentication.getPrincipal();
        chatMsg.setFrom(admin.getUsername());
        chatMsg.setFromNickName(admin.getName());
        chatMsg.setDate(LocalDateTime.now());
        /**
         * 发送消息
         * 1.消息接收者
         * 2.消息队列
         * 3.消息对象
         */
        simpMessagingTemplate.convertAndSendToUser(chatMsg.getTo(), "/queue/chat", chatMsg);
    }
}
