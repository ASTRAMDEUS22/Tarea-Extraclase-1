package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

/**
 * Tarea Extraclase1
 *
 * @autor Josthin Soto Sánchez
 */


/**
 * Metodo main que se hereda la clase Application de JavaFX.
 */
public class Main extends Application {

    //DEFINIR OBJETOS DE LA INTERFAZ
        //Botones
    Button addButton,
            sumButton,
            resButton,
            multiButton,
            diviButton,
            persona1Button,
            persona2Button,
            persona3Button,
            persona4Button,
            clearButton;
        //ComboBox/DropDownList
    ComboBox<String> comboBox;

        //Labels
    Label labelNombre,
            labelSeccionNombre,
            labelSeccionOperadores,
            labelEdad,
            labelProvincias,
            labelResultado,
            labelPersona1,
            labelPersona2,
            labelPersona3,
            labelPersona4,
            labelNombreSelect1,
            labelNombreSelect2,
            labelEdadSelect1,
            labelEdadSelect2,
            labelProvinciaSelect1,
            labelProvinciaSelect2;
        //Cajas de texto
    TextField textoNombre,
            textoEdad,
            textoResultado;
        //Listas
    List<Persona> listaPersonas;
    List<Persona> listaPersonasUsar;



    int xCoords;  //Coordenadas de los botones de operaciones, para mantener sincronía

    /**
     * Meotodo donde se maneja lo relacionado a JavaFX y la parte gráfica.
     * @param stage zona que utiliza JavaFX para almacenar todos los Objetos que se añadan a la pantalla.
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        xCoords = 50;

        //LISTA DE OBJETOS
        listaPersonas = new ArrayList<>();  //Se inicializa una lista para almacenar objetos Persona
        listaPersonasUsar = new ArrayList<>();  //Se inicializa una lista para almacenar las edades de las personas

        //BOTONES
        addButton = new Button(); //Instancia de nuevo boton
        addButton.setText("+Person");  //Texto del boton
        addButton.setTranslateX(-300.0);  //Coords en X
        addButton.setTranslateY(200.0);   //Coords en Y
        addButton.setOnAction(e -> agregarElementos());  //Accion al presionar el boton

        sumButton = new Button(); //Instancia de nuevo boton
        sumButton.setText("+");  //Texto del boton
        sumButton.setTranslateX(xCoords);  //Coords en X
        sumButton.setTranslateY(200.0);    //Coords en Y
        sumButton.setOnAction(e -> obtenerNumerosSuma());  //Accion al presionar el boton

        resButton = new Button(); //Instancia de nuevo boton
        resButton.setText("-");  //Texto del boton
        resButton.setTranslateX(xCoords + 50); //Coords en X
        resButton.setTranslateY(200.0);        //Coords en Y
        resButton.setOnAction(e -> obtenerNumerosResta());  //Accion al presionar el boton

        multiButton = new Button(); //Instancia de nuevo boton
        multiButton.setText("*");  //Texto del boton
        multiButton.setTranslateX(xCoords + 100); //Coords en X
        multiButton.setTranslateY(200.0);         //Coords en Y
        multiButton.setOnAction(e -> obtenerNumerosMulti());  //Accion al presionar el boton

        diviButton = new Button(); //Instancia de nuevo boton
        diviButton.setText("/");  //Texto del boton
        diviButton.setTranslateX(xCoords + 150); //Coords en X
        diviButton.setTranslateY(200.0);         //Coords en Y
        diviButton.setOnAction(e -> obtenerNumerosDivi());  //Accion al presionar el boton

        clearButton = new Button();
        clearButton.setText("Clear");
        clearButton.setOnAction(e -> clearListButton());
        clearButton.setTranslateX(280);
        clearButton.setTranslateY(-250);

        persona1Button = new Button();  //Instancia del boton
        persona1Button.setText("Select");  //Se define el texto
        persona1Button.setOnAction(e -> seleccionarPersona1());  //Accion al presionar el boton
        persona1Button.setTranslateX(280);  //Coords en X
        persona1Button.setTranslateY(-100); //Coords en Y

        persona2Button = new Button();  //Instancia de nuevo boton
        persona2Button.setText("Select");  //Se define el texto
        persona2Button.setOnAction(e -> seleccionarPersona2());  //Accion al presionar el boton
        persona2Button.setTranslateX(280); //Coords en X
        persona2Button.setTranslateY(-40);   //Coords en Y

        persona3Button = new Button();  //Instancia de nuevo boton
        persona3Button.setText("Select");  //Se define el texto
        persona3Button.setOnAction(e -> seleccionarPersonas3());  //Accion al presionar el boton
        persona3Button.setTranslateX(280); //Coords en X X
        persona3Button.setTranslateY(20);     //Coords en Y

        persona4Button = new Button();  //Instancia de nuevo boton
        persona4Button.setText("Select");  //Se define el texto
        persona4Button.setOnAction(e -> seleccionarPersonas4());  //Accion al presionar el boton
        persona4Button.setTranslateX(280);  //Coords en X
        persona4Button.setTranslateY(80); //Coords en Y

        //MENUS
        comboBox = new ComboBox<>();  //Instancia del comboBox
        comboBox.getItems().addAll(  //Se añaden las provincias
                "San Jose",
                "Alajuela",
                "Cartago",
                "Heredia",
                "Guanacaste",
                "Puntarenas",
                "Limón");
        comboBox.setPromptText("Province");  //Nombre inicial del comboBox
        comboBox.setTranslateX(-215.0);  //Coords en X
        comboBox.setTranslateY(0);  //Coords en Y

        //LABELS
        labelSeccionNombre = new Label();
        labelSeccionNombre.setText("Add person");
        labelSeccionNombre.setTranslateX(-340.0);
        labelSeccionNombre.setTranslateY(-150.0);

        labelSeccionOperadores = new Label();
        labelSeccionOperadores.setText("Operations");
        labelSeccionOperadores.setTranslateX(50);
        labelSeccionOperadores.setTranslateY(-150);

        labelNombre = new Label();  //Instancia del label
        labelNombre.setText("Name:");  //Texto del label
        labelNombre.setTranslateX(-340.0);  //Coords en X
        labelNombre.setTranslateY(-100.0);  //Coords en Y

        labelEdad = new Label();  //Instancia del label
        labelEdad.setText("Age:");  //Texto del label
        labelEdad.setTranslateX(-340.0);  //Coords en X
        labelEdad.setTranslateY(-60.0);   //Coords en Y

        labelProvincias = new Label();  //Instancia del label
        labelProvincias.setText("Province:");  //Texto del label
        labelProvincias.setTranslateX(-340.0);  //Coords en X
        labelProvincias.setTranslateY(0);       //Coords en Y

        labelResultado = new Label();  //Instancia del label
        labelResultado.setText("Result:");  //Texto del label
        labelResultado.setTranslateX(-340.0);  //Coords en X
        labelResultado.setTranslateY(-240.0);  //Coords en Y

        labelPersona1 = new Label();  //Instancia del label
        labelPersona1.setText("");  //Texto del label
        labelPersona1.setTranslateX(120.0);  //Coords en X
        labelPersona1.setTranslateY(-100); //Coords en Y

        labelPersona2 = new Label();  //Instancia del label
        labelPersona2.setText(" ");  //Texto del label
        labelPersona2.setTranslateX(120.0);  //Coords en X
        labelPersona2.setTranslateY(-40);  //Coords en Y

        labelPersona3 = new Label();  //Instancia del label
        labelPersona3.setText("");  //Texto del label
        labelPersona3.setTranslateX(120.0);  //Coords en X
        labelPersona3.setTranslateY(20);      //Coords en Y

        labelPersona4 = new Label();  //Instancia del label
        labelPersona4.setText("");  //Texto del label
        labelPersona4.setTranslateX(120.0);  //Coords en X
        labelPersona4.setTranslateY(80);   //Coords en Y

        labelNombreSelect1 = new Label();  //Instancia del label
        labelNombreSelect1.setText("");  //Se inicia vacio ya que aún no hay un nombre
        labelNombreSelect1.setTranslateX(0);  //Coords en X
        labelNombreSelect1.setTranslateY(-265);  //Coords en Y

        labelEdadSelect1 = new Label();  //Instancia del label
        labelEdadSelect1.setText("");  //Se inicia vacio ya que aún no hay una edad
        labelEdadSelect1.setTranslateX(80);  //Coords en X
        labelEdadSelect1.setTranslateY(-265);  //Coords en Y

        labelProvinciaSelect1 = new Label();  //Instancia del label
        labelProvinciaSelect1.setText("");  //Se inicia vacio ya que aún no hay una provincia
        labelProvinciaSelect1.setTranslateX(160);  //Coords en X
        labelProvinciaSelect1.setTranslateY(-265);  //Coords en Y

        labelNombreSelect2 = new Label();  //Instancia del label
        labelNombreSelect2.setText("");  //Se inicia vacio ya que aún no hay un nombre
        labelNombreSelect2.setTranslateX(0);  //Coords en X
        labelNombreSelect2.setTranslateY(-215);  //Coords en Y

        labelEdadSelect2 = new Label();  //Instancia del label
        labelEdadSelect2.setText("");  //Se inicia vacio ya que aún no hay una edad
        labelEdadSelect2.setTranslateX(80);  //Coords en X
        labelEdadSelect2.setTranslateY(-215);//Coords en Y

        labelProvinciaSelect2 = new Label();  //Instancia del label
        labelProvinciaSelect2.setText("");  //Se inicia vacio ya que aún no hay una provincia
        labelProvinciaSelect2.setTranslateX(160);  //Coords en X
        labelProvinciaSelect2.setTranslateY(-215);//Coords en Y


        //CUADROS DE TEXTO
        textoNombre = new TextField();  //Instancia de la caja de texto
        textoNombre.setTranslateX(-200.0);  //Coords en X
        textoNombre.setTranslateY(-100.0);  //Coords en Y
        textoNombre.setMaxWidth(200.0);  //Tamaño del cuadro
        textoNombre.setPromptText("Insert name");

        textoEdad = new TextField();  //Instancia de la caja de texto
        textoEdad.setTranslateX(-200.0);  //Coords en X
        textoEdad.setTranslateY(-60.0);   //Coords en Y
        textoEdad.setMaxWidth(200.0);  //Tamaño del cuadro
        textoEdad.setPromptText("Insert age");

        textoResultado = new TextField();  //Instancia de la caja de texto
        textoResultado.setTranslateX(-150.0);  //Coords en X
        textoResultado.setTranslateY(-240.0);  //Coords en Y
        textoResultado.setMaxWidth(200);  //Tamaño del cuadro
        textoResultado.setEditable(false);  //Se habilita/desabilita la edición


        //ZONA DE ADICCION DE OBJETOS AL CANVAS
        StackPane canva = new StackPane();  //Instancia del lienzo donde se va a trabajar
        canva.getChildren().addAll(  //Se añaden los objetos de JavaFX al lienzo
                addButton,
                comboBox,
                labelSeccionNombre,
                labelSeccionOperadores,
                labelNombre,
                labelEdad,
                labelProvincias,
                labelResultado,
                textoNombre,
                textoEdad,
                textoResultado,
                sumButton,
                resButton,
                multiButton,
                diviButton,
                persona1Button,
                persona2Button,
                persona3Button,
                persona4Button,
                labelPersona1,
                labelPersona2,
                labelPersona3,
                labelPersona4,
                labelNombreSelect1,
                labelEdadSelect1,
                labelProvinciaSelect1,
                labelNombreSelect2,
                labelEdadSelect2,
                labelProvinciaSelect2,
                clearButton);

        //CREAR VENTANA Y MOSTRARLA
        Scene ventana = new Scene(canva,800,600);
        stage.setScene(ventana);
        stage.setTitle("CALCULATOR"); //Titulo de la ventana
        stage.show();  //Se muestra lo añadido al canvas

    }

    /**
     * Metodo que al ser ejecuta por el boton agrega la información de los cuadros a una lista para posteriormente ser
     * utilizada en las operaciones.
     */
    void agregarElementos(){
        //Variables locales para asignar atributos al objeto Persona
        String nombre,provincia;
        int edad;
        //Se toma el string de las cajas de texto para inicializar las variables locales
        nombre = textoNombre.getText();
        provincia = comboBox.getValue();


        try {  //Un try que verifica si hay algún error con el formato de la edad
            edad = Integer.parseInt((textoEdad.getText()));  //Se convierte la edad a Integer
            if (listaPersonas.size()> 3){  //Se verifica que haya un máximo de 4 objetos persona
                AlertWindow.display("WARNING","You can't' have more than 4 people");  //Se alerta que solo puede haber un máximo de 4 personas
            } else if(edad <= 0){  //Se verifica que la edad sea distinta de 0
                AlertWindow.display("WARNING","Age cannot be 0");
            } else if(provincia != null){  //Se verifica que la provincia tenga un valor

                Persona persona = new Persona();  //INSTANCIAR UN OBJETO PERSONA
                persona.setNombre(nombre);  //Se asigna el atributo nombre
                persona.setEdad(edad);  //Se asigna el atributo edad
                persona.setProvincia(provincia);  //Se asigna el atributo provincia

                listaPersonas.add(persona);  //Añadir la instancia persona a una lista
                labelPersona1.setText(listaPersonas.get(0).getNombre());  //Se les da el nombre de los objetos Persona a esos labels
                labelPersona2.setText(listaPersonas.get(1).getNombre());  //Se les da el nombre de los objetos Persona a esos labels
                labelPersona3.setText(listaPersonas.get(2).getNombre());  //Se les da el nombre de los objetos Persona a esos labels
                labelPersona4.setText(listaPersonas.get(3).getNombre());  //Se les da el nombre de los objetos Persona a esos labels
            }else{
                AlertWindow.display("WARNING","You need select 1 province");  //Se alerta que se necesita seleccionar una provincia
            }

        } catch (NumberFormatException e){  //Se alerta que en edad no hay un numero
            AlertWindow.display("WARNING","Age needs to be an integer");
        }

        }

    /**
     * Metodo que elige la persona del indice 0 en la lista Personas.
     */
    void seleccionarPersona1(){
        if (listaPersonasUsar.size() <= 2) {  //Verifica que hayan solo 2 personas en la Operacion
            listaPersonasUsar.add(listaPersonas.get(0));

        labelNombreSelect1.setText(listaPersonasUsar.get(0).getNombre());
        labelEdadSelect1.setText(String.valueOf(listaPersonasUsar.get(0).getEdad()));
        labelProvinciaSelect1.setText(listaPersonasUsar.get(0).getProvincia());

        labelNombreSelect2.setText(listaPersonasUsar.get(1).getNombre());
        labelEdadSelect2.setText(String.valueOf(listaPersonasUsar.get(1).getEdad()));
        labelProvinciaSelect2.setText(listaPersonasUsar.get(1).getProvincia());

        }else {
            AlertWindow.display("Alert","You can only choose 2 people for the operation");
        }
    }

    /**
     * Metodo que elige la persona del indice 1 en la lista Personas.
     */
    void seleccionarPersona2(){
        if (listaPersonasUsar.size() <= 2) {  //Verifica que hayan solo 2 personas en la Operacion
            listaPersonasUsar.add(listaPersonas.get(1));

            labelNombreSelect1.setText(listaPersonasUsar.get(0).getNombre());
            labelEdadSelect1.setText(String.valueOf(listaPersonasUsar.get(0).getEdad()));
            labelProvinciaSelect1.setText(listaPersonasUsar.get(0).getProvincia());

            labelNombreSelect2.setText(listaPersonasUsar.get(1).getNombre());
            labelEdadSelect2.setText(String.valueOf(listaPersonasUsar.get(1).getEdad()));
            labelProvinciaSelect2.setText(listaPersonasUsar.get(1).getProvincia());

        }else {
            AlertWindow.display("Alert","You can only choose 2 people for the operation");
        }
    }

    /**
     * Metodo que elige la persona del indice 2 en la lista Personas.
     */
    void seleccionarPersonas3(){
        if (listaPersonasUsar.size() <= 2) {  //Verifica que hayan solo 2 personas en la Operacion
            listaPersonasUsar.add(listaPersonas.get(2));

            labelNombreSelect1.setText(listaPersonasUsar.get(0).getNombre());
            labelEdadSelect1.setText(String.valueOf(listaPersonasUsar.get(0).getEdad()));
            labelProvinciaSelect1.setText(listaPersonasUsar.get(0).getProvincia());

            labelNombreSelect2.setText(listaPersonasUsar.get(1).getNombre());
            labelEdadSelect2.setText(String.valueOf(listaPersonasUsar.get(1).getEdad()));
            labelProvinciaSelect2.setText(listaPersonasUsar.get(1).getProvincia());

        }else {
            AlertWindow.display("Alert","You can only choose 2 people for the operation");
        }
    }

    /**
     * Metodo que elige la persona del indice 0 en la lista Personas.
     */
    void seleccionarPersonas4(){
        if (listaPersonasUsar.size() <= 2) {  //Verifica que hayan solo 2 personas en la Operacion
            listaPersonasUsar.add(listaPersonas.get(3));

            labelNombreSelect1.setText(listaPersonasUsar.get(0).getNombre());
            labelEdadSelect1.setText(String.valueOf(listaPersonasUsar.get(0).getEdad()));
            labelProvinciaSelect1.setText(listaPersonasUsar.get(0).getProvincia());

            labelNombreSelect2.setText(listaPersonasUsar.get(1).getNombre());
            labelEdadSelect2.setText(String.valueOf(listaPersonasUsar.get(1).getEdad()));
            labelProvinciaSelect2.setText(listaPersonasUsar.get(1).getProvincia());

        }else {
            AlertWindow.display("Alert","You can only choose 2 people for the operation");
        }
    }

