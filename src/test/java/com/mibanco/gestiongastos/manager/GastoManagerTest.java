package com.mibanco.gestiongastos.manager;

import com.mibanco.gestiongastos.modelos.Gasto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GastoManagerTest {
    private GastoManager gastoManager;

    @BeforeEach
    void setUp() {
        gastoManager = new GastoManager();
    }

    @Test
    void testAgregarGasto() {
        gastoManager.agregarGasto("Comida", "Almuerzo", LocalDate.now(), 50.0);
        assertEquals(1, gastoManager.obtenerCantidadGastos());
    }

    @Test
    void testAgregarGastoConMontoNegativo() {
        assertThrows(IllegalArgumentException.class, () ->
                gastoManager.agregarGasto("Comida", "Almuerzo", LocalDate.now(), -50.0)
        );
    }

    @Test
    void testAgregarGastoConTituloVacio() {
        assertThrows(IllegalArgumentException.class, () ->
                gastoManager.agregarGasto("", "Almuerzo", LocalDate.now(), 50.0)
        );
    }

    @Test
    void testObtenerGastoPorId() {
        gastoManager.agregarGasto("Comida", "Almuerzo", LocalDate.now(), 50.0);
        Gasto gasto = gastoManager.obtenerGastoPorId(1);
        assertNotNull(gasto);
        assertEquals("Comida", gasto.getTitulo());
    }

    @Test
    void testActualizarGasto() {
        gastoManager.agregarGasto("Comida", "Almuerzo", LocalDate.now(), 50.0);
        boolean actualizado = gastoManager.actualizarGasto(1, "Cena", "Cena", LocalDate.now(), 75.0);
        
        assertTrue(actualizado);
        Gasto gasto = gastoManager.obtenerGastoPorId(1);
        assertEquals("Cena", gasto.getTitulo());
        assertEquals(75.0, gasto.getMonto());
    }

    @Test
    void testEliminarGasto() {
        gastoManager.agregarGasto("Comida", "Almuerzo", LocalDate.now(), 50.0);
        boolean eliminado = gastoManager.eliminarGasto(1);
        
        assertTrue(eliminado);
        assertEquals(0, gastoManager.obtenerCantidadGastos());
    }

    @Test
    void testObtenerTodosLosGastos() {
        gastoManager.agregarGasto("Comida", "Almuerzo", LocalDate.now(), 50.0);
        gastoManager.agregarGasto("Transporte", "Uber", LocalDate.now(), 20.0);
        
        assertEquals(2, gastoManager.obtenerTodosLosGastos().size());
    }

    @Test
    void testObtenerTotalGastos() {
        gastoManager.agregarGasto("Comida", "Almuerzo", LocalDate.now(), 50.0);
        gastoManager.agregarGasto("Transporte", "Uber", LocalDate.now(), 20.0);
        
        assertEquals(70.0, gastoManager.obtenerTotalGastos());
    }

    @Test
    void testObtenerGastosPorMes() {
        LocalDate fecha = LocalDate.of(2024, 3, 15);
        gastoManager.agregarGasto("Comida", "Almuerzo", fecha, 50.0);
        gastoManager.agregarGasto("Transporte", "Uber", LocalDate.now(), 20.0);
        
        var gastosMes = gastoManager.obtenerGastosPorMes(2024, 3);
        assertEquals(1, gastosMes.size());
    }

    @Test
    void testExisteGasto() {
        gastoManager.agregarGasto("Comida", "Almuerzo", LocalDate.now(), 50.0);
        
        assertTrue(gastoManager.existeGasto(1));
        assertFalse(gastoManager.existeGasto(999));
    }

    @Test
    void testLimpiarGastos() {
        gastoManager.agregarGasto("Comida", "Almuerzo", LocalDate.now(), 50.0);
        gastoManager.agregarGasto("Transporte", "Uber", LocalDate.now(), 20.0);
        
        gastoManager.limpiarGastos();
        assertEquals(0, gastoManager.obtenerCantidadGastos());
    }
}
