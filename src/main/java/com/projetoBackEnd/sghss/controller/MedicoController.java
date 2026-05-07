package com.projetoBackEnd.sghss.controller;

import com.projetoBackEnd.sghss.dto.MedicoDTO;
import com.projetoBackEnd.sghss.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<MedicoDTO> criar(@RequestBody MedicoDTO dto) {
        MedicoDTO criado = medicoService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> obterTodos() {
        List<MedicoDTO> medicos = medicoService.obterTodos();
        return ResponseEntity.ok(medicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> obterPorId(@PathVariable Long id) {
        MedicoDTO medico = medicoService.obterPorId(id);
        return ResponseEntity.ok(medico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoDTO> atualizar(@PathVariable Long id, @RequestBody MedicoDTO dto) {
        MedicoDTO atualizado = medicoService.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        medicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
