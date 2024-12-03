package com.es.segurosinseguros.service;

import com.es.segurosinseguros.dto.UsuarioRegisterDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.exception.DuplicateException;
import com.es.segurosinseguros.model.Usuario;
import com.es.segurosinseguros.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private UsuarioRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario No encontrado"));

        List<GrantedAuthority> authorities = Arrays.stream(usuario.getRol().split(","))
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.trim()))
                .collect(Collectors.toList());

        UserDetails userDetails = User // User pertenece a SpringSecurity
                .builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .authorities(authorities)
                .build();

        return userDetails;
    }

    public UsuarioRegisterDTO createUser(UsuarioRegisterDTO userRegisterDTO) {
        if (userRepository.findByUsername(userRegisterDTO.getUsername()).isPresent()) {
            throw new DuplicateException("El usuario ya existe");
        }

        if (!userRegisterDTO.getRol().equals("ROLE_ADMIN") && !userRegisterDTO.getRol().equals("ROLE_USER")) {
            throw new BadRequestException("El rol debe ser ADMIN o USER");
        }

        if (!userRegisterDTO.getPassword1().equals(userRegisterDTO.getPassword2())) {
            throw new BadRequestException("Las contrasenas no coinciden");
        }

        Usuario newUsuario = new Usuario();
        newUsuario.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword1())); // Hashear la contraseña
        newUsuario.setUsername(userRegisterDTO.getUsername());
        newUsuario.setRol(userRegisterDTO.getRol());

        userRepository.save(newUsuario);

        return userRegisterDTO;
    }
}
