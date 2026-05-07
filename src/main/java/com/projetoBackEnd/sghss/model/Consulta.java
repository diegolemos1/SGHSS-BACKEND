package com.projetoBackEnd.sghss.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "consultas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @Column(name = "data_consulta", nullable = false)
    private String dataConsulta;

    @Column(name = "hora_consulta", nullable = false, length = 5)
    private String horaConsulta;

    @Column(length = 500)
    private String descricao;

    @Column(length = 100)
    private String diagnostico;

    @Column(name = "status", length = 20)
    private String status = "AGENDADA";

    @Column(name = "data_cadastro")
    private String dataCadastro;
}
