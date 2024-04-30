# Componente visual para selección de códigos postales


## DESCRIPCION
Este código Java define un componente visual llamado CodigoPostalPanel, que es un panel que muestra información de códigos postales. Permite seleccionar un estado, ciudad, municipio, código postal y colonia a partir de datos cargados desde un archivo CSV.


## CARACTERISTICAS:
- Interfaz Gráfica: Utiliza componentes de interfaz gráfica como JComboBox y JLabel para mostrar y seleccionar información.

- Carga de Datos Externos: Lee datos de un archivo CSV para llenar los campos de selección.

- Actualización Dinámica: Los campos de selección se actualizan dinámicamente según las selecciones anteriores.

- Información Seleccionada: Proporciona un método para obtener la información seleccionada en formato de cadena.


## EJEMPLOS DE APLICACIÓN Y USO:
- Aplicaciones de Envío: Puede integrarse en aplicaciones de envío para ayudar a los usuarios a seleccionar códigos postales y direcciones de forma rápida y precisa.
- Sistemas de Logística: Útil en sistemas de logística para seleccionar ubicaciones de entrega basadas en códigos postales.
- Plataformas de E-Commerce (comercio electrónico): Se puede utilizar en plataformas de comercio electrónico para que los usuarios seleccionen direcciones de envío durante el proceso de compra.


## REQUISITOS PARA LA IMPLEMENTACIÓN EN OTROS EQUIPOS Y PROYECTOS:
1.  Java Development Kit (JDK): Es necesario tener instalado JDK para compilar y ejecutar el código.
2. Bibliotecas Externas: El código utiliza bibliotecas estándar de Java, por lo que no requiere bibliotecas externas adicionales.
3. Datos de Códigos Postales: Se necesita un archivo CSV con datos de códigos postales en el formato esperado para que el componente funcione correctamente (en este caso lo proporcionamos nosotros y se encuentra dentro del proyecto).


## API:
- **Clase CodigoPostalPanel:**
La clase principal CodigoPostalPanel es una subclase de JPanel, esta clase define la estructura y funcionalidad del panel visual para seleccionar y mostrar información de los códigos postales de manera interactiva.

- **Librerias usadas:**

| Nombre | Descripción |
|------|-------------|
| `javax.swing` | Esta es una librería estándar de Java que proporciona componentes y herramientas para crear interfaces gráficas de usuario (GUI). En este código, se utilizan clases como JPanel, JLabel y JComboBox para construir la interfaz de usuario del panel de códigos postales. |
| `java.awt.event` | Esta librería también es estándar en Java y contiene clases e interfaces para manejar eventos de entrada, como clics de ratón y pulsaciones de teclas. En este código, se utilizan clases como ActionListener y ActionEvent para manejar eventos de selección en los JComboBox. |
| `java.io.BufferedReader y java.io.FileReader` | Estas clases son parte del paquete java.io y se utilizan para leer datos desde un archivo de texto, en este caso, un archivo CSV que contiene información de códigos postales. |
| `java.io.IOException` |  Esta clase maneja excepciones de entrada/salida que pueden ocurrir al leer el archivo CSV. Se utiliza para manejar posibles errores durante la lectura del archivo. |
| `java.util.ArrayList y java.util.List` |  Estas clases son parte del paquete java.util y se utilizan para almacenar y manipular la lista de información de códigos postales. En este código, se utiliza un ArrayList para almacenar arrays de strings que representan la información de cada código postal. |



- **Metodos:**

| Nombre | Descripción |
|------|-------------|
| `initComponents` | Inicializamos los componentes de la interfaz gráfica (comboBox  y etiquetas). Establece los action listeners para los comboBox que se activan cuando el usuario selecciona un elemento en el comboBox correspondiente.|
| `leerArchivoCSV` | Recibe un String (ruta del archivo csv). Lee un archivo CSV línea por línea utilizando un BufferedReader. Llama al método procesarLineaCSV (String line) para procesar cada línea leída. |
| `procesarLineaCSV` | Recibe un String (una línea del archivo CSV). Divide cada línea del archivo CSV en partes utilizando la coma como delimitador. Si la línea contiene más de 4 partes, agrega esas partes al arrayList  info, que almacena información como código postal, estado, ciudad, municipio y colonia. |
| `llenarEstadosComboBox` | Recorre el arrayList info y llena el comboBox de estados con los nombres únicos de los estados. |
| `llenarCiudadesComboBox` | Llena el combobox de ciudades con los nombres de las ciudades correspondientes al estado seleccionado en el método anterior. |
| `llenarMuniComoBox` | Llena el combobox de municipios con los nombres de los municipios correspondientes a la ciudad seleccionada en el método anterior. |
| `llenarCodigoPostalComboBox` | Llena el combobox de códigos postales con los códigos correspondientes al municipio seleccionado en el método anterior. |
| `llenarColoniaComboBox` | Llena el combobox de colonias con los nombres de las colonias correspondientes al código postal seleccionado. |
| `getInfoSeleccionada` | Obtiene la información seleccionada por el usuario de los comboboxes y la devuelve como una cadena de texto formateada. |
| `main` | Inicia la aplicación Swing creando un nuevo JFrame y agregando un objeto CodigoPostalPanel al contenido del frame. |

