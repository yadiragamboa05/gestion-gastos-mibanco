# 📊 Resumen del Proyecto: Gestión de Gastos Mibanco

## 📋 Resumen Ejecutivo

Se ha implementado exitosamente una **aplicación de gestión de gastos** desarrollada en **Java 11 + Maven**, siguiendo patrones de arquitectura profesional.

### ✅ Estado del Proyecto: **COMPLETADO**

| Aspecto | Estado |
|--------|--------|
| Funcionalidades Básicas | ✅ Completo |
| Implementación Técnica | ✅ Completo |
| Pruebas Unitarias | ✅ Completo (27 tests) |
| Documentación | ✅ Completo |
| CI/CD (GitHub Actions) | ✅ Configurado |

---

## 🎯 Funcionalidades Implementadas

**Principales:**
- ✅ Agregar, listar, filtrar, actualizar y eliminar gastos
- ✅ Estadísticas (total, promedio, máximo, mínimo)
- ✅ Persistencia en JSON

**Técnicas:**
- ✅ Java Puro + Maven
- ✅ Arquitectura de 3 capas
- ✅ JUnit 5 para pruebas
- ✅ GitHub Actions para CI/CD

---

## 📚 Documentación Disponible

| Documento | Propósito |
|-----------|----------|
| [README.md](README.md) | **Documentación principal** - Características, instalación, uso, ejemplos |
| [QUICKSTART.md](QUICKSTART.md) | **Inicio rápido** - 5 minutos para empezar |
| [DEVELOPMENT.md](DEVELOPMENT.md) | **Desarrollo** - Estructura del código, errores, persistencia, testing |
| [INSTALLING_MAVEN.md](INSTALLING_MAVEN.md) | **Instalación Maven** - Pasos específicos para Windows |

---

## ⚡ Inicio Rápido

**1. Clonar y compilar:**
```bash
git clone https://github.com/tu-usuario/gestion-gastos-mibanco.git
cd gestion-gastos-mibanco
mvn clean compile
```

**2. Ejecutar:**
```bash
mvn exec:java "-Dexec.mainClass=com.mibanco.gestiongastos.principal.Principal"
```

> Para una guía completa, ver [QUICKSTART.md](QUICKSTART.md)

---

## 🔗 Enlaces Rápidos

- **Usuarios finales:** [QUICKSTART.md](QUICKSTART.md)
- **Referencia completa:** [README.md](README.md)

---

**Última actualización:** Marzo 2026

| Componente | Tecnología | Versión |
|-----------|-----------|---------|
| **Lenguaje** | Java | 11+ |
| **Build Tool** | Apache Maven | 3.6.0+ |
| **Testing** | JUnit 5 | 5.9.2 |
| **Serialización** | Google Gson | 2.10.1 |
| **CI/CD** | GitHub Actions | Latest |
| **Control de Versiones** | Git | Latest |

---

## 🚀 Cómo Empezar

### Requisitos Previos
- Java 11 o superior
- Maven 3.6.0 o superior

### Instalación Rápida (3 pasos)

```bash
# 1. Navega al directorio del proyecto
cd gestion-gastos-mibanco

# 2. Compila el proyecto
mvn clean compile

# 3. Ejecuta la aplicación
mvn exec:java "-Dexec.mainClass=com.mibanco.gestiongastos.principal.Principal"
```

### Comandos Útiles

```bash
# Compilar
mvn clean compile

# Ejecutar pruebas
mvn test

# Empaquetar
mvn clean package

# Ejecutar una prueba específica
mvn test -Dtest=GastoManagerTest
```

---

## 🏗️ Arquitectura

### Patrón Utilizado: Arquitectura por Capas

```
┌────────────────────────────────────────────────┐
│         CAPA DE PRESENTACIÓN                   │
│   Principal.java | MenuPrincipal.java          │
├────────────────────────────────────────────────┤
│         CAPA DE NEGOCIO                        │
│   GastoManager.java | GastosCalculos.java      │
├────────────────────────────────────────────────┤
│         CAPA DE DATOS                          │
│   Gasto.java | GeneradorDeArchivos.java        │
└────────────────────────────────────────────────┘
```

### Patrones de Diseño

- **MVC (Model-View-Controller)**: Separación de responsabilidades
- **Singleton**: Gestión de estado único
- **Adapter**: Conversión JSON/Java
- **Repository**: Abstracción de persistencia
- **Facade**: Simplificación de operaciones complejas

---

## 📝 Persistencia de Datos

Los gastos se guardan automáticamente en formato JSON:

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

---

## ✅ Pruebas Unitarias

### GastoManagerTest (12 tests)
- ✅ testAgregarGasto
- ✅ testAgregarGastoConMontoNegativo
- ✅ testAgregarGastoConTituloVacio
- ✅ testObtenerGastoPorId
- ✅ testActualizarGasto
- ✅ testEliminarGasto
- ✅ testObtenerTodosLosGastos
- ✅ testObtenerTotalGastos
- ✅ testObtenerGastosPorMes
- ✅ testExisteGasto
- ✅ testLimpiarGastos

### GastosCalculosTest (8 tests)
- ✅ testCalcularTotalGastos
- ✅ testCalcularTotalGastosPorMes
- ✅ testCalcularPromedioGastos
- ✅ testObtenerGastoMasAlto
- ✅ testObtenerGastoMasBajo
- ✅ testFiltrarPorMes
- ✅ testFiltrarPorRangoDeFechas
- ✅ testFiltrarPorMotivo

### GastoTest (7 tests)
- ✅ testCrearGasto
- ✅ testModificarGasto
- ✅ testEqualsGasto
- ✅ testHashCodeGasto
- ✅ testToStringGasto

**Total: 27 pruebas unitarias**

---

## 🔄 Automatización con GitHub Actions

El proyecto incluye un workflow de CI/CD que:
- ✅ Compila el código automáticamente
- ✅ Ejecuta todas las pruebas unitarias
- ✅ Empaqueta la aplicación
- ✅ Prueba múltiples versiones de Java (11, 17)
- ✅ Genera reportes de construcción
- ✅ Sube artefactos compilados

**Archivo**: `.github/workflows/maven.yml`

---
