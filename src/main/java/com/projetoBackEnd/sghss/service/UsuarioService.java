package com.projetoBackEnd.sghss.service;

import com.projetoBackEnd.sghss.dto.LoginRequestDTO;
import com.projetoBackEnd.sghss.dto.UsuarioDTO;
import com.projetoBackEnd.sghss.exception.ResourceNotFoundException;
import com.projetoBackEnd.sghss.model.Usuario;
import com.projetoBackEnd.sghss.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioDTO criar(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        Usuario saved = usuarioRepository.save(usuario);
        return convertToDTO(saved);
    }

    public UsuarioDTO obterPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        return convertToDTO(usuario);
    }

    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }

    public String authenticate(LoginRequestDTO loginRequest) {
        Usuario usuario = findByUsername(loginRequest.getUsername());
        if (passwordEncoder.matches(loginRequest.getPassword(), usuario.getPassword())) {
            // Simples token, em produção usar JWT
            return "TOKEN_" + usuario.getUsername();
        }
        throw new ResourceNotFoundException("Credenciais inválidas");
    }

    private UsuarioDTO convertToDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setUsername(usuario.getUsername());
        dto.setRole(usuario.getRole());
        return dto;
    }
}