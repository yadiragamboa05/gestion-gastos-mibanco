package com.mibanco.gestiongastos.modelos;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GastoTest {

    @Test
    void testCrearGasto() {
        LocalDate fecha = LocalDate.of(2024, 3, 15);
        Gasto gasto = new Gasto(1, "Comida", "Almuerzo", fecha, 50.0);

        assertEquals(1, gasto.getId());
        assertEquals("Comida", gasto.getTitulo());
        assertEquals("Almuerzo", gasto.getMotivo());
        assertEquals(fecha, gasto.getFecha());
        assertEquals(50.0, gasto.getMonto());
    }

    @Test
    void testModificarGasto() {
        Gasto gasto = new Gasto(1, "Comida", "Almuerzo", LocalDate.of(2024, 3, 15), 50.0);

        gasto.setTitulo("Cena");
        gasto.setMonto(75.0);

        assertEquals("Cena", gasto.getTitulo());
        assertEquals(75.0, gasto.getMonto());
    }

    @Test
    void testEqualsGasto() {
        Gasto gasto1 = new Gasto(1, "Comida", "Almuerzo", LocalDate.of(2024, 3, 15), 50.0);
        Gasto gasto2 = new Gasto(1, "Cena", "Cena", LocalDate.of(2024, 3, 16), 75.0);

        assertEquals(gasto1, gasto2); // Iguales porque tienen el mismo ID
    }

    @Test
    void testHashCodeGasto() {
        Gasto gasto1 = new Gasto(1, "Comida", "Almuerzo", LocalDate.of(2024, 3, 15), 50.0);
        Gasto gasto2 = new Gasto(1, "Comida", "Almuerzo", LocalDate.of(2024, 3, 15), 50.0);

        assertEquals(gasto1.hashCode(), gasto2.hashCode());
    }

    @Test
    void testToStringGasto() {
        Gasto gasto = new Gasto(1, "Comida", "Almuerzo", LocalDate.of(2024, 3, 15), 50.0);
        String str = gasto.toString();

        assertTrue(str.contains("ID: 1"));
        assertTrue(str.contains("Comida"));
        assertTrue(str.contains("Almuerzo"));
        assertTrue(str.contains("50.00"));
    }
}
