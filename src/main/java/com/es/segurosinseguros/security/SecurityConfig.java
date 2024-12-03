package com.es.segurosinseguros.security;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * The type Security config.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private RsaKeyProperties rsaKeys;

    /**
     * Security filter chain security filter chain.
     *
     * @param http the http
     * @return the security filter chain
     * @throws Exception the exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF si no se necesita protección CSRF en la API
                .authorizeHttpRequests(auth -> auth
                        // Rutas públicas
                        .requestMatchers("/usuarios/login", "/usuarios/register").permitAll() // Acceso público para login y registro

                        // Rutas de seguros (Acceso solo para ADMIN y autenticados)
                        .requestMatchers(HttpMethod.GET, "/seguros").hasRole("ADMIN") // Sólo ADMIN puede ver todos los seguros
                        .requestMatchers(HttpMethod.GET, "/seguros/{idSeguro}").authenticated() // Acceso a usuarios autenticados
                        .requestMatchers(HttpMethod.POST, "/seguros").hasRole("ADMIN") // Solo ADMIN puede crear seguros
                        .requestMatchers(HttpMethod.PUT, "/seguros/{idSeguro}").hasRole("ADMIN") // Sólo ADMIN puede editar un seguro
                        .requestMatchers(HttpMethod.DELETE, "/seguros/{idSeguro}").hasRole("ADMIN") // Sólo ADMIN puede eliminar un seguro

                        // Rutas de asistencias médicas (Acceso solo para ADMIN y autenticados)
                        .requestMatchers(HttpMethod.GET, "/asistencias").hasRole("ADMIN") // Solo ADMIN puede ver asistencias
                        .requestMatchers(HttpMethod.GET, "/asistencias/{idAsistenciaMedica}").authenticated() // Acceso a usuarios autenticados
                        .requestMatchers(HttpMethod.POST, "/seguros/{idSeguro}/asistencias").hasRole("ADMIN") // Solo ADMIN puede crear asistencias
                        .requestMatchers(HttpMethod.PUT, "/asistencias/{idAsistenciaMedica}").hasRole("ADMIN") // Sólo ADMIN puede editar asistencias
                        .requestMatchers(HttpMethod.DELETE, "/asistencias/{idAsistenciaMedica}").hasRole("ADMIN") // Sólo ADMIN puede eliminar asistencias

                        // Ruta por defecto: cualquier otra ruta requiere autenticación
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults())) // Establecemos el que el control de autenticación se realice por JWT
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    /**
     * Password encoder password encoder.
     *
     * @return the password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Authentication manager.
     *
     * @param authenticationConfiguration the authentication configuration
     * @return the authentication manager
     * @throws Exception the exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * Jwt decoder jwt decoder.
     *
     * @return the jwt decoder
     */
    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(rsaKeys.publicKey()).build();
    }

    /**
     * Jwt encoder jwt encoder.
     *
     * @return the jwt encoder
     */
    @Bean
    public JwtEncoder jwtEncoder() {
        JWK jwk = new RSAKey.Builder(rsaKeys.publicKey()).privateKey(rsaKeys.privateKey()).build();
        JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));

        return new NimbusJwtEncoder(jwks);
    }
}
