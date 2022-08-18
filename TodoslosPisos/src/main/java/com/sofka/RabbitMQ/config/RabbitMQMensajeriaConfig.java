package com.sofka.RabbitMQ.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQMensajeriaConfig {

    @Bean
    Queue apto101() {
        return new Queue("101", false);
    }

    @Bean
    Queue apto102() {
        return new Queue("102", false);
    }

    @Bean
    Queue apto201() {
        return new Queue("201", false);
    }

    @Bean
    Queue apto202() {
        return new Queue("202", false);
    }

    @Bean
    Queue apto301() {
        return new Queue("301", false);
    }

    @Bean
    Queue apto302() {
        return new Queue("302", false);
    }

    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange("portero");
    }

    @Bean
    Binding apto101Binding(Queue apto101, FanoutExchange portero) {
        return BindingBuilder.bind(apto101).to(portero);
    }

    @Bean
    Binding apto102Binding(Queue apto102, FanoutExchange portero) {
        return BindingBuilder.bind(apto102).to(portero);
    }

    @Bean
    Binding apto201Binding(Queue apto201, FanoutExchange portero) {
        return BindingBuilder.bind(apto201).to(portero);
    }

    @Bean
    Binding apto202Binding(Queue apto202, FanoutExchange portero) {
        return BindingBuilder.bind(apto202).to(portero);
    }

    @Bean
    Binding apto301Binding(Queue apto301, FanoutExchange portero) {
        return BindingBuilder.bind(apto301).to(portero);
    }

    @Bean
    Binding apto302Binding(Queue apto302, FanoutExchange portero) {
        return BindingBuilder.bind(apto302).to(portero);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        return simpleMessageListenerContainer;
    }

    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
