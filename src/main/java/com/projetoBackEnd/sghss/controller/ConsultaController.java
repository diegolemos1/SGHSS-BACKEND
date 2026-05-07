package com.projetoBackEnd.sghss.controller;

import com.projetoBackEnd.sghss.dto.ConsultaDTO;
import com.projetoBackEnd.sghss.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/consultas")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaDTO> criar(@RequestBody ConsultaDTO dto) {
        ConsultaDTO criada = consultaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    @GetMapping
    public ResponseEntity<List<ConsultaDTO>> obterTodas() {
        List<ConsultaDTO> consultas = consultaService.obterTodas();
        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> obterPorId(@PathVariable Long id) {
        ConsultaDTO consulta = consultaService.obterPorId(id);
        return ResponseEntity.ok(consulta);
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<ConsultaDTO>> obterPorPaciente(@PathVariable Long pacienteId) {
        List<ConsultaDTO> consultas = consultaService.obterPorPaciente(pacienteId);
        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/medico/{medicoId}")
    public ResponseEntity<List<ConsultaDTO>> obterPorMedico(@PathVariable Long medicoId) {
        List<ConsultaDTO> consultas = consultaService.obterPorMedico(medicoId);
        return ResponseEntity.ok(consultas);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ConsultaDTO> atualizarStatus(@PathVariable Long id, @RequestBody Map<String, String> request) {
        String novoStatus = request.get("status");
        ConsultaDTO atualizada = consultaService.atualizarStatus(id, novoStatus);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        consultaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}


