package com.projetoBackEnd.sghss.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicoDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String crm;
    private String especialidade;
    private String telefone;
    private String email;
    private String dataCadastro;
    private Boolean ativo;
}
