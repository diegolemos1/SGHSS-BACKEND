package com.projetoBackEnd.sghss.controller;

import com.projetoBackEnd.sghss.dto.PacienteDTO;
import com.projetoBackEnd.sghss.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteDTO> criar(@RequestBody PacienteDTO dto) {
        PacienteDTO criado = pacienteService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> obterTodos() {
        List<PacienteDTO> pacientes = pacienteService.obterTodos();
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> obterPorId(@PathVariable Long id) {
        PacienteDTO paciente = pacienteService.obterPorId(id);
        return ResponseEntity.ok(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> atualizar(@PathVariable Long id, @RequestBody PacienteDTO dto) {
        PacienteDTO atualizado = pacienteService.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pacienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
