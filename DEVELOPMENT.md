# Guía de Desarrollo

> **Nota:** Para instrucciones de instalación y configuración básica, ver [QUICKSTART.md](QUICKSTART.md) y [README.md](README.md).

## Requisitos de Desarrollo

- Java 11 o superior
- Maven 3.6 o superior
- Git
- IDE recomendado: IntelliJ IDEA o Eclipse
- Conocimiento básico de Git y Maven

## Estructura del Código

### Paquetes:
- **modelos**: Clases de datos (Gasto)
- **manager**: Lógica de gestión de gastos
- **calculos**: Cálculos y análisis de datos
- **utils**: Utilidades y persistencia
- **principal**: Punto de entrada y menús

### Flujo de Datos:
```
Principal (entrada)
    ↓
MenuPrincipal (interfaz)
    ↓
GastoManager (lógica)
    ↓
Gasto (datos)
    ↓
GeneradorDeArchivos (persistencia)
```

## Funcionalidades Principales

### 1. Agregar Gasto
```
Principal → agregarGasto() → GastoManager.agregarGasto()
    → Gasto creado → GeneradorDeArchivos.guardarGastos()
```

### 2. Listar Gastos
```
Principal → listarGastos() → GastoManager.obtenerTodosLosGastos()
    → Lista gastos
```

### 3. Filtrar por Mes
```
Principal → listarGastosPorMes() → GastoManager.obtenerGastosPorMes()
    → Gastos filtrados por mes
```

### 4. Actualizar Gasto
```
Principal → actualizarGasto() → GastoManager.actualizarGasto()
    → Gasto actualizado
```

### 5. Eliminar Gasto
```
Principal → eliminarGasto() → GastoManager.eliminarGasto()
    → Gasto eliminado
```

### 6. Estadísticas
```
Principal → mostrarEstadisticas() → GastosCalculos
    → Cálculos: total, promedio, máximo, mínimo
```

## Manejo de Errores

La aplicación usa:
- **IllegalArgumentException**: Para validaciones de entrada
- **InputMismatchException**: Para datos del tipo incorrecto
- **IOException**: Para problemas con archivos
- **Exception**: Para errores genéricos

**Patrón estándar:**
```java
try {
    // Operación que puede fallar
} catch (IllegalArgumentException e) {
    System.out.println("Error de validación: " + e.getMessage());
} catch (IOException e) {
    System.out.println("Error de archivo: " + e.getMessage());
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
}
```

## Persistencia de Datos

Ver [GeneradorDeArchivos.java](src/main/java/com/mibanco/gestiongastos/utils/GeneradorDeArchivos.java) para implementación.

Formato JSON en `gastos.json`:
```json
[
  {
    "id": 1,
    "titulo": "Almuerzo",
    "motivo": "Restaurante",
    "fecha": "2024-03-15",
    "monto": 45.50
  }
]
```

## Pruebas Unitarias

Ejecutar todas las pruebas:
```bash
mvn test
```

Ejecutar prueba específica:
```bash
mvn test -Dtest=GastoManagerTest
```

Ver [Pruebas](#pruebas-unitarias) en README.md para más detalles.

## Comandos Maven Comunes

Referencia completa en [README.md](README.md#instalación-y-configuración).

## Recursos de Referencia

- [Java 11 Documentation](https://docs.oracle.com/en/java/javase/11/)
- [Maven Documentation](https://maven.apache.org/)
- [JUnit 5 Documentation](https://junit.org/junit5/)
- [Google Gson Documentation](https://github.com/google/gson)
