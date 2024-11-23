package com.laratecsys.chat_ws.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laratecsys.chat_ws.core.domain.Message;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebSocketHandlerUser2User extends TextWebSocketHandler {

    private final Map<String, WebSocketSession> conexoes = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        String idUsuarioConectado = session.getHandshakeHeaders().get("userid").get(0);
        conexoes.put(idUsuarioConectado, session);

        // Enviar mensagens nao lidas
        System.out.println("Id do user conectado: " + idUsuarioConectado);
        System.out.println("Usuário Conectado: " + session.getHandshakeHeaders().get("username").get(0));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        conexoes.remove(session.getId());
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        Message mensagem = new ObjectMapper().readValue(message.getPayload(), Message.class);

        String idReceiver = mensagem.getIdReceiver();

        WebSocketSession receiver = this.conexoes.get(idReceiver);
        receiver.sendMessage(new TextMessage(mensagem.getMessage()));

    }
}
