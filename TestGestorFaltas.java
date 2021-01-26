/**
 * Punto de entrada a la aplicaci�n
 */
public class TestGestorFaltas {
    /**
     * Se acepta como argumento del main() el n� m�ximo de estudiantes
     * y una vez creado el gestor de faltas se muestra la informaci�n solicitada
     * (ver enunciado)
     */
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("Solo se admite un argumento");
        }
        else{
            GestorFaltas info = new GestorFaltas(Integer.parseInt(args[0]));
            info.leerDeFichero();
            System.out.println(info.toString());
            
            info.justificarFaltas("IRISO FLAMARIQUE", 6);
            info.ordenar();
            System.out.println(info.toString());
            
            info.anularMatricula();
            System.out.println(info.toString());
        }
    }
}
