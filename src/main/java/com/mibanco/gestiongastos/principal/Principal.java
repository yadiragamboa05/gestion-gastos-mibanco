package com.mibanco.gestiongastos.principal;

import com.mibanco.gestiongastos.calculos.GastosCalculos;
import com.mibanco.gestiongastos.manager.GastoManager;
import com.mibanco.gestiongastos.modelos.Gasto;
import com.mibanco.gestiongastos.utils.GeneradorDeArchivos;
import com.mibanco.gestiongastos.utils.LocalDateAdapter;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal de la aplicación
 */
public class Principal {
    private static GastoManager gastoManager;
    private static GeneradorDeArchivos generador;
    private static Scanner lectura;

    public static void main(String[] args) {
        lectura = new Scanner(System.in);
        gastoManager = new GastoManager();
        generador = new GeneradorDeArchivos();

        // Cargar gastos al iniciar la aplicación
        cargarGastosPersistidos();

        int opcion = 0;

        System.out.println("\n¡Bienvenido al Gestor de Gastos Mibanco!");

        while (opcion != 8) {
            MenuPrincipal.mostrarMenu();

            try {
                opcion = lectura.nextInt();
                lectura.nextLine();

                switch (opcion) {
                    case 1:
                        agregarGasto();
                        break;
                    case 2:
                        listarTodosLosGastos();
                        break;
                    case 3:
                        listarGastosPorMes();
                        break;
                    case 4:
                        actualizarGasto();
                        break;
                    case 5:
                        eliminarGasto();
                        break;
                    case 6:
                        mostrarEstadisticas();
                        break;
                    case 7:
                        guardarGastosEnArchivo();
                        break;
                    case 8:
                        System.out.println("\n¡Hasta luego! Sus gastos han sido guardados automáticamente.");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese solo números.");
                lectura.nextLine();
                pausarAplicacion();
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                lectura.nextLine();
                pausarAplicacion();
            }
        }

        // Guardar gastos antes de salir
        guardarGastosEnArchivo();
        lectura.close();
    }

    private static void agregarGasto() {
        try {
            System.out.println("\n--- AGREGAR NUEVO GASTO ---");

            System.out.print("Ingrese el título del gasto: ");
            String titulo = lectura.nextLine();

            System.out.print("Ingrese el motivo del gasto: ");
            String motivo = lectura.nextLine();

            System.out.print("Ingrese la fecha (dd/MM/yyyy): ");
            String fechaStr = lectura.nextLine();
            LocalDate fecha = LocalDate.parse(fechaStr, LocalDateAdapter.formatter);

            System.out.print("Ingrese el monto: ");
            Double monto = lectura.nextDouble();
            lectura.nextLine();

            gastoManager.agregarGasto(titulo, motivo, fecha, monto);
            System.out.println("✓ Gasto agregado exitosamente.");
            pausarAplicacion();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
            pausarAplicacion();
        } catch (Exception e) {
            System.out.println("Error al agregar el gasto: " + e.getMessage());
            pausarAplicacion();
        }
    }

    private static void listarTodosLosGastos() {
        List<Gasto> gastos = gastoManager.obtenerTodosLosGastos();

        if (gastos.isEmpty()) {
            System.out.println("\nNo hay gastos registrados.");
        } else {
            System.out.println("\n--- LISTA DE GASTOS ---");
            System.out.println("Total de gastos: " + gastos.size());
            System.out.println("Total invertido: S/" + String.format("%.2f", GastosCalculos.calcularTotalGastos(gastos)));
            System.out.println("");

            for (Gasto gasto : gastos) {
                System.out.println(gasto);
            }
        }
        pausarAplicacion();
    }

    private static void listarGastosPorMes() {
        try {
            System.out.println("\n--- FILTRAR GASTOS POR MES ---");

            System.out.print("Ingrese el año (yyyy): ");
            int anio = lectura.nextInt();

            System.out.print("Ingrese el mes (1-12): ");
            int mes = lectura.nextInt();
            lectura.nextLine();

            if (mes < 1 || mes > 12) {
                System.out.println("Error: El mes debe estar entre 1 y 12.");
                pausarAplicacion();
                return;
            }

            List<Gasto> gastosMes = gastoManager.obtenerGastosPorMes(anio, mes);

            if (gastosMes.isEmpty()) {
                System.out.println("\nNo hay gastos registrados para " + mes + "/" + anio);
            } else {
                System.out.println("\n--- GASTOS DE " + mes + "/" + anio + " ---");
                System.out.println("Total de gastos: " + gastosMes.size());
                System.out.println("Total del mes: S/" + String.format("%.2f", GastosCalculos.calcularTotalGastos(gastosMes)));
                System.out.println("");

                for (Gasto gasto : gastosMes) {
                    System.out.println(gasto);
                }
            }
            pausarAplicacion();
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, ingrese números válidos.");
            lectura.nextLine();
            pausarAplicacion();
        }
    }

    private static void actualizarGasto() {
        try {
            System.out.println("\n--- ACTUALIZAR GASTO ---");

            listarTodosLosGastos();

            System.out.print("Ingrese el ID del gasto a actualizar: ");
            Integer id = lectura.nextInt();
            lectura.nextLine();

            Gasto gastoExistente = gastoManager.obtenerGastoPorId(id);
            if (gastoExistente == null) {
                System.out.println("Error: No se encontró un gasto con ese ID.");
                pausarAplicacion();
                return;
            }

            System.out.println("\nDatos actuales: " + gastoExistente);

            System.out.print("Ingrese el nuevo título: ");
            String titulo = lectura.nextLine();

            System.out.print("Ingrese el nuevo motivo: ");
            String motivo = lectura.nextLine();

            System.out.print("Ingrese la nueva fecha (dd/MM/yyyy): ");
            String fechaStr = lectura.nextLine();
            LocalDate fecha = LocalDate.parse(fechaStr, LocalDateAdapter.formatter);

            System.out.print("Ingrese el nuevo monto: ");
            Double monto = lectura.nextDouble();
            lectura.nextLine();

            if (gastoManager.actualizarGasto(id, titulo, motivo, fecha, monto)) {
                System.out.println("✓ Gasto actualizado exitosamente.");
            } else {
                System.out.println("Error al actualizar el gasto.");
            }
            pausarAplicacion();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
            pausarAplicacion();
        } catch (Exception e) {
            System.out.println("Error al actualizar el gasto: " + e.getMessage());
            pausarAplicacion();
        }
    }

    private static void eliminarGasto() {
        try {
            System.out.println("\n--- ELIMINAR GASTO ---");

            listarTodosLosGastos();

            System.out.print("Ingrese el ID del gasto a eliminar: ");
            Integer id = lectura.nextInt();
            lectura.nextLine();

            if (gastoManager.existeGasto(id)) {
                System.out.print("¿Está seguro que desea eliminar este gasto? (S/N): ");
                String confirmacion = lectura.nextLine();

                if (confirmacion.equalsIgnoreCase("S")) {
                    if (gastoManager.eliminarGasto(id)) {
                        System.out.println("✓ Gasto eliminado exitosamente.");
                    }
                } else {
                    System.out.println("Operación cancelada.");
                }
            } else {
                System.out.println("Error: No se encontró un gasto con ese ID.");
            }
            pausarAplicacion();
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, ingrese un número válido.");
            lectura.nextLine();
            pausarAplicacion();
        }
    }

    private static void mostrarEstadisticas() {
        List<Gasto> gastos = gastoManager.obtenerTodosLosGastos();

        if (gastos.isEmpty()) {
            System.out.println("\nNo hay gastos para mostrar estadísticas.");
            pausarAplicacion();
            return;
        }

        int opcion = 0;

        while (opcion != 5) {
            MenuPrincipal.mostrarEstadisticas();

            try {
                opcion = lectura.nextInt();
                lectura.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("\nTotal de gastos: S/" + String.format("%.2f", GastosCalculos.calcularTotalGastos(gastos)));
                        pausarAplicacion();
                        break;
                    case 2:
                        System.out.println("\nPromedio de gastos: S/" + String.format("%.2f", GastosCalculos.calcularPromedioGastos(gastos)));
                        pausarAplicacion();
                        break;
                    case 3:
                        Gasto masAlto = GastosCalculos.obtenerGastoMasAlto(gastos);
                        if (masAlto != null) {
                            System.out.println("\nGasto más alto:\n" + masAlto);
                        }
                        pausarAplicacion();
                        break;
                    case 4:
                        Gasto masBajo = GastosCalculos.obtenerGastoMasBajo(gastos);
                        if (masBajo != null) {
                            System.out.println("\nGasto más bajo:\n" + masBajo);
                        }
                        pausarAplicacion();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese solo números.");
                lectura.nextLine();
            }
        }
    }

    private static void guardarGastosEnArchivo() {
        List<Gasto> gastos = gastoManager.obtenerTodosLosGastos();
        generador.guardarGastos(gastos);
    }

    private static void cargarGastosPersistidos() {
        List<Gasto> gastosGuardados = generador.cargarGastos();
        if (!gastosGuardados.isEmpty()) {
            System.out.println("Se cargaron " + gastosGuardados.size() + " gastos guardados anteriormente.");
            for (Gasto gasto : gastosGuardados) {
                gastoManager.agregarGasto(gasto.getTitulo(), gasto.getMotivo(), gasto.getFecha(), gasto.getMonto());
            }
        }
    }

    private static void pausarAplicacion() {
        System.out.println("\nPresione Enter para continuar...");
        lectura.nextLine();
    }
}
