package com.mibanco.gestiongastos.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mibanco.gestiongastos.modelos.Gasto;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para manejar la persistencia de gastos en archivos
 */
public class GeneradorDeArchivos {
    private static final String ARCHIVO_GASTOS = "gastos.json";
    private final Gson gson;

    public GeneradorDeArchivos() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
    }

    /**
     * Guarda los gastos en un archivo JSON
     */
    public void guardarGastos(List<Gasto> gastos) {
        try {
            String json = gson.toJson(gastos);
            Files.write(Paths.get(ARCHIVO_GASTOS), json.getBytes());
            System.out.println("Gastos guardados exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar los gastos: " + e.getMessage());
        }
    }

    /**
     * Carga los gastos desde el archivo JSON
     */
    public List<Gasto> cargarGastos() {
        try {
            if (Files.exists(Paths.get(ARCHIVO_GASTOS))) {
                String contenido = new String(Files.readAllBytes(Paths.get(ARCHIVO_GASTOS)));
                if (!contenido.isEmpty()) {
                    Gasto[] gastosArray = gson.fromJson(contenido, Gasto[].class);
                    return new ArrayList<>(List.of(gastosArray));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los gastos: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    /**
     * Verifica si el archivo de gastos existe
     */
    public boolean existeArchivoGastos() {
        return Files.exists(Paths.get(ARCHIVO_GASTOS));
    }

    /**
     * Elimina el archivo de gastos
     */
    public void eliminarArchivoGastos() {
        try {
            Files.deleteIfExists(Paths.get(ARCHIVO_GASTOS));
        } catch (IOException e) {
            System.out.println("Error al eliminar el archivo de gastos: " + e.getMessage());
        }
    }
}
