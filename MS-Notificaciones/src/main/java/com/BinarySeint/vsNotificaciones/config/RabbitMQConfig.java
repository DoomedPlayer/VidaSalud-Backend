package com.BinarySeint.vsNotificaciones.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public DirectExchange cmdDirect() { return new DirectExchange("cmd.direct"); }

    @Bean
    public TopicExchange cmdTopic() { return new TopicExchange("cmd.topic"); }

    @Bean
    public DirectExchange cmdDeadDlx() { return new DirectExchange("cmd.dead.dlx"); }


    @Bean
    public Queue emailDlq() { return new Queue("q.cmd.email.dlq"); }

    @Bean
    public Queue admissionDlq() { return new Queue("q.cmd.admission.dlq"); }

    @Bean
    public Queue recordDlq() { return new Queue("q.cmd.record.dlq"); }

    @Bean
    public Queue emailQueue() {
        return QueueBuilder.durable("q.cmd.email")
                .withArgument("x-dead-letter-exchange", "cmd.dead.dlx")
                .withArgument("x-dead-letter-routing-key", "q.cmd.email.dlq")
                .build();
    }

    @Bean
    public Queue admissionQueue() {
        return QueueBuilder.durable("q.cmd.admission")
                .withArgument("x-dead-letter-exchange", "cmd.dead.dlx")
                .withArgument("x-dead-letter-routing-key", "q.cmd.admission.dlq")
                .build();
    }

    @Bean
    public Queue recordQueue() {
        return QueueBuilder.durable("q.cmd.record")
                .withArgument("x-dead-letter-exchange", "cmd.dead.dlx")
                .withArgument("x-dead-letter-routing-key", "q.cmd.record.dlq")
                .build();
    }

    @Bean
    public Binding emailDlqBinding() { return BindingBuilder.bind(emailDlq()).to(cmdDeadDlx()).with("q.cmd.email.dlq"); }

    @Bean
    public Binding admissionDlqBinding() { return BindingBuilder.bind(admissionDlq()).to(cmdDeadDlx()).with("q.cmd.admission.dlq"); }

    @Bean
    public Binding recordDlqBinding() { return BindingBuilder.bind(recordDlq()).to(cmdDeadDlx()).with("q.cmd.record.dlq"); }


    @Bean
    public Binding emailDirectBinding() { return BindingBuilder.bind(emailQueue()).to(cmdDirect()).with("email.send"); }

    @Bean
    public Binding admissionDirectBinding() { return BindingBuilder.bind(admissionQueue()).to(cmdDirect()).with("admission.ticket"); }

    @Bean
    public Binding recordDirectBinding() { return BindingBuilder.bind(recordQueue()).to(cmdDirect()).with("record.gen"); }

    @Bean
    public Binding emailTopicBinding() { return BindingBuilder.bind(emailQueue()).to(cmdTopic()).with("email.*"); }

    @Bean
    public Binding admissionTopicBinding() { return BindingBuilder.bind(admissionQueue()).to(cmdTopic()).with("admission.#"); }

    @Bean
    public Binding recordTopicBinding() { return BindingBuilder.bind(recordQueue()).to(cmdTopic()).with("record.*"); }
}