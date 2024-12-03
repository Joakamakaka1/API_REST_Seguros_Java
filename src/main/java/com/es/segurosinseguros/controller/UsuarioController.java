package com.es.segurosinseguros.controller;

import com.es.segurosinseguros.dto.UsuarioLoginDTO;
import com.es.segurosinseguros.dto.UsuarioRegisterDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.exception.ErrorMsgForClient;
import com.es.segurosinseguros.exception.GenericException;
import com.es.segurosinseguros.exception.ResourceNotFoundException;
import com.es.segurosinseguros.service.TokenService;
import com.es.segurosinseguros.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Usuario controller.
 */
@RestController
@RequestMapping("/usuarios") // -> http://localhost:8080/usuarios
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * Login string.
     *
     * @param usuarioLoginDTO the usuario login dto
     * @return the string
     */
    @PostMapping("/login") // -> http://localhost:8080/login
    public String login(@RequestBody UsuarioLoginDTO usuarioLoginDTO) {
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(usuarioLoginDTO.getUsername(), usuarioLoginDTO.getPassword())// modo de autenticación
            );
        } catch (Exception e) {
            throw new ResourceNotFoundException("Credenciales del usuario incorrectas");
        }

        // Generamos el token
        String token = "";
        try {
            token = tokenService.generateToken(authentication);
        } catch (Exception e) {
            throw new GenericException("Error al generar el token de autenticación");
        }

        // Retornamos el token
        return token;
    }

    /**
     * Register response entity.
     *
     * @param usuarioRegisterDTO the usuario register dto
     * @return the response entity
     */
    @PostMapping("/register") // -> http://localhost:8080/register
    public ResponseEntity<?> register(@RequestBody UsuarioRegisterDTO usuarioRegisterDTO) {
        try {
            usuarioService.createUser(usuarioRegisterDTO);
            return new ResponseEntity<>(usuarioRegisterDTO, HttpStatus.CREATED);
        } catch (BadRequestException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/register");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        } catch (GenericException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/register");
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ResourceNotFoundException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/register");
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
}
