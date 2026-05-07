-- Dados de exemplo para testes

-- Inserir pacientes de exemplo
INSERT INTO pacientes (nome, cpf, telefone, email, endereco, data_nascimento, data_cadastro, ativo) VALUES
('João Silva', '12345678901', '987654321', 'joao@example.com', 'Rua A, 123', '15/05/1990', '04/05/2026 10:00:00', TRUE),
('Maria Santos', '98765432101', '987654322', 'maria@example.com', 'Rua B, 456', '20/08/1985', '04/05/2026 10:15:00', TRUE),
('Pedro Oliveira', '11122233344', '987654323', 'pedro@example.com', 'Rua C, 789', '30/12/1992', '04/05/2026 10:30:00', TRUE);

-- Inserir médicos de exemplo
INSERT INTO medicos (nome, cpf, crm, especialidade, telefone, email, data_cadastro, ativo) VALUES
('Dr. Carlos Ferreira', '55566677788', '123456', 'Cardiologia', '987654324', 'carlos@example.com', '04/05/2026 11:00:00', TRUE),
('Dra. Ana Costa', '44455566677', '654321', 'Dermatologia', '987654325', 'ana@example.com', '04/05/2026 11:15:00', TRUE),
('Dr. Roberto Lima', '33344455566', '789012', 'Ortopedia', '987654326', 'roberto@example.com', '04/05/2026 11:30:00', TRUE);

-- Inserir consultas de exemplo
INSERT INTO consultas (paciente_id, medico_id, data_consulta, hora_consulta, descricao, diagnostico, status, data_cadastro) VALUES
(1, 1, '10/05/2026', '14:00', 'Consulta de rotina', 'Pressão arterial elevada', 'AGENDADA', '04/05/2026 12:00:00'),
(2, 2, '12/05/2026', '15:30', 'Avaliação dermatológica', 'Acne leve', 'AGENDADA', '04/05/2026 12:15:00'),
(3, 3, '15/05/2026', '10:00', 'Avaliação pós-lesão', NULL, 'AGENDADA', '04/05/2026 12:30:00');
