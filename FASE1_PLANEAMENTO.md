# FASE 1 — ESTUDOS E PLANEAMENTO

## 1.1 Introdução e Estudo de Caso

O presente projeto desenvolve o **Sistema de Gestão Hospitalar (SGHSS)**, baseado no caso de estudo **VidaPlus**, uma instituição de saúde que necessita de um sistema informatizado para gerenciar pacientes, médicos e consultas.

### Contexto do Caso VidaPlus

A VidaPlus é uma clínica médica que atende uma comunidade local, necessitando de um sistema que permita:

- Cadastro e gestão de pacientes
- Controle de profissionais médicos
- Agendamento e acompanhamento de consultas
- Histórico médico organizado

### Ênfase do Projeto

Este projeto adota **ênfase em Back-end**, priorizando:

- Desenvolvimento de API REST robusta
- Arquitetura em camadas com Spring Boot
- Persistência de dados com MySQL
- Boas práticas de desenvolvimento Java

## 1.2 Cronograma de Desenvolvimento

O projeto foi desenvolvido em **8 semanas**, seguindo a metodologia proposta:

| Semana | Atividade | Status |
|--------|-----------|--------|
| 1 | Estudos e Planeamento | ✅ Concluído |
| 2-3 | Modelagem e Arquitetura | ✅ Concluído |
| 4-6 | Implementação | ✅ Concluído |
| 7 | Plano de Testes e Qualidade | ✅ Concluído |
| 8 | Documentação e Revisão Final | ✅ Concluído |

## 1.3 Levantamento de Requisitos

### Requisitos Funcionais (RF)

| Código | Descrição |
|--------|-----------|
| RF001 | O sistema deve permitir cadastrar pacientes |
| RF002 | O sistema deve permitir cadastrar médicos |
| RF003 | O sistema deve permitir agendar consultas |
| RF004 | O sistema deve permitir listar pacientes |
| RF005 | O sistema deve permitir listar médicos |
| RF006 | O sistema deve permitir listar consultas |
| RF007 | O sistema deve permitir atualizar dados de pacientes |
| RF008 | O sistema deve permitir atualizar dados de médicos |
| RF009 | O sistema deve permitir atualizar status de consultas |
| RF010 | O sistema deve permitir excluir pacientes |
| RF011 | O sistema deve permitir excluir médicos |
| RF012 | O sistema deve permitir excluir consultas |

### Requisitos Não Funcionais (RNF)

| Código | Descrição |
|--------|-----------|
| RNF001 | O sistema deve usar arquitetura REST |
| RNF002 | O sistema deve usar Java 17+ |
| RNF003 | O sistema deve usar Spring Boot |
| RNF004 | O sistema deve usar MySQL como banco |
| RNF005 | O sistema deve ter tratamento de erros |
| RNF006 | O sistema deve usar DTOs para transferência |
| RNF007 | O sistema deve ter validações de negócio |
| RNF008 | O sistema deve ser escalável |

## 1.4 Justificativa da Abordagem

A escolha da ênfase em Back-end justifica-se pela necessidade de uma base sólida e escalável para o sistema hospitalar, priorizando:

- **Segurança**: Controle rigoroso de dados sensíveis
- **Performance**: Otimização de consultas ao banco
- **Manutenibilidade**: Código organizado e testável
- **Integração**: API preparada para diferentes front-ends

Esta abordagem garante que o sistema possa evoluir com diferentes interfaces (web, mobile) mantendo a consistência dos dados e regras de negócio.