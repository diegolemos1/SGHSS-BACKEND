package com.projetoBackEnd.sghss.service;

import com.projetoBackEnd.sghss.dto.ConsultaDTO;
import com.projetoBackEnd.sghss.exception.ResourceNotFoundException;
import com.projetoBackEnd.sghss.model.Consulta;
import com.projetoBackEnd.sghss.model.Medico;
import com.projetoBackEnd.sghss.model.Paciente;
import com.projetoBackEnd.sghss.repository.ConsultaRepository;
import com.projetoBackEnd.sghss.repository.MedicoRepository;
import com.projetoBackEnd.sghss.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public ConsultaDTO criar(ConsultaDTO dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));

        Medico medico = medicoRepository.findById(dto.getMedicoId())
                .orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado"));

        Consulta consulta = new Consulta();
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setDataConsulta(dto.getDataConsulta());
        consulta.setHoraConsulta(dto.getHoraConsulta());
        consulta.setDescricao(dto.getDescricao());
        consulta.setStatus("AGENDADA");
        consulta.setDataCadastro(LocalDateTime.now().format(formatter));

        Consulta salva = consultaRepository.save(consulta);
        return convertToDTO(salva);
    }

    public ConsultaDTO obterPorId(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com ID: " + id));
        return convertToDTO(consulta);
    }

    public List<ConsultaDTO> obterTodas() {
        return consultaRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    public List<ConsultaDTO> obterPorPaciente(Long pacienteId) {
        return consultaRepository.findByPacienteId(pacienteId).stream()
                .map(this::convertToDTO)
                .toList();
    }

    public List<ConsultaDTO> obterPorMedico(Long medicoId) {
        return consultaRepository.findByMedicoId(medicoId).stream()
                .map(this::convertToDTO)
                .toList();
    }

    public ConsultaDTO atualizarStatus(Long id, String novoStatus) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com ID: " + id));

        consulta.setStatus(novoStatus);
        Consulta atualizada = consultaRepository.save(consulta);
        return convertToDTO(atualizada);
    }

    public void deletar(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com ID: " + id));

        consultaRepository.delete(consulta);
    }

    private ConsultaDTO convertToDTO(Consulta consulta) {
        return new ConsultaDTO(
                consulta.getId(),
                consulta.getPaciente().getId(),
                consulta.getMedico().getId(),
                consulta.getDataConsulta(),
                consulta.getHoraConsulta(),
                consulta.getDescricao(),
                consulta.getDiagnostico(),
                consulta.getStatus(),
                consulta.getDataCadastro()
        );
    }
}
