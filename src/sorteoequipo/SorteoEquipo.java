
package sorteoequipo;
import Equipos.Etapa;
import java.util.Scanner;
public class SorteoEquipo {
    public static void main(String[] args) {
        Scanner salida= new Scanner(System.in);
        System.out.print("ELija la etapa  \n1.Octavos \n2.Cuartos \n3.Semifinales \n4.Final ");
        String etapa = salida.nextLine().trim().toLowerCase();

        Etapa etapaTorneo = null;

        switch (etapa) {
            case "1":
                etapaTorneo = new Octavos();
                break;
            case "2":
                etapaTorneo = new Cuartos();
                break;
            case "3":
                etapaTorneo = new Semifinales();
                break;
            case "4":
                etapaTorneo = new Finales();
                break;
            default:
                System.out.println("Etapa no válida. Intente nuevamente.");
                System.exit(0);
        }
        // Realiza el sorteo
        etapaTorneo.realizarSorteo();
    }
}