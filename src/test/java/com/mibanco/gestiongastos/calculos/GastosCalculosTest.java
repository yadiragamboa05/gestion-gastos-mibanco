package com.mibanco.gestiongastos.calculos;

import com.mibanco.gestiongastos.modelos.Gasto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GastosCalculosTest {
    private List<Gasto> gastos;

    @BeforeEach
    void setUp() {
        gastos = new ArrayList<>();
        gastos.add(new Gasto(1, "Comida", "Almuerzo", LocalDate.of(2024, 3, 15), 50.0));
        gastos.add(new Gasto(2, "Transporte", "Uber", LocalDate.of(2024, 3, 20), 20.0));
        gastos.add(new Gasto(3, "Entretenimiento", "Cine", LocalDate.of(2024, 3, 25), 30.0));
    }

    @Test
    void testCalcularTotalGastos() {
        Double total = GastosCalculos.calcularTotalGastos(gastos);
        assertEquals(100.0, total);
    }

    @Test
    void testCalcularTotalGastosPorMes() {
        Double total = GastosCalculos.calcularTotalPorMes(gastos, 2024, 3);
        assertEquals(100.0, total);
    }

    @Test
    void testCalcularTotalGastosPorMesVacio() {
        Double total = GastosCalculos.calcularTotalPorMes(gastos, 2025, 1);
        assertEquals(0.0, total);
    }

    @Test
    void testCalcularPromedioGastos() {
        Double promedio = GastosCalculos.calcularPromedioGastos(gastos);
        assertEquals(100.0 / 3, promedio, 0.01);
    }

    @Test
    void testCalcularPromedioGastosVacio() {
        List<Gasto> vacio = new ArrayList<>();
        Double promedio = GastosCalculos.calcularPromedioGastos(vacio);
        assertEquals(0.0, promedio);
    }

    @Test
    void testObtenerGastoMasAlto() {
        Gasto masAlto = GastosCalculos.obtenerGastoMasAlto(gastos);
        assertEquals(50.0, masAlto.getMonto());
        assertEquals("Comida", masAlto.getTitulo());
    }

    @Test
    void testObtenerGastoMasBajo() {
        Gasto masBajo = GastosCalculos.obtenerGastoMasBajo(gastos);
        assertEquals(20.0, masBajo.getMonto());
        assertEquals("Transporte", masBajo.getTitulo());
    }

    @Test
    void testFiltrarPorMes() {
        List<Gasto> filtrados = GastosCalculos.filtrarPorMes(gastos, 2024, 3);
        assertEquals(3, filtrados.size());
    }

    @Test
    void testFiltrarPorRangoDeFechas() {
        LocalDate inicio = LocalDate.of(2024, 3, 15);
        LocalDate fin = LocalDate.of(2024, 3, 25);
        List<Gasto> filtrados = GastosCalculos.filtrarPorRangoDeFechas(gastos, inicio, fin);
        
        assertTrue(filtrados.size() >= 2);
    }

    @Test
    void testFiltrarPorMotivo() {
        List<Gasto> filtrados = GastosCalculos.filtrarPorMotivo(gastos, "Almuerzo");
        assertEquals(1, filtrados.size());
        assertEquals("Comida", filtrados.get(0).getTitulo());
    }
}
