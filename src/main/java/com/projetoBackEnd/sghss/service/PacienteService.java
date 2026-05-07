package com.projetoBackEnd.sghss.service;

import com.projetoBackEnd.sghss.dto.PacienteDTO;
import com.projetoBackEnd.sghss.exception.BusinessException;
import com.projetoBackEnd.sghss.exception.ResourceNotFoundException;
import com.projetoBackEnd.sghss.model.Paciente;
import com.projetoBackEnd.sghss.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public PacienteDTO criar(PacienteDTO dto) {
        if (pacienteRepository.existsByCpf(dto.getCpf())) {
            throw new BusinessException("Já existe um paciente com esse CPF");
        }

        Paciente paciente = new Paciente();
        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setTelefone(dto.getTelefone());
        paciente.setEmail(dto.getEmail());
        paciente.setEndereco(dto.getEndereco());
        paciente.setDataNascimento(dto.getDataNascimento());
        paciente.setDataCadastro(LocalDateTime.now().format(formatter));
        paciente.setAtivo(true);

        Paciente salvo = pacienteRepository.save(paciente);
        return convertToDTO(salvo);
    }

    public PacienteDTO obterPorId(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com ID: " + id));
        return convertToDTO(paciente);
    }

    public List<PacienteDTO> obterTodos() {
        return pacienteRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    public PacienteDTO atualizar(Long id, PacienteDTO dto) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com ID: " + id));

        paciente.setNome(dto.getNome());
        paciente.setTelefone(dto.getTelefone());
        paciente.setEmail(dto.getEmail());
        paciente.setEndereco(dto.getEndereco());

        Paciente atualizado = pacienteRepository.save(paciente);
        return convertToDTO(atualizado);
    }

    public void deletar(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com ID: " + id));

        pacienteRepository.delete(paciente);
    }

    private PacienteDTO convertToDTO(Paciente paciente) {
        return new PacienteDTO(
                paciente.getId(),
                paciente.getNome(),
                paciente.getCpf(),
                paciente.getTelefone(),
                paciente.getEmail(),
                paciente.getEndereco(),
                paciente.getDataNascimento(),
                paciente.getDataCadastro(),
                paciente.getAtivo()
        );
    }
}
