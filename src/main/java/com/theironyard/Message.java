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
    String message;

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }
}
