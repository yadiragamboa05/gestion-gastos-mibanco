# Quick Start Guide - Início Rápido

## Versión en Español

### Prerequisitos
- Java 11 o superior
- Maven 3.6 o superior
- Git (opcional, para clonar)

### Configuración Rápida (5 minutos)

1. **Navega al directorio del proyecto:**
   ```bash
   cd gestion-gastos-mibanco
   ```

2. **Compila el proyecto:**
   ```bash
   mvn clean compile
   ```

3. **Ejecuta las pruebas:**
   ```bash
   mvn test
   ```

4. **Empaqueta la aplicación:**
   ```bash
   mvn clean package
   ```

5. **Ejecuta la aplicación:**
   ```bash
   # Opción: Usando Maven
   mvn exec:java "-Dexec.mainClass=com.mibanco.gestiongastos.principal.Principal"

   ```

### Primeros Pasos en la Aplicación

Una vez que la aplicación inicia:

1. **Agregar un gasto:**
   - Selecciona opción 1
   - Ingresa: Título → Motivo → Fecha (dd/MM/yyyy) → Monto

2. **Ver todos los gastos:**
   - Selecciona opción 2
   - Ve todos los gastos registrados

3. **Filtrar por mes:**
   - Selecciona opción 3
   - Ingresa año y mes

4. **Ver estadísticas:**
   - Selecciona opción 6
   - Ve el total, promedio, máximo y mínimo de gastos

### Ejemplo de Uso

```
===================================================
      GESTOR DE GASTOS - MIBANCO
===================================================
1. Agregar nuevo gasto
2. Listar todos los gastos
3. Listar gastos por mes
4. Actualizar gasto
5. Eliminar gasto
6. Ver estadísticas
7. Guardar gastos
8. Salir
===================================================
Seleccione una opción: 1

--- AGREGAR NUEVO GASTO ---
Ingrese el título del gasto: Almuerzo
Ingrese el motivo del gasto: Restaurante
Ingrese la fecha (dd/MM/yyyy): 15/03/2024
Ingrese el monto: 45.50
✓ Gasto agregado exitosamente.
```

---

Para más información, consulta el README.md
