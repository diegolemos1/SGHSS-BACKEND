package com.projetoBackEnd.sghss.service;

import com.projetoBackEnd.sghss.dto.PacienteDTO;
import com.projetoBackEnd.sghss.exception.ResourceNotFoundException;
import com.projetoBackEnd.sghss.model.Paciente;
import com.projetoBackEnd.sghss.repository.PacienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PacienteServiceTest {

    @Mock
    private PacienteRepository pacienteRepository;

    @InjectMocks
    private PacienteService pacienteService;

    private Paciente paciente;

    @BeforeEach
    void setUp() {
        paciente = new Paciente();
        paciente.setId(1L);
        paciente.setNome("João Silva");
        paciente.setCpf("12345678901");
        paciente.setTelefone("987654321");
        paciente.setEmail("joao@example.com");
        paciente.setEndereco("Rua A, 123");
        paciente.setDataNascimento("15/05/1990");
        paciente.setDataCadastro("04/05/2026 10:00:00");
        paciente.setAtivo(true);
    }

    @Test
    void deveRetornarPacienteQuandoIdExistir() {
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));

        PacienteDTO result = pacienteService.obterPorId(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("João Silva", result.getNome());
    }

    @Test
    void deveLancarResourceNotFoundExceptionQuandoPacienteNaoExistir() {
        when(pacienteRepository.findById(2L)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class,
                () -> pacienteService.obterPorId(2L));

        assertTrue(exception.getMessage().contains("Paciente não encontrado"));
    }
}
