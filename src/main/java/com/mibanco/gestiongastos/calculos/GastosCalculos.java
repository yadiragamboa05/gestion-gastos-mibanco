package com.mibanco.gestiongastos.calculos;

import com.mibanco.gestiongastos.modelos.Gasto;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase para realizar cálculos y análisis sobre los gastos
 */
public class GastosCalculos {

    /**
     * Calcula el total de gastos
     */
    public static Double calcularTotalGastos(List<Gasto> gastos) {
        return gastos.stream()
                .mapToDouble(Gasto::getMonto)
                .sum();
    }

    /**
     * Calcula el total de gastos en un mes específico
     */
    public static Double calcularTotalPorMes(List<Gasto> gastos, int anio, int mes) {
        return gastos.stream()
                .filter(g -> g.getFecha().getYear() == anio && g.getFecha().getMonthValue() == mes)
                .mapToDouble(Gasto::getMonto)
                .sum();
    }

    /**
     * Obtiene el gasto promedio
     */
    public static Double calcularPromedioGastos(List<Gasto> gastos) {
        if (gastos.isEmpty()) {
            return 0.0;
        }
        return calcularTotalGastos(gastos) / gastos.size();
    }

    /**
     * Obtiene el gasto más alto
     */
    public static Gasto obtenerGastoMasAlto(List<Gasto> gastos) {
        return gastos.stream()
                .max(Comparator.comparingDouble(Gasto::getMonto))
                .orElse(null);
    }

    /**
     * Obtiene el gasto más bajo
     */
    public static Gasto obtenerGastoMasBajo(List<Gasto> gastos) {
        return gastos.stream()
                .min(Comparator.comparingDouble(Gasto::getMonto))
                .orElse(null);
    }

    /**
     * Filtra gastos por mes y año
     */
    public static List<Gasto> filtrarPorMes(List<Gasto> gastos, int anio, int mes) {
        return gastos.stream()
                .filter(g -> g.getFecha().getYear() == anio && g.getFecha().getMonthValue() == mes)
                .sorted(Comparator.comparing(Gasto::getFecha).reversed())
                .collect(Collectors.toList());
    }

    /**
     * Filtra gastos por rango de fechas
     */
    public static List<Gasto> filtrarPorRangoDeFechas(List<Gasto> gastos, LocalDate fechaInicio, LocalDate fechaFin) {
        return gastos.stream()
                .filter(g -> !g.getFecha().isBefore(fechaInicio) && !g.getFecha().isAfter(fechaFin))
                .sorted(Comparator.comparing(Gasto::getFecha).reversed())
                .collect(Collectors.toList());
    }

    /**
     * Filtra gastos por motivo
     */
    public static List<Gasto> filtrarPorMotivo(List<Gasto> gastos, String motivo) {
        return gastos.stream()
                .filter(g -> g.getMotivo().toLowerCase().contains(motivo.toLowerCase()))
                .collect(Collectors.toList());
    }
}
