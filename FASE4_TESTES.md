# FASE 4 — PLANO DE TESTES E QUALIDADE

## 4.1 Estratégia de Testes

### Objetivo

Garantir que o Sistema de Gestão Hospitalar (SGHSS) atenda aos requisitos funcionais e não funcionais estabelecidos, assegurando qualidade, confiabilidade e usabilidade.

### Abordagem

- **Testes Funcionais**: Validação das funcionalidades CRUD
- **Testes de Integração**: Verificação da comunicação entre camadas
- **Testes de API**: Validação dos endpoints REST
- **Testes de Banco**: Verificação da persistência de dados

### Ferramentas Utilizadas

- **Testes Unitários**: JUnit 5 + Mockito (implementado)
- **Testes de API**: Postman/Insomnia (manual)
- **Banco de Dados**: MySQL Workbench (validação)

## 4.2 Casos de Teste Funcionais

### CT001 - Cadastro de Paciente

**Objetivo**: Verificar se o sistema permite cadastrar um novo paciente.

**Pré-condições**:
- Sistema em execução
- Banco de dados MySQL configurado

**Passos**:
1. Enviar requisição POST para `/sghss/api/pacientes`
2. Incluir dados válidos no corpo JSON

**Dados de Entrada**:
```json
{
  "nome": "João Silva",
  "cpf": "12345678901",
  "telefone": "987654321",
  "email": "joao@example.com",
  "endereco": "Rua A, 123",
  "dataNascimento": "15/05/1990"
}
```

**Resultado Esperado**: Status 201 Created, paciente cadastrado no banco.

**Status**: ✅ Aprovado

### CT002 - Listagem de Pacientes

**Objetivo**: Verificar se o sistema lista todos os pacientes cadastrados.

**Pré-condições**: Pelo menos um paciente cadastrado.

**Passos**:
1. Enviar requisição GET para `/sghss/api/pacientes`

**Resultado Esperado**: Status 200 OK, lista de pacientes em JSON.

**Status**: ✅ Aprovado

### CT003 - Busca de Paciente por ID

**Objetivo**: Verificar se o sistema retorna paciente específico.

**Pré-condições**: Paciente com ID 1 cadastrado.

**Passos**:
1. Enviar requisição GET para `/sghss/api/pacientes/1`

**Resultado Esperado**: Status 200 OK, dados do paciente.

**Status**: ✅ Aprovado

### CT004 - Atualização de Paciente

**Objetivo**: Verificar se o sistema permite atualizar dados do paciente.

**Pré-condições**: Paciente cadastrado.

**Passos**:
1. Enviar requisição PUT para `/sghss/api/pacientes/1`
2. Incluir dados atualizados

**Resultado Esperado**: Status 200 OK, dados atualizados no banco.

**Status**: ✅ Aprovado

### CT005 - Exclusão de Paciente

**Objetivo**: Verificar se o sistema permite excluir paciente.

**Pré-condições**: Paciente cadastrado.

**Passos**:
1. Enviar requisição DELETE para `/sghss/api/pacientes/1`

**Resultado Esperado**: Status 204 No Content, paciente removido do banco.

**Status**: ✅ Aprovado

### CT006 - Cadastro de Médico

**Objetivo**: Verificar cadastro de médico com CRM único.

**Passos**:
1. POST `/sghss/api/medicos` com dados válidos

**Resultado Esperado**: Status 201, médico cadastrado.

**Status**: ✅ Aprovado

### CT007 - Validação de CPF Duplicado

**Objetivo**: Verificar se o sistema impede CPF duplicado.

**Passos**:
1. Tentar cadastrar paciente com CPF já existente

**Resultado Esperado**: Status 400 Bad Request, mensagem de erro.

**Status**: ✅ Aprovado

### CT008 - Agendamento de Consulta

**Objetivo**: Verificar criação de consulta entre paciente e médico.

**Pré-condições**: Paciente e médico cadastrados.

**Passos**:
1. POST `/sghss/api/consultas` com IDs válidos

**Dados de Entrada**:
```json
{
  "pacienteId": 1,
  "medicoId": 1,
  "dataConsulta": "10/05/2026",
  "horaConsulta": "14:00",
  "descricao": "Consulta de rotina"
}
```

**Resultado Esperado**: Status 201, consulta agendada.

**Status**: ✅ Aprovado

### CT009 - Tratamento de Erro - Recurso Não Encontrado

**Objetivo**: Verificar tratamento de erro para ID inexistente.

**Passos**:
1. GET `/sghss/api/pacientes/999`

**Resultado Esperado**: Status 404, mensagem padronizada.

**Status**: ✅ Aprovado

## 4.3 Testes Não Funcionais

### TNF001 - Performance

**Objetivo**: Verificar tempo de resposta das operações CRUD.

**Critérios**:
- Tempo médio < 500ms para operações simples
- Tempo médio < 2s para consultas complexas

**Status**: ✅ Aprovado (testado manualmente)

### TNF002 - Segurança

**Objetivo**: Verificar exposição desnecessária de dados.

**Critérios**:
- Uso de DTOs para evitar exposição de entidades
- Validação de entrada de dados

**Status**: ✅ Aprovado

### TNF003 - Usabilidade da API

**Objetivo**: Verificar clareza das respostas da API.

**Critérios**:
- Mensagens de erro em português
- Códigos HTTP apropriados
- Estrutura JSON consistente

**Status**: ✅ Aprovado

## 4.4 Resultados dos Testes

### Resumo Executivo

| Categoria | Total | Aprovados | Taxa de Sucesso |
|-----------|-------|-----------|-----------------|
| Funcionais | 9 | 9 | 100% |
| Não Funcionais | 3 | 3 | 100% |
| **TOTAL** | **12** | **12** | **100%** |

### Cobertura de Testes

- **Unitários**: Implementados com JUnit (PacienteServiceTest)
- **Integração**: Testados manualmente via API
- **Aceitação**: Validados conforme requisitos funcionais

## 4.5 Conclusão

O plano de testes demonstrou que o sistema SGHSS atende integralmente aos requisitos estabelecidos, com taxa de sucesso de 100% nos testes realizados. A estratégia adotada garantiu cobertura adequada das funcionalidades críticas, assegurando qualidade e confiabilidade do produto final.