package com.es.segurosinseguros.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * The type Seguro.
 */
/*
 * The type Seguro.
 */
@Entity
@Table(name = "seguros")
public class Seguro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeguro;
    @Column(name = "nif", nullable = false, unique = true)
    private String nif;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "ape1", nullable = false)
    private String ape1;
    @Column(name = "ape2")
    private String ape2;
    @Column(name = "edad", nullable = false)
    private int edad;
    @Column(name = "num_hijos")
    private int numHijos;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    @Column(name = "sexo", nullable = false)
    private String sexo;
    @Column(name = "casado")
    private boolean casado;
    @Column(name = "embarazada")
    private boolean embarazada;
    @OneToMany(mappedBy = "seguro", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<AsistenciaMedica> asistenciaMedica;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    /**
     * Instantiates a new Seguro.
     */
    public Seguro() {
    }

    /**
     * Instantiates a new Seguro.
     *
     * @param embarazada    the embarazada
     * @param casado        the casado
     * @param sexo          the sexo
     * @param fechaCreacion the fecha creacion
     * @param numHijos      the num hijos
     * @param edad          the edad
     * @param ape2          the ape 2
     * @param ape1          the ape 1
     * @param nombre        the nombre
     * @param nif           the nif
     * @param idSeguro      the id seguro
     */
    public Seguro(boolean embarazada, boolean casado, String sexo, Date fechaCreacion, int numHijos, int edad, String ape2, String ape1, String nombre, String nif, Long idSeguro) {
        this.embarazada = embarazada;
        this.casado = casado;
        this.sexo = sexo;
        this.fechaCreacion = fechaCreacion;
        this.numHijos = numHijos;
        this.edad = edad;
        this.ape2 = ape2;
        this.ape1 = ape1;
        this.nombre = nombre;
        this.nif = nif;
        this.idSeguro = idSeguro;
    }

    /**
     * Gets id seguro.
     *
     * @return the id seguro
     */
    public Long getIdSeguro() {
        return idSeguro;
    }

    /**
     * Sets id seguro.
     *
     * @param idSeguro the id seguro
     */
    public void setIdSeguro(Long idSeguro) {
        this.idSeguro = idSeguro;
    }

    /**
     * Gets nif.
     *
     * @return the nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * Sets nif.
     *
     * @param nif the nif
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets nombre.
     *
     * @param nombre the nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets ape 1.
     *
     * @return the ape 1
     */
    public String getApe1() {
        return ape1;
    }

    /**
     * Sets ape 1.
     *
     * @param ape1 the ape 1
     */
    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    /**
     * Gets ape 2.
     *
     * @return the ape 2
     */
    public String getApe2() {
        return ape2;
    }

    /**
     * Sets ape 2.
     *
     * @param ape2 the ape 2
     */
    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    /**
     * Gets edad.
     *
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Sets edad.
     *
     * @param edad the edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Gets num hijos.
     *
     * @return the num hijos
     */
    public int getNumHijos() {
        return numHijos;
    }

    /**
     * Sets num hijos.
     *
     * @param numHijos the num hijos
     */
    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    /**
     * Gets fecha creacion.
     *
     * @return the fecha creacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Sets fecha creacion.
     *
     * @param fechaCreacion the fecha creacion
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Gets sexo.
     *
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Sets sexo.
     *
     * @param sexo the sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Is casado boolean.
     *
     * @return the boolean
     */
    public boolean isCasado() {
        return casado;
    }

    /**
     * Sets casado.
     *
     * @param casado the casado
     */
    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    /**
     * Is embarazada boolean.
     *
     * @return the boolean
     */
    public boolean isEmbarazada() {
        return embarazada;
    }

    /**
     * Sets embarazada.
     *
     * @param embarazada the embarazada
     */
    public void setEmbarazada(boolean embarazada) {
        this.embarazada = embarazada;
    }

    /**
     * Gets asistencia medica.
     *
     * @return the asistencia medica
     */
    public List<AsistenciaMedica> getAsistenciaMedica() {
        return asistenciaMedica;
    }

    /**
     * Sets asistencia medica.
     *
     * @param asistenciaMedica the asistencia medica
     */
    public void setAsistenciaMedica(List<AsistenciaMedica> asistenciaMedica) {
        this.asistenciaMedica = asistenciaMedica;
    }

    /**
     * Gets usuario.
     *
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Sets usuario.
     *
     * @param usuario the usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}