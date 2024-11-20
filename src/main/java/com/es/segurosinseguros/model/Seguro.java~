package com.es.segurosinseguros.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * The type Seguro.
 */
@Entity
@Table(name = "seguro")
public class Seguro {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_seguro")
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
    @Column(name = "sexo", nullable = false)
    private String sexo;
    @Column(name = "casado", nullable = false)
    private boolean casado;
    @Column(name = "embarazada", nullable = false)
    private boolean embarazada;
    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fechaCreacion;

    /**
     * Instantiates a new Seguro.
     *
     * @param nif           the nif
     * @param nombre        the nombre
     * @param ape1          the ape 1
     * @param ape2          the ape 2
     * @param edad          the edad
     * @param numHijos      the num hijos
     * @param sexo          the sexo
     * @param casado        the casado
     * @param embarazada    the embarazada
     * @param fechaCreacion the fecha creacion
     */
    public Seguro(String nif, String nombre, String ape1, String ape2, int edad, int numHijos, String sexo, boolean casado, boolean embarazada, Date fechaCreacion) {
        this.nif = nif;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.edad = edad;
        this.numHijos = numHijos;
        this.sexo = sexo;
        this.casado = casado;
        this.embarazada = embarazada;
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Instantiates a new Seguro.
     */
    public Seguro() {
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
}