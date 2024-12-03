# Conversor de Monedas

Este es un proyecto llamado **Conversor de Monedas**, desarrollado en Java, que permite realizar conversiones entre una amplia variedad de monedas utilizando tasas de cambio proporcionadas por la API externa gratuita de **ExchangeRate-API**.

Inicialmente, el proyecto se limitaba a unas pocas conversiones, pero ahora la cobertura se ha ampliado para incluir todas las monedas disponibles a través de la API, lo que permite realizar conversiones entre cualquier par de monedas soportadas.

## Características

- **Conversión de monedas ilimitadas**: El proyecto ahora permite convertir entre cualquier par de monedas disponibles en la API gratuita de ExchangeRate-API.
- **API externa**: El proyecto se conecta a la API de **ExchangeRate-API** para obtener tasas de cambio dinámicas y actualizadas en tiempo real.
- **Uso de Gson 2.11.0** para manejar datos JSON de la API.

## Requisitos

- **IntelliJ IDEA** (para desarrollo en Java).
- **OpenJDK 22.0.1** o superior.
- **Gson 2.11.0.jar** para el manejo de JSON.
- **API Key de ExchangeRate-API**: Debes registrarte en [https://www.exchangerate-api.com](https://www.exchangerate-api.com) para obtener una clave API gratuita.
- (Opcional) Servidor local como XAMPP, WAMP, o LAMP si deseas usar la versión web del proyecto en un servidor.

## Instalación

Para ejecutar el proyecto localmente, sigue estos pasos:

1. Clona este repositorio o descarga los archivos.
2. Abre el proyecto en **IntelliJ IDEA**.
3. Asegúrate de tener **OpenJDK 22.0.1** o superior instalado.
4. Incluye **Gson 2.11.0.jar** en el classpath de tu proyecto (si usas IntelliJ IDEA, puedes agregar el archivo `.jar` a las bibliotecas del proyecto a través de la configuración de dependencias).
5. Regístrate en **[ExchangeRate-API](https://www.exchangerate-api.com)** para obtener una clave API gratuita.
6. Inserta tu clave API en el archivo `CurrencyAPI.java` o el archivo correspondiente donde se gestionan las conexiones a la API externa.
7. Configura el endpoint de la API en el código para hacer la solicitud a la API de ExchangeRate-API (utiliza la clave API para autenticar la solicitud).
8. Si estás trabajando con una aplicación web, coloca los archivos en la carpeta de tu servidor web (por ejemplo, `htdocs` si estás utilizando XAMPP).
9. Abre el archivo principal (por ejemplo, `Main.java` o `index.html`) y ejecútalo en IntelliJ.

## Uso

1. Ingresa la cantidad de dinero que deseas convertir.
2. Selecciona la moneda de origen y la moneda de destino desde el formulario o la interfaz de usuario.
3. Haz clic en "Convertir" y obtendrás el resultado de la conversión en la moneda seleccionada.
4. La conversión se realiza utilizando las tasas de cambio actualizadas proporcionadas por la API de **ExchangeRate-API**.

## Estructura del Proyecto

El proyecto tiene la siguiente estructura:

- **src/**: Carpeta con los archivos de código fuente Java (si aplica).
  - **Main.java**: Archivo principal para manejar la lógica de conversión de monedas.
  - **CurrencyConverter.java**: Clase encargada de realizar la conversión entre monedas.
  - **CurrencyAPI.java**: Clase para integrar con la API externa de **ExchangeRate-API** y obtener tasas de cambio dinámicas.
- **lib/**: Carpeta donde se encuentra el archivo **gson-2.11.0.jar**.
- **index.html** o **index.php**: Página principal que contiene el formulario y la lógica de conversión (si es una aplicación web).
- **style.css**: Archivo de estilos para darle formato a la interfaz.
- **script.js**: Archivo para manejar la lógica de conversión y otras interacciones (si aplica).
- **README.md**: Este archivo con la documentación del proyecto.

## Contribuciones

Si deseas colaborar con este proyecto, puedes hacer un fork, realizar los cambios que desees y luego enviar un pull request para revisión. Algunas ideas de contribución pueden ser:

- Mejoras en la interfaz de usuario.
- Adición de más funcionalidades o características, como la capacidad de guardar las conversiones más frecuentes.
- Optimización del código para mayor rendimiento o mejor manejo de errores.
