package com.projetoBackEnd.sghss.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaDTO {

    private Long id;
    private Long pacienteId;
    private Long medicoId;
    private String dataConsulta;
    private String horaConsulta;
    private String descricao;
    private String diagnostico;
    private String status;
    private String dataCadastro;
}
