package com.mibanco.gestiongastos.principal;

/**
 * Clase para mostrar el menú principal de la aplicación
 */
public class MenuPrincipal {

    public static void mostrarMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("      GESTOR DE GASTOS - MIBANCO");
        System.out.println("=".repeat(50));
        System.out.println("1. Agregar nuevo gasto");
        System.out.println("2. Listar todos los gastos");
        System.out.println("3. Listar gastos por mes");
        System.out.println("4. Actualizar gasto");
        System.out.println("5. Eliminar gasto");
        System.out.println("6. Ver estadísticas");
        System.out.println("7. Guardar gastos");
        System.out.println("8. Salir");
        System.out.println("=".repeat(50));
        System.out.print("Seleccione una opción: ");
    }

    public static void mostrarEstadisticas() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("      ESTADÍSTICAS DE GASTOS");
        System.out.println("=".repeat(50));
        System.out.println("1. Total de gastos");
        System.out.println("2. Promedio de gastos");
        System.out.println("3. Gasto más alto");
        System.out.println("4. Gasto más bajo");
        System.out.println("5. Volver al menú principal");
        System.out.println("=".repeat(50));
        System.out.print("Seleccione una opción: ");
    }
}
