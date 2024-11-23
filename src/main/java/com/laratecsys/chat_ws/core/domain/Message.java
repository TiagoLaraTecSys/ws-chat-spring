package com.laratecsys.chat_ws.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Message implements Serializable {

    private int id;
    private String message;
    private String idReceiver;
}
