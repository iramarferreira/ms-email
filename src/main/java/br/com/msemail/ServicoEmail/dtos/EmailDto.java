package br.com.msemail.ServicoEmail.dtos;

import br.com.msemail.ServicoEmail.enums.StatusEmail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

// Dados que serão recebidos na requisição POST
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class EmailDto {


    // Pessoa que está recebendo o email
    // Validar os campos, pois são obrigatórios no momento de envio
    @NotBlank
    private String ownerRef;
    @NotBlank
    @Email
    private String emailFrom;
    @NotBlank
    @Email
    private String emailTo;
    @NotBlank
    private String subject;
    @NotBlank
    private String text;


}
