-- Criar banco de dados
CREATE DATABASE IF NOT EXISTS sghss_db;
USE sghss_db;

-- Tabela de Pacientes
CREATE TABLE pacientes (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    telefone VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    data_nascimento VARCHAR(10),
    data_cadastro VARCHAR(19),
    ativo BOOLEAN DEFAULT TRUE,
    INDEX idx_cpf (cpf)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabela de Médicos
CREATE TABLE medicos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    crm VARCHAR(12) NOT NULL UNIQUE,
    especialidade VARCHAR(100) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    data_cadastro VARCHAR(19),
    ativo BOOLEAN DEFAULT TRUE,
    INDEX idx_cpf (cpf),
    INDEX idx_crm (crm)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabela de Consultas
CREATE TABLE consultas (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    paciente_id BIGINT NOT NULL,
    medico_id BIGINT NOT NULL,
    data_consulta VARCHAR(10) NOT NULL,
    hora_consulta VARCHAR(5) NOT NULL,
    descricao VARCHAR(500),
    diagnostico VARCHAR(100),
    status VARCHAR(20) DEFAULT 'AGENDADA',
    data_cadastro VARCHAR(19),
    FOREIGN KEY (paciente_id) REFERENCES pacientes(id) ON DELETE CASCADE,
    FOREIGN KEY (medico_id) REFERENCES medicos(id) ON DELETE RESTRICT,
    INDEX idx_paciente (paciente_id),
    INDEX idx_medico (medico_id),
    INDEX idx_status (status)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
