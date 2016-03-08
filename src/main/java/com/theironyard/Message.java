package com.theironyard;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by ericweidman on 3/7/16.
 */
@Entity
public class Message {
    @Id
    @GeneratedValue
    int id;
    String messageText;

    public Message(){

    }

    public Message(String messageText) {
        this.messageText = messageText;
    }
}
