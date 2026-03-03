package com.mibanco.gestiongastos.modelos;

import com.mibanco.gestiongastos.utils.LocalDateAdapter;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase modelo para representar un gasto
 */
public class Gasto {
    private Integer id;
    private String titulo;
    private String motivo;
    private LocalDate fecha;
    private Double monto;

    public Gasto(Integer id, String titulo, String motivo, LocalDate fecha, Double monto) {
        this.id = id;
        this.titulo = titulo;
        this.motivo = motivo;
        this.fecha = fecha;
        this.monto = monto;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {

        String fechaFormateada = (fecha != null)
            ? fecha.format(LocalDateAdapter.formatter)
            : "Sin fecha";

        return "ID: " + id +
                " | Título: " + titulo +
                " | Motivo: " + motivo +
                " | Fecha: " + fechaFormateada +
                " | Monto: S/" + String.format("%.2f", monto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gasto gasto = (Gasto) o;
        return Objects.equals(id, gasto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
