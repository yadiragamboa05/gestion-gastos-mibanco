package com.mibanco.gestiongastos.manager;

import com.mibanco.gestiongastos.modelos.Gasto;
import java.time.LocalDate;
import java.util.*;

/**
 * Clase para gestionar los gastos en memoria
 */
public class GastoManager {
    private List<Gasto> gastos;
    private Integer contadorIds;

    public GastoManager() {
        this.gastos = new ArrayList<>();
        this.contadorIds = 0;
    }

    /**
     * Agrega un nuevo gasto
     */
    public void agregarGasto(String titulo, String motivo, LocalDate fecha, Double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula");
        }

        contadorIds++;
        Gasto gasto = new Gasto(contadorIds, titulo, motivo, fecha, monto);
        gastos.add(gasto);
    }

    /**
     * Actualiza un gasto existente
     */
    public boolean actualizarGasto(Integer id, String titulo, String motivo, LocalDate fecha, Double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }

        Gasto gasto = obtenerGastoPorId(id);
        if (gasto != null) {
            gasto.setTitulo(titulo);
            gasto.setMotivo(motivo);
            gasto.setFecha(fecha);
            gasto.setMonto(monto);
            return true;
        }
        return false;
    }

    /**
     * Elimina un gasto por ID
     */
    public boolean eliminarGasto(Integer id) {
        return gastos.removeIf(g -> g.getId().equals(id));
    }

    /**
     * Obtiene un gasto por ID
     */
    public Gasto obtenerGastoPorId(Integer id) {
        return gastos.stream()
                .filter(g -> g.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Obtiene todos los gastos
     */
    public List<Gasto> obtenerTodosLosGastos() {
        return new ArrayList<>(gastos);
    }

    /**
     * Obtiene gastos de un mes específico
     */
    public List<Gasto> obtenerGastosPorMes(int año, int mes) {
        return gastos.stream()
                .filter(g -> g.getFecha().getYear() == año && g.getFecha().getMonthValue() == mes)
                .sorted(Comparator.comparing(Gasto::getFecha).reversed())
                .toList();
    }

    /**
     * Verifica si existe un gasto con el ID dado
     */
    public boolean existeGasto(Integer id) {
        return gastos.stream().anyMatch(g -> g.getId().equals(id));
    }

    /**
     * Obtiene el total de gastos
     */
    public Double obtenerTotalGastos() {
        return gastos.stream()
                .mapToDouble(Gasto::getMonto)
                .sum();
    }

    /**
     * Limpia todos los gastos
     */
    public void limpiarGastos() {
        gastos.clear();
        contadorIds = 0;
    }

    /**
     * Obtiene la cantidad de gastos
     */
    public int obtenerCantidadGastos() {
        return gastos.size();
    }
}