    /**
     * Metodo que remueve las personas en la lista de listaPersonasUsar.
     */
    void clearListButton(){
        try {

            listaPersonasUsar.remove(0);
            listaPersonasUsar.remove(0);
        }catch (IndexOutOfBoundsException e){  //Evita el error al no haber elementos que borrar
            return;
        }

        //Vacia los labels
        labelNombreSelect1.setText("");
        labelEdadSelect1.setText("");
        labelProvinciaSelect1.setText("");
        //Vacia los labels
        labelNombreSelect2.setText("");
        labelEdadSelect2.setText("");
        labelProvinciaSelect2.setText("");
        //Elimina el resultado
        textoResultado.setPromptText("");
    }

    /**
     * Metodo que envia los 2 numeros a la suma.
     */
    void obtenerNumerosSuma() {
        if (listaPersonasUsar.size() != 1) {
            realizarSuma(listaPersonasUsar.get(0).getEdad(), listaPersonasUsar.get(1).getEdad());
        }else{
            AlertWindow.display("ALERT","You need 2 people for Operators");
        }
    }

    /**
     * Metodo que envia los 2 numeros a la resta.
     */
    void obtenerNumerosResta() {
        if (listaPersonasUsar.size() != 1) {
            realizarResta(listaPersonasUsar.get(0).getEdad(), listaPersonasUsar.get(1).getEdad());
        }else{
            AlertWindow.display("ALERT","You need 2 people for Operators");
        }
    }

    /**
     * Metodo que envia los 2 numeros a la multiplicacion.
     */
    void obtenerNumerosMulti() {
        if (listaPersonasUsar.size() != 1) {
            realizarMulti(listaPersonasUsar.get(0).getEdad(), listaPersonasUsar.get(1).getEdad());
        }else{
            AlertWindow.display("ALERT","You need 2 people for Operators");
        }
    }

    /**
     * Metodo que envia los 2 numeros a la division.
     */
    void obtenerNumerosDivi() {
        if (listaPersonasUsar.size() != 1) {
            realizarDivi(listaPersonasUsar.get(0).getEdad(), listaPersonasUsar.get(1).getEdad());
        }else{
            AlertWindow.display("ALERT","You need 2 people for Operators");
        }
    }

    /**
     * Metodo que suma las edades.
     * @param a Primera edad.
     * @param b Segunda edad.
     */
    void realizarSuma(int a, int b){
        int c;
        c = a + b;
        textoResultado.setPromptText(String.valueOf(c));
    }

    /**
     * Metodo que resta las edades.
     * @param a Primera edad.
     * @param b Segunda edad.
     */
    void realizarResta(int a, int b){
        int c;
        c = a - b;
        textoResultado.setPromptText(String.valueOf(c));
    }

    /**
     * Metodo que multiplica las edades.
     * @param a Primera edad.
     * @param b Segunda edad.
     */
    void realizarMulti(int a, int b){
        int c;
        c = a * b;
        textoResultado.setPromptText(String.valueOf(c));
    }

    /**
     * Metodo que divide las edades.
     * @param a Primera edad.
     * @param b Segunda edad.
     */
    void realizarDivi(int a, int b){  //METODO QUE DIVIDE LAS EDADES
        double c;

        c = a / b;
        textoResultado.setPromptText(String.valueOf(c));
    }

    /**
     * Metodo main que ejecuta el programa, el lauch() se encarga de ejecutar los componentes graficos de JavaFX.
     * @param args Permite que se pasen argumentos desde la línea de comandos al programa Java cuando se ejecuta.
     */
    public static void main(String[] args) {
        launch();  //Inicia lo relacionado a JavaFX con las clases y métodos
    }
}