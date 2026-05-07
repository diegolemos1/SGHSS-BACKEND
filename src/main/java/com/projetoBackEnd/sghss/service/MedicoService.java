package com.projetoBackEnd.sghss.service;

import com.projetoBackEnd.sghss.dto.MedicoDTO;
import com.projetoBackEnd.sghss.exception.BusinessException;
import com.projetoBackEnd.sghss.exception.ResourceNotFoundException;
import com.projetoBackEnd.sghss.model.Medico;
import com.projetoBackEnd.sghss.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public MedicoDTO criar(MedicoDTO dto) {
        if (medicoRepository.existsByCpf(dto.getCpf())) {
            throw new BusinessException("Já existe um médico com esse CPF");
        }

        if (medicoRepository.existsByCrm(dto.getCrm())) {
            throw new BusinessException("Já existe um médico com esse CRM");
        }

        Medico medico = new Medico();
        medico.setNome(dto.getNome());
        medico.setCpf(dto.getCpf());
        medico.setCrm(dto.getCrm());
        medico.setEspecialidade(dto.getEspecialidade());
        medico.setTelefone(dto.getTelefone());
        medico.setEmail(dto.getEmail());
        medico.setDataCadastro(LocalDateTime.now().format(formatter));
        medico.setAtivo(true);

        Medico salvo = medicoRepository.save(medico);
        return convertToDTO(salvo);
    }

    public MedicoDTO obterPorId(Long id) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado com ID: " + id));
        return convertToDTO(medico);
    }

    public List<MedicoDTO> obterTodos() {
        return medicoRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    public MedicoDTO atualizar(Long id, MedicoDTO dto) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado com ID: " + id));

        medico.setNome(dto.getNome());
        medico.setEspecialidade(dto.getEspecialidade());
        medico.setTelefone(dto.getTelefone());
        medico.setEmail(dto.getEmail());

        Medico atualizado = medicoRepository.save(medico);
        return convertToDTO(atualizado);
    }

    public void deletar(Long id) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado com ID: " + id));

        medicoRepository.delete(medico);
    }

    private MedicoDTO convertToDTO(Medico medico) {
        return new MedicoDTO(
                medico.getId(),
                medico.getNome(),
                medico.getCpf(),
                medico.getCrm(),
                medico.getEspecialidade(),
                medico.getTelefone(),
                medico.getEmail(),
                medico.getDataCadastro(),
                medico.getAtivo()
        );
    }
}
