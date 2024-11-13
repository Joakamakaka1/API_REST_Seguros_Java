package com.es.segurosinseguros.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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

    public Seguro() {
    }

    public Long getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(Long idSeguro) {
        this.idSeguro = idSeguro;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public boolean isEmbarazada() {
        return embarazada;
    }

    public void setEmbarazada(boolean embarazada) {
        this.embarazada = embarazada;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}