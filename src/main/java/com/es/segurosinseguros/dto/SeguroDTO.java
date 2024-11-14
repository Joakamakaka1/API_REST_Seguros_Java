package com.es.segurosinseguros.dto;

/**
 * The type Seguro dto.
 */
public class SeguroDTO {
    private String nif;
    private String nombre;
    private String ape1;
    private String ape2;
    private int edad;
    private int numHijos;
    private String sexo;
    private boolean casado;
    private boolean embarazada;

    /**
     * Instantiates a new Seguro dto.
     */
    public SeguroDTO() {
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
}
