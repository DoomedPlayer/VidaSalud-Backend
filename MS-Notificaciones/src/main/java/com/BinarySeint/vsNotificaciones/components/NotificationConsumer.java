package com.BinarySeint.vsNotificaciones.components;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class NotificationConsumer {

    @RabbitListener(queues = "q.cmd.email")
    public void procesarEmail(Map<String, Object> mensajeEnvelope) {
        System.out.println("Procesando envío de Email/Push...");
        System.out.println("TraceId: " + mensajeEnvelope.get("traceId"));
        System.out.println("Datos de la atención: " + mensajeEnvelope.get("data"));
        
        // Aquí iría la lógica real de integración con un servicio de correo (ej. SendGrid o JavaMailSender)
    }

    @RabbitListener(queues = "q.cmd.admission")
    public void procesarTicketAdmision(Map<String, Object> mensajeEnvelope) {
        System.out.println("Generando ticket de admisión para el box clínico...");
        System.out.println("TraceId: " + mensajeEnvelope.get("traceId"));
        
        // Aquí iría la lógica para interactuar con el sistema del centro médico para imprimir el ticket
    }

    @RabbitListener(queues = "q.cmd.record")
    public void procesarGeneracionPdf(Map<String, Object> mensajeEnvelope) {
        System.out.println("Generando PDF comprobante...");
        // Lógica de generación de PDF
    }
}