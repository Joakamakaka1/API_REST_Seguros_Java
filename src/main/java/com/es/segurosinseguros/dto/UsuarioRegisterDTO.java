package com.es.segurosinseguros.dto;

/**
 * The type Usuario register dto.
 */
public class UsuarioRegisterDTO {
    private String username;
    private String password1;
    private String password2;
    private String rol;

    /**
     * Instantiates a new Usuario register dto.
     *
     * @param username  the username
     * @param password1 the password 1
     * @param password2 the password 2
     * @param rol       the rol
     */
    public UsuarioRegisterDTO(String username, String password1, String password2, String rol) {
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
        this.rol = rol;
    }

    /**
     * Instantiates a new Usuario register dto.
     */
    public UsuarioRegisterDTO() {
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
     * Gets password 1.
     *
     * @return the password 1
     */
    public String getPassword1() {
        return password1;
    }

    /**
     * Sets password 1.
     *
     * @param password1 the password 1
     */
    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    /**
     * Gets password 2.
     *
     * @return the password 2
     */
    public String getPassword2() {
        return password2;
    }

    /**
     * Sets password 2.
     *
     * @param password2 the password 2
     */
    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    /**
     * Gets rol.
     *
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * Sets rol.
     *
     * @param rol the rol
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
}
