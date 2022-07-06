package br.com.msemail.ServicoEmail.consumes;

import br.com.msemail.ServicoEmail.dtos.EmailDto;
import br.com.msemail.ServicoEmail.models.EmailModel;
import br.com.msemail.ServicoEmail.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

// Classe para ficar escutando a fila no RabbitMQ
@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    // Método que ficará escutando a fila
    // Basicamente a mesma coisa do post no controller
    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDto emailDto){
        EmailModel emailModel = EmailModel.builder().build();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);
        System.out.println("Email Status: " + emailModel.getStatusEmail().toString());
    }


}
