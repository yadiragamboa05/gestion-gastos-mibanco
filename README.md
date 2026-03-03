# Gestión de Gastos Mibanco

Una aplicación de consola desarrollada en **Java puro** con **Maven** para gestionar y controlar gastos personales.

## Características

✅ **Funcionalidades Principales:**
- Agregar nuevos gastos con título, motivo, fecha y monto
- Listar todos los gastos registrados
- Filtrar gastos por mes específico
- Actualizar información de gastos existentes
- Eliminar gastos
- Ver estadísticas de gastos (total, promedio, máximo, mínimo)

✅ **Características Adicionales:**
- Persistencia de datos en archivos JSON
- Carga automática de gastos al iniciar la aplicación
- Validación de datos de entrada
- Manejo robusto de errores
- Interfaz de consola intuitiva y user-friendly
- Pruebas unitarias compresivas (JUnit 5)
- Automatización con GitHub Actions (CI/CD)

## Requisitos Previos

- Java 11 o superior
- Maven 3.6 o superior

## Estructura del Proyecto

```
gestion-gastos-mibanco/
├── pom.xml                                    # Configuración de Maven
├── README.md                                  # Este archivo
├── .gitignore                                 # Archivos a ignorar en Git
├── .github/
│   └── workflows/
│       └── maven.yml                          # Configuración de GitHub Actions
├── src/
│   ├── main/java/com/mibanco/gestiongastos/
│   │   ├── calculos/
│   │   │   └── GastosCalculos.java           # Cálculos y análisis de gastos
│   │   ├── manager/
│   │   │   └── GastoManager.java             # Gestión de gastos en memoria
│   │   ├── modelos/
│   │   │   └── Gasto.java                    # Modelo de datos para Gasto
│   │   ├── principal/
│   │   │   ├── MenuPrincipal.java            # Menús de la aplicación
│   │   │   └── Principal.java                # Punto de entrada de la aplicación
│   │   └── utils/
│   │       ├── GeneradorDeArchivos.java      # Persistencia en archivos
│   │       └── LocalDateAdapter.java         # Adaptador para serialización JSON
│   └── test/java/com/mibanco/gestiongastos/
│       ├── calculos/
│       │   └── GastosCalculosTest.java
│       ├── manager/
│       │   └── GastoManagerTest.java
│       └── modelos/
│           └── GastoTest.java
└── gastos.json                                # Archivo de almacenamiento de gastos
```

## Instalación y Configuración

### 1. Clonar el repositorio
```bash
git clone https://github.com/tu-usuario/gestion-gastos-mibanco.git
cd gestion-gastos-mibanco
```

### 2. Compilar el proyecto
```bash
mvn clean compile
```

### 3. Ejecutar las pruebas
```bash
mvn test
```

### 4. Empaquetar la aplicación
```bash
mvn clean package
```

## Uso

### Ejecutar la aplicación desde Maven:
```bash
mvn exec:java "-Dexec.mainClass=com.mibanco.gestiongastos.principal.Principal"
```

## Menú Principal

Al ejecutar la aplicación, se presentará el siguiente menú:

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
```

## Ejemplos de Uso

### Agregar un gasto:
```
Ingrese el título del gasto: Almuerzo
Ingrese el motivo del gasto: Comida en restaurante
Ingrese la fecha (dd/MM/yyyy): 2024-03-15
Ingrese el monto: 45.50
```

### Filtrar gastos por mes:
```
Ingrese el año (yyyy): 2024
Ingrese el mes (1-12): 3
```

### Ver estadísticas:
- Total de gastos
- Promedio de gastos
- Gasto más alto
- Gasto más bajo

## Formato de Almacenamiento

Los gastos se guardan automáticamente en formato JSON (`gastos.json`):

```json
[
  {
    "id": 1,
    "titulo": "Almuerzo",
    "motivo": "Comida en restaurante",
    "fecha": "2024-03-15",
    "monto": 45.50
  },
  {
    "id": 2,
    "titulo": "Transporte",
    "motivo": "Uber a casa",
    "fecha": "2024-03-15",
    "monto": 15.00
  }
]
```

## Pruebas Unitarias

El proyecto incluye pruebas unitarias compresivas usando **JUnit 5**:

- **GastoManagerTest**: Pruebas de la lógica de gestión de gastos 
- **GastosCalculosTest**: Pruebas de cálculos y análisis 
- **GastoTest**: Pruebas del modelo de datos

Para ejecutar las pruebas:
```bash
mvn test
```

## Automatización y CI/CD

El proyecto incluye configuración de **GitHub Actions** para:
- ✅ Compilar el código automáticamente
- ✅ Ejecutar todas las pruebas unitarias
- ✅ Empaquetar la aplicación
- ✅ Generar reportes de construcción

El workflow se ejecuta automáticamente en cada push y pull request.

## Dependencias

- **JUnit 5.9.2** - Framework de pruebas unitarias
- **Google Gson 2.10.1** - Serialización/Deserialización JSON
- **Maven 3.6.0+** - Herramienta de construcción
- **Java 11+** - Lenguaje de programación

## Autor
- GitHub: [@yadiragamboa05](https://github.com/yadiragamboa05)
- Email: yadiragamboaq.05@gmail.com


**Última actualización**: Marzo 2026

