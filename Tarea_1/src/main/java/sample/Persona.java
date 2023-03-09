package sample;

/**
 * Objeto persona que tiene de atributos nombre,edad,provincia.
 */
public class Persona {

    private String nombre;  //Atributo nombre
    private int edad;  //Atributo edad
    private String provincia;  //Atributo provincias

    /**
     * Devuelve la edad de la Persona.
     * @return edad.
     */
    public int getEdad() {  //Retorna la edad

        return edad;
    }

    /**
     * Se asigna una edad a la persona.
     * @param edad nueva edad de la persona.
     */
    public void setEdad(int edad) {  //Se cambia el atributo edad

        this.edad = edad;
    }

    /**
     * Devuelve el nombre de la persona.
     * @return nombre.
     */
    public String getNombre() {  //Retorna el nombre

        return nombre;
    }

    /**
     * Se asigna un nombre a la persona.
     * @param nombre nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {  //Se cambia el atributo nombre

        this.nombre = nombre;
    }

    /**
     * Devuelve la provincia.
     * @return provincia.
     */
    public String getProvincia() {  //Retorna la provincia

        return provincia;
    }

    /**
     * Se asigna la provincia.
     * @param provincia nueva provincoa de la persona.
     */
    public void setProvincia(String provincia) {  //Se cambia el atributo provincia
        this.provincia = provincia;
    }

}
