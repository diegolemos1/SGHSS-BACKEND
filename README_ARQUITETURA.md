# SGHSS - Sistema de Gestão Hospitalar

## Visão Geral da Arquitetura

Este projeto implementa uma **arquitetura em camadas monolítica** com a seguinte estrutura:

### 📁 Estrutura de Pacotes

```
src/main/java/com/sghss/projetoBackEnd/
├── controller/       → Endpoints REST API
├── service/          → Regras de negócio
├── repository/       → Acesso aos dados (JPA)
├── model/            → Entidades JPA
├── dto/              → Data Transfer Objects
├── exception/        → Tratamento de exceções
└── config/           → Configuração da aplicação
```

---

## 📋 Funções de Cada Pacote

### 📁 **controller**
Responsible for exposing REST API endpoints, receiving and responding to HTTP requests, following the MVC pattern.
- `PacienteController` - CRUD de pacientes
- `MedicoController` - CRUD de médicos
- `ConsultaController` - CRUD de consultas

### 📁 **service**
Camada que contém as regras de negócio do sistema, garantindo validações e separação de responsabilidades.
- `PacienteService` - Lógica de pacientes
- `MedicoService` - Lógica de médicos
- `ConsultaService` - Lógica de consultas e agendamentos

### 📁 **repository**
Responsável pelo acesso aos dados, utilizando Spring Data JPA para comunicação com o banco MySQL.
- `PacienteRepository` - Operações em BD para pacientes
- `MedicoRepository` - Operações em BD para médicos
- `ConsultaRepository` - Operações em BD para consultas

### 📁 **model**
Contém as entidades JPA que representam o modelo de dados do sistema, de acordo com o DER definido.
- `Paciente` - Entidade de pacientes
- `Medico` - Entidade de médicos
- `Consulta` - Entidade de consultas (relacionamento paciente-médico)

### 📁 **dto**
Utilizado para transferência de dados entre as camadas, evitando exposição direta das entidades.
- `PacienteDTO` - DTO de pacientes
- `MedicoDTO` - DTO de médicos
- `ConsultaDTO` - DTO de consultas

### 📁 **exception**
Centraliza o tratamento de exceções, garantindo respostas padronizadas e melhor manutenção do código.
- `ResourceNotFoundException` - Recurso não encontrado
- `BusinessException` - Erro de validação de negócio
- `GlobalExceptionHandler` - Handler global de exceções

### 📁 **config**
Contém classes de configuração da aplicação.
- `WebConfig` - Configuração de CORS e web

---

## 🔌 Endpoints da API

### Pacientes
```
POST   /sghss/api/pacientes              - Criar paciente
GET    /sghss/api/pacientes              - Listar todos
GET    /sghss/api/pacientes/{id}         - Obter por ID
PUT    /sghss/api/pacientes/{id}         - Atualizar
DELETE /sghss/api/pacientes/{id}         - Deletar
```

### Médicos
```
POST   /sghss/api/medicos                - Criar médico
GET    /sghss/api/medicos                - Listar todos
GET    /sghss/api/medicos/{id}           - Obter por ID
PUT    /sghss/api/medicos/{id}           - Atualizar
DELETE /sghss/api/medicos/{id}           - Deletar
```

### Consultas
```
POST   /sghss/api/consultas              - Criar consulta
GET    /sghss/api/consultas              - Listar todas
GET    /sghss/api/consultas/{id}         - Obter por ID
GET    /sghss/api/consultas/paciente/{pacienteId}  - Listar por paciente
GET    /sghss/api/consultas/medico/{medicoId}     - Listar por médico
PATCH  /sghss/api/consultas/{id}/status - Atualizar status
DELETE /sghss/api/consultas/{id}         - Deletar
```

---

## 🗄️ Configuração do Banco de Dados

### MySQL
```sql
CREATE DATABASE sghss_db;
```

**Credenciais (padrão):**
- Host: `localhost`
- Port: `3306`
- Database: `sghss_db`
- Username: `root`
- Password: `root`

As tabelas serão criadas automaticamente pelo Hibernate (ddl-auto: update).

---

## 🚀 Como Executar

### Pré-requisitos
- Java 17+
- Maven 3.6+
- MySQL 8.0+

### Passos
1. Clone o repositório
2. Configure as credenciais MySQL em `application.properties`
3. Execute: `mvn clean install`
4. Execute: `mvn spring-boot:run`
5. A API estará disponível em: `http://localhost:8080/sghss`

---

## 📦 Dependências Principais
- Spring Boot 4.0.6
- Spring Data JPA
- MySQL Connector
- Lombok

---

## 📝 Exemplo de Requisição

### Criar Paciente
```bash
curl -X POST http://localhost:8080/sghss/api/pacientes \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "cpf": "12345678901",
    "telefone": "987654321",
    "email": "joao@example.com",
    "endereco": "Rua das Flores, 123",
    "dataNascimento": "15/05/1990"
  }'
```

---

## 📄 Estrutura do Projeto
- **Projeto Base:** Spring Boot 4.0.6
- **Padrão Arquitetural:** Arquitetura em Camadas
- **Banco de Dados:** MySQL 8.0+
- **ORM:** JPA/Hibernate
