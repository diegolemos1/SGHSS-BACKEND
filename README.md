# SGHSS - Sistema de Gestão Hospitalar

Sistema completo de gestão hospitalar desenvolvido em Spring Boot, atendendo aos requisitos do Projeto Multidisciplinar da UNINTER.

## 📋 Estrutura do Projeto

### Pacotes Java
```
src/main/java/com/projetoBackEnd/sghss/
├── controller/     # Endpoints REST API
├── service/        # Regras de negócio
├── repository/     # Acesso aos dados (JPA)
├── model/          # Entidades JPA
├── dto/            # Data Transfer Objects
├── exception/      # Tratamento de erros
└── config/         # Configurações
```

### Arquivos de Documentação
- `RELATORIO_FINAL_FORMATADO.md` - Relatório completo para UNINTER
- `FASE1_PLANEAMENTO.md` - Estudos e planeamento
- `RELATORIO_FASE2_3.md` - Arquitetura e modelagem
- `FASE4_TESTES.md` - Plano de testes
- `CONCLUSAO_FINAL.md` - Conclusão e trabalhos futuros
- `README_ARQUITETURA.md` - Documentação técnica

## 🚀 Como Executar

### Pré-requisitos
- Java 17+
- Maven 3.6+
- MySQL 8.0+

### Passos
1. **Configurar MySQL**:
   ```sql
   CREATE DATABASE sghss_db;
   ```

2. **Configurar aplicação** (em `src/main/resources/application.properties`):
   ```properties
   spring.datasource.username=root
   spring.datasource.password=sua_senha
   ```

3. **Executar**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Acessar API**: `http://localhost:8080/sghss`

## 📡 Endpoints da API

### Pacientes
- `POST /sghss/api/pacientes` - Criar
- `GET /sghss/api/pacientes` - Listar todos
- `GET /sghss/api/pacientes/{id}` - Buscar por ID
- `PUT /sghss/api/pacientes/{id}` - Atualizar
- `DELETE /sghss/api/pacientes/{id}` - Excluir

### Médicos
- `POST /sghss/api/medicos` - Criar
- `GET /sghss/api/medicos` - Listar todos
- `GET /sghss/api/medicos/{id}` - Buscar por ID
- `PUT /sghss/api/medicos/{id}` - Atualizar
- `DELETE /sghss/api/medicos/{id}` - Excluir

### Consultas
- `POST /sghss/api/consultas` - Agendar
- `GET /sghss/api/consultas` - Listar todas
- `GET /sghss/api/consultas/{id}` - Buscar por ID
- `GET /sghss/api/consultas/paciente/{id}` - Por paciente
- `GET /sghss/api/consultas/medico/{id}` - Por médico
- `PATCH /sghss/api/consultas/{id}/status` - Atualizar status
- `DELETE /sghss/api/consultas/{id}` - Cancelar

### Autenticação
- `POST /sghss/api/auth/register` - Registrar usuário
- `POST /sghss/api/auth/login` - Login (retorna token)

**Nota**: Todos os endpoints acima da API exigem autenticação via Basic Auth ou token.

## 🧪 Testes

### Executar Testes
```bash
mvn test
```

### Cobertura
- **Unitários**: JUnit 5 + Mockito (PacienteServiceTest)
- **Funcionais**: 9 casos de teste (100% aprovação)
- **Não Funcionais**: 3 testes (100% aprovação)

## 🏗️ Arquitetura

### Padrão
- **Monolítica em camadas**
- **Spring Boot** com separação clara de responsabilidades

### Componentes
- **Controller**: Exposição da API REST
- **Service**: Lógica de negócio e validações
- **Repository**: Persistência com JPA
- **Model**: Entidades do domínio
- **DTO**: Transferência de dados
- **Exception**: Tratamento padronizado de erros

## 📊 Modelo de Dados

### Entidades
- **Paciente**: Dados pessoais e contato
- **Medico**: Profissional com CRM e especialidade
- **Consulta**: Agendamento entre paciente e médico

### Relacionamentos
- Paciente 1:N Consulta
- Medico 1:N Consulta

## 🛠️ Tecnologias

- **Java 17**
- **Spring Boot 4.0.6**
- **Spring Data JPA**
- **MySQL 8.0**
- **Maven**
- **JUnit 5**
- **Lombok**

## 📈 Status do Projeto

✅ **FASE 1**: Estudos e Planeamento - Concluído  
✅ **FASE 2**: Arquitetura - Concluído  
✅ **FASE 3**: Implementação - Concluído  
✅ **FASE 4**: Testes - Concluído  
✅ **FASE 5**: Documentação - Concluído  

**Resultado**: 100% dos requisitos atendidos, pronto para avaliação UNINTER.

## 📝 Relatório Final

Para gerar o PDF do relatório:

1. Abrir `RELATORIO_FINAL_FORMATADO.md`
2. Copiar conteúdo para editor de texto
3. Salvar como PDF

O relatório inclui todas as fases exigidas pela UNINTER com diagramas, tabelas e explicações técnicas.
