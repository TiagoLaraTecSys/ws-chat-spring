package com.laratecsys.chat_ws.handlers;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.sql.Time;

public class WebSocketHandlerUser2Bot extends TextWebSocketHandler {


    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws IOException, InterruptedException {

        if (textMessage.getPayload().contains("mamadinha")) {
            session.sendMessage(new TextMessage("escrevendo..."));
            Thread.sleep(25000);
            session.sendMessage( new TextMessage("Acho que isso nao posso fazer"));
        }
    }
}
