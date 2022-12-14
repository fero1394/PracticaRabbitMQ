package com.sofka.RabbitMQ.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/broker/fanout")
public class MensajeriaController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping(value = "/sendall")
    public String producer(@RequestParam("exchangeName") String exchange,
                           @RequestParam("messageData") String messageData) {

        amqpTemplate.convertAndSend(exchange, "", messageData);

        return "Message sent to the RabbitMQ Fanout Exchnage Successfully";
    }
}
