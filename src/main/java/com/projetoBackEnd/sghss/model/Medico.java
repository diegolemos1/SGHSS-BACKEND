package com.projetoBackEnd.sghss.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false, unique = true, length = 12)
    private String crm;

    @Column(nullable = false, length = 100)
    private String especialidade;

    @Column(nullable = false, length = 15)
    private String telefone;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(name = "data_cadastro")
    private String dataCadastro;

    @Column(nullable = false)
    private Boolean ativo = true;
}
