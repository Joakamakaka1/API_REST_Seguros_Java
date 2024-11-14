package com.es.segurosinseguros.dto;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * The type Asistencia medica dto.
 */
public class AsistenciaMedicaDTO {

    private String breveDescripcion;
    private String lugar;
    private String explicacion;
    private String tipoAsistencia;
    private LocalDate fecha;
    private LocalTime hora;
    private double importe;

    /**
     * Instantiates a new Asistencia medica dto.
     */
    public AsistenciaMedicaDTO() {
    }

    /**
     * Gets breve descripcion.
     *
     * @return the breve descripcion
     */
    public String getBreveDescripcion() {
        return breveDescripcion;
    }

    /**
     * Sets breve descripcion.
     *
     * @param breveDescripcion the breve descripcion
     */
    public void setBreveDescripcion(String breveDescripcion) {
        this.breveDescripcion = breveDescripcion;
    }

    /**
     * Gets lugar.
     *
     * @return the lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Sets lugar.
     *
     * @param lugar the lugar
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * Gets explicacion.
     *
     * @return the explicacion
     */
    public String getExplicacion() {
        return explicacion;
    }

    /**
     * Sets explicacion.
     *
     * @param explicacion the explicacion
     */
    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    /**
     * Gets tipo asistencia.
     *
     * @return the tipo asistencia
     */
    public String getTipoAsistencia() {
        return tipoAsistencia;
    }

    /**
     * Sets tipo asistencia.
     *
     * @param tipoAsistencia the tipo asistencia
     */
    public void setTipoAsistencia(String tipoAsistencia) {
        this.tipoAsistencia = tipoAsistencia;
    }

    /**
     * Gets fecha.
     *
     * @return the fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Sets fecha.
     *
     * @param fecha the fecha
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Gets hora.
     *
     * @return the hora
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Sets hora.
     *
     * @param hora the hora
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /**
     * Gets importe.
     *
     * @return the importe
     */
    public double getImporte() {
        return importe;
    }

    /**
     * Sets importe.
     *
     * @param importe the importe
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }
}
