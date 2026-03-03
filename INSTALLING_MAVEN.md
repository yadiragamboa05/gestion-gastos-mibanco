# Instalación de Maven en Windows

## Opción 1: Descarga Manual (Recomendado para desarrollo local)

### Paso 1: Descargar Maven
1. Ve a https://maven.apache.org/download.cgi
2. Descarga el archivo `apache-maven-3.9.x-bin.zip` (última versión estable)
3. Extrae el archivo en una carpeta, ej: `C:\apache-maven-3.9.x`

### Paso 2: Configurar Variables de Entorno

1. **Abre Variables de Entorno:**
   - Presiona `Win + X` y selecciona "Sistema"
   - Haz clic en "Configuración avanzada del sistema"
   - Haz clic en "Variables de entorno"

2. **Agrega la variable M2_HOME:**
   - Click en "Nueva" (en Variables de usuario o de sistema)
   - Variable: `M2_HOME`
   - Valor: `C:\apache-maven-3.9.x` (ruta donde extrajiste Maven)

3. **Modifica la variable PATH:**
   - Busca `Path` en las variables
   - Haz clic en "Editar"
   - Agrega: `%M2_HOME%\bin`

4. **Verifica la instalación:**
   - Abre una nueva terminal
   - Escribe: `mvn --version`
   - Deberías ver algo como:
     ```
     Apache Maven 3.9.x
     Java version: 11.0.x
     ```

## Opción 2: Instalación con Chocolatey (Si tienes Chocolatey)

```powershell
# Como administrador
choco install maven
```

Luego verifica:
```powershell
mvn --version
```

## Opción 3: Instalación con Scoop

```powershell
scoop install maven
mvn --version
```

## Después de Instalar Maven

Una vez instalado Maven, puedes compilar el proyecto:

```bash
cd "d:\0.Prácticas\Mibanco\gestion-gastos-mibanco"

# Compilar
mvn clean compile

# Ejecutar pruebas
mvn test

# Empaquetar
mvn clean package

# Ejecutar la aplicación
mvn exec:java "-Dexec.mainClass=com.mibanco.gestiongastos.principal.Principal"
```

## Troubleshooting

### Error: "mvn is not recognized"
- Verifica que Maven está en el PATH
- Reinicia la terminal después de cambiar variables de entorno
- Verifica la ruta en M2_HOME

### Error: "Java is not recognized"
- Instala Java 11 o superior
- Configura JAVA_HOME apuntando a tu instalación de Java

### Error: "No se puede ejecutar scripts"
- Si vas a usar scripts .bat, asegúrate de permitir su ejecución en Windows

---

Una vez termines estas instrucciones, podrás compilar y ejecutar el proyecto.
