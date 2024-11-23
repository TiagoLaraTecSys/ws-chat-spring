package com.laratecsys.chat_ws.config;

import com.laratecsys.chat_ws.handlers.WebSocketHandlerUser2Bot;
import com.laratecsys.chat_ws.handlers.WebSocketHandlerUser2User;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new WebSocketHandlerUser2User(), "/chat")
                .addInterceptors(new HttpSessionHandshakeInterceptor());

        registry.addHandler(new WebSocketHandlerUser2Bot(), "/bot")
                .addInterceptors(new HttpSessionHandshakeInterceptor());
    }
}
