package com.es.segurosinseguros.dto;

/**
 * The type Usuario login dto.
 */
public class UsuarioLoginDTO {
    private String username;
    private String password;

    /**
     * Instantiates a new Usuario login dto.
     *
     * @param username the username
     * @param password the password
     */
    public UsuarioLoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Instantiates a new Usuario login dto.
     */
    public UsuarioLoginDTO() {
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
