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
    @Column(nullable = false, unique = true, length = 10)
    private String nif;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false, length = 100)
    private String ape1;
    @Column(length = 100)
    private String ape2;
    @Column(nullable = false)
    private int edad;
    @Column(nullable = false)
    private int numHijos;
    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;
    @Column(nullable = false, length = 10)
    private String sexo;
    @Column(nullable = false)
    private Boolean casado;
    @Column(nullable = false)
    private Boolean embarazada;
    @OneToMany(mappedBy = "seguro", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<AsistenciaMedica> asistencias;
    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    /**
     * Instantiates a new Seguro.
     *
     * @param nif        the nif
     * @param nombre     the nombre
     * @param ape1       the ape 1
     * @param ape2       the ape 2
     * @param edad       the edad
     * @param numHijos   the num hijos
     * @param sexo       the sexo
     * @param casado     the casado
     * @param embarazada the embarazada
     */
    public Seguro(String nif, String nombre, String ape1, String ape2, int edad, int numHijos, String sexo, Boolean casado, Boolean embarazada) {
        this.nif = nif;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.edad = edad;
        this.numHijos = numHijos;
        this.fechaCreacion = LocalDate.now();
        this.sexo = sexo;
        this.casado = casado;
        this.embarazada = embarazada;
    }

    /**
     * Instantiates a new Seguro.
     */
    public Seguro() {
        this.fechaCreacion = LocalDate.now();
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
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Sets fecha creacion.
     *
     * @param fechaCreacion the fecha creacion
     */
    public void setFechaCreacion(LocalDate fechaCreacion) {
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
     * Gets casado.
     *
     * @return the casado
     */
    public Boolean getCasado() {
        return casado;
    }

    /**
     * Sets casado.
     *
     * @param casado the casado
     */
    public void setCasado(Boolean casado) {
        this.casado = casado;
    }

    /**
     * Gets embarazada.
     *
     * @return the embarazada
     */
    public Boolean getEmbarazada() {
        return embarazada;
    }

    /**
     * Sets embarazada.
     *
     * @param embarazada the embarazada
     */
    public void setEmbarazada(Boolean embarazada) {
        this.embarazada = embarazada;
    }
}