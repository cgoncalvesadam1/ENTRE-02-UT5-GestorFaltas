import java.util.*;
/**
 * Un objeto de esta clase guarda la información de un estudiante
 *
 */
public class Estudiante {
    private final static String SEPARADOR = ",";
    private String nombre;
    private String apellidos;
    private int faltasNoJustificadas;
    private int faltasJustificadas;
    private enum apercibimiento{SIN_APERCIBIMIENTOS, DIEZ, VEINTE, TREINTA}
    /**
     *  
     *  Inicializa los atributos a partir de la información recibida
     *  Esta información se encuentra en lineaDatos
     *  (ver enunciado) 
     *  
     */
    public Estudiante(String lineaDatos) {
        String[] str;
        str = lineaDatos.split(SEPARADOR);
        // lineaDatos = (nombre + "," + apellidos + ","+ faltasNoJustificadas + "," + faltasJustificadas);
        // trim() ELIMINA LOS ESPACIOS EN BLANCO
        nombre = str[0].trim();
        String nombre2 = formarNombre(nombre);
        apellidos = str[1].trim().toUpperCase();
        faltasNoJustificadas = Integer.parseInt(str[2].trim());
        faltasJustificadas = Integer.parseInt(str[3].trim());
    }

    private String formarNombre(String nombre)
    {
        String[]arrNombre = nombre.split(" ");
        String auxNombre = "";
        for(int i = 0; i < arrNombre.length - 1; i++){
            if(!arrNombre[i].equals("")){
                auxNombre += arrNombre[i].substring(0,1).toUpperCase() + ".";
            }
        }
        String letra1 = arrNombre[arrNombre.length - 1].substring(0,1);
        String restoNombre = arrNombre[arrNombre.length - 1].substring(1,arrNombre.length);
        auxNombre += letra1 + restoNombre;

        return auxNombre;
    }

    /**
     * accesor para el nombre completo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * mutador para el nombre
     *  
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * accesor para los apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *  mutador para los apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * accesor para el nº de faltas no justificadas
     */
    public int getFaltasNoJustificadas() {
        return faltasNoJustificadas;
    }

    /**
     * mutador para el nº de faltas no justificadas
     */
    public void setFaltasNoJustificadas(int faltasNoJustificadas) {
        this.faltasNoJustificadas = faltasNoJustificadas;
    }

    /**
     * accesor para el nº de faltas justificadas
     */
    public int getFaltasJustificadas() {
        return faltasJustificadas;
    }

    /**
     *  mutador para el nº de faltas justificadas
     */
    public void setFaltasJustificadas(int faltasJustificadas) {
        this.faltasJustificadas = faltasJustificadas;
    }

    /**
     *  se justifican n faltas que hasta el momento eran injustificadas
     *  Se asume n correcto
     */
    public void justificar(int n) {
        this.faltasNoJustificadas -= n;
        this.faltasJustificadas += n;
    }

    /**
     * Representación textual del estudiante
     * (ver enunciado)
     */ 

    public String toString() {
        String muestra;
        apercibimiento ap;
        muestra = "Apellidos y Nombre: " + getApellidos() + "," + getNombre() + "\n";
        muestra += "Faltas No Justificada: " + getFaltasNoJustificadas() + "\n";
        muestra += "Faltas Justificadas: " + getFaltasNoJustificadas() + "\n";
        muestra += "apercibimientos: ";

        if(getFaltasNoJustificadas() >= 10){
            ap = apercibimiento.DIEZ;
            muestra += ap;
        }

        if(getFaltasNoJustificadas() >= 20){
            ap = apercibimiento.VEINTE;
            muestra += ap;
        }

        if(getFaltasNoJustificadas() >= 30){
            ap = apercibimiento.TREINTA;
            muestra += ap;
        }

        if(getFaltasNoJustificadas() < 10){
            ap = apercibimiento.SIN_APERCIBIMIENTOS;
            muestra += ap;
        }
        return muestra;
    }

    public static void main(String[] args) {
        Estudiante e1 = new Estudiante("  ander ibai  ,  Ruiz Sena , 12, 23");
        System.out.println(e1);
        System.out.println();
        Estudiante e2 = new Estudiante(
                " pedro josé   andrés  ,  Troya Baztarrica , 42, 6 ");
        System.out.println(e2);
        System.out.println();
        Estudiante e3 = new Estudiante("  Javier  ,  Suescun  Andreu , 39, 9 ");
        System.out.println(e3);
        System.out.println();
        Estudiante e4 = new Estudiante("julen, Duque Puyal, 5, 55");
        System.out.println(e4);
        System.out.println();

        System.out.println("---------------------------------");
        e1.justificar(3);
        System.out.println(e1);
        System.out.println();

        System.out.println("---------------------------------");

        e3.justificar(12);
        System.out.println(e3);
        System.out.println();

    }

}
