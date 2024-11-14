package com.es.segurosinseguros.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * The type Asistencia medica.
 */
@Entity
@Table(name = "asistencia_medica")
public class AsistenciaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsistenciaMedica;
    @ManyToOne
    @JoinColumn(name = "idSeguro")
    private Seguro seguro;
    @Column(name = "breve_descripcion", nullable = false)
    private String breveDescripcion;
    @Column(name = "lugar", nullable = false)
    private String lugar;
    @Column(name = "explicacion", nullable = false)
    private String explicacion;
    @Column(name = "tipo_asistencia", nullable = false)
    private String tipoAsistencia;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "hora", nullable = false)
    private LocalTime hora;
    @Column(name = "importe", nullable = false)
    private double importe;

    /**
     * Instantiates a new Asistencia medica.
     *
     * @param seguro           the seguro
     * @param breveDescripcion the breve descripcion
     * @param lugar            the lugar
     * @param explicacion      the explicacion
     * @param tipoAsistencia   the tipo asistencia
     * @param fecha            the fecha
     * @param hora             the hora
     * @param importe          the importe
     */
    public AsistenciaMedica(Seguro seguro, String breveDescripcion, String lugar, String explicacion, String tipoAsistencia, LocalDate fecha, LocalTime hora, double importe) {
        this.seguro = seguro;
        this.breveDescripcion = breveDescripcion;
        this.lugar = lugar;
        this.explicacion = explicacion;
        this.tipoAsistencia = tipoAsistencia;
        this.fecha = fecha;
        this.hora = hora;
        this.importe = importe;
    }

    /**
     * Instantiates a new Asistencia medica.
     */
    public AsistenciaMedica() {
    }

    /**
     * Gets id asistencia medica.
     *
     * @return the id asistencia medica
     */
    public Long getIdAsistenciaMedica() {
        return idAsistenciaMedica;
    }

    /**
     * Sets id asistencia medica.
     *
     * @param idAsistenciaMedica the id asistencia medica
     */
    public void setIdAsistenciaMedica(Long idAsistenciaMedica) {
        this.idAsistenciaMedica = idAsistenciaMedica;
    }

    /**
     * Gets seguro.
     *
     * @return the seguro
     */
    public Seguro getSeguro() {
        return seguro;
    }

    /**
     * Sets seguro.
     *
     * @param seguro the seguro
     */
    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
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
}