## INSTALACION:
1. Descarga:
Realiza la descarga del proyecto por medio del .zip o clonando el repositorio.

2. Importar el proyecto en el IDE preferido.

3. Dado que se ocupa un archivo CSV para leer los códigos postales, dentro de la clase en el método constructor en la parte en la que mandamos a llamar al método leerArchivoCSV debemos pasarle la ubicación adecuada.
Lo puedes hacer de la siguiente manera:
Debes abrir la carpeta del proyecto que descargaste y dentro abrir la carpeta “src” en la cual encontraras el archivo java y el archivo CSV deberás dar clic derecho sobre este ultimo e ir a las propiedades y por último copiar la dirección.
![1](https://github.com/SergioPorrasA/ITO_TAP_U2_COMPONENTE_CodigosPostales/assets/168385961/f9f0fa6d-2f77-47db-9e50-9bf30bbe7539)
![2](https://github.com/SergioPorrasA/ITO_TAP_U2_COMPONENTE_CodigosPostales/assets/168385961/74025a7c-1038-4257-99a7-4e59e5d49c63)

Ahora en el siguiente método (leerArchivoCSV) deberás pegar la ubicación que copiaste. OJO: deberás reemplazar solo la parte resaltada en negritas que se muestran a continuacion:


leerArchivoCSV(**"C:\\Users\\Sergio Porras A\\Documents\\NetBeansProjects\\ITO_TAP_U2_COMPONENTE_CodigosPostales\\src\\codigopostal\\** CodigosPostales.csv");

Si tu decides cambiar el nombre del archivo CSV es importante que lo cambies tambien en este metodo.


4. Compila y crea el componente .JAR (Es muy importante asegurarte de que el archivo .jar se cree para poder usarlo despues).
![9]((https://github.com/SergioPorrasA/ITO_TAP_U2_COMPONENTE_CodigosPostales/assets/123908757/f514fd0b-1641-4c1c-8091-ff8ae958e636)
6. Agrégalo a tu paleta de componentes de la siguiente manera:
Sobre la paleta de elementos da clic derecho y selecciona la opción Palette Manager…

![3](https://github.com/SergioPorrasA/ITO_TAP_U2_COMPONENTE_CodigosPostales/assets/168385961/ffbe0c34-7c6e-4041-bdd7-957471c61faf)


En esta ventana da clic en el primer botón “Add from JAR…”

![4](https://github.com/SergioPorrasA/ITO_TAP_U2_COMPONENTE_CodigosPostales/assets/168385961/862db3b5-482f-4814-b0a6-5e3f674a6fb8)

En esta ventana emergente buscaras la carpeta con el proyecto en donde tú lo hayas guardado y en la carpeta “dist” seleccionaras el archivo que aparece y dar clic en el botón “Next >”, asi como se muestra enseguida:

![5](https://github.com/SergioPorrasA/ITO_TAP_U2_COMPONENTE_CodigosPostales/assets/168385961/501c12ae-f54d-4279-a560-f2c3d934bdc9)


Después seleccionas el componente que tiene el nombre de nuestra clase principal:

![6](https://github.com/SergioPorrasA/ITO_TAP_U2_COMPONENTE_CodigosPostales/assets/168385961/7a05d714-da20-437e-baed-50f9dd79c8e3)


Por último seleccionas en que categoría de la paleta de componentes quieres que se agregue este componente:

![7](https://github.com/SergioPorrasA/ITO_TAP_U2_COMPONENTE_CodigosPostales/assets/168385961/27e0cd9c-38ec-4759-96bb-c4ef7a5e3740)


Como se observa, se nos agregara a nuestra paleta de componentes y lo tendremos a nuestra disposición para usar:

![8](https://github.com/SergioPorrasA/ITO_TAP_U2_COMPONENTE_CodigosPostales/assets/168385961/8e8be1fc-ee2f-42dc-abeb-9fc92dfedd78)



## FUNCIONAMIENTO:
- Hemos creado un video para que veas el funcionamiento del programa. Para verlo da click en el siguiente enlace:
https://youtu.be/jYMwbiZ-WaU?si=cup1yoBsrhZ3mGQn



## AUTORES:
- Porras Avendaño Sergio Ezequiel - Ing. en Sistemas Computacionales ***ITO*** [https://github.com/SergioPorrasA]
- Ortiz Barroso Itzel - Ing. en Sistemas Computacionales ***ITO*** [https://github.com/ItzelOrtix]
