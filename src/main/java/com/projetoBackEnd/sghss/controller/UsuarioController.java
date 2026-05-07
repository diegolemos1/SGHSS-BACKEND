package com.projetoBackEnd.sghss.controller;

import com.projetoBackEnd.sghss.dto.LoginRequestDTO;
import com.projetoBackEnd.sghss.dto.UsuarioDTO;
import com.projetoBackEnd.sghss.model.Usuario;
import com.projetoBackEnd.sghss.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/sghss/api/auth")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> registrar(@RequestBody Usuario usuario) {
        UsuarioDTO dto = usuarioService.criar(usuario);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequestDTO loginRequest) {
        String token = usuarioService.authenticate(loginRequest);
        return ResponseEntity.ok(Map.of("token", token));
    }
}