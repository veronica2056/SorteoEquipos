
package Equipos;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Excepción personalizada para equipos repetidos
class EquipoRepetidoException extends Exception {
    public EquipoRepetidoException(String mensaje) {
        super(mensaje);
    }
}
public abstract class Etapa {
    protected List<String> equipos = new ArrayList<>();
    public abstract int getNumeroEquipos();
    // Método para realizar el sorteo
    public void realizarSorteo() {
        Scanner salida = new Scanner(System.in);
        int numEquipos = getNumeroEquipos();
        System.out.println("Ingrese los nombres de los " + numEquipos + " equipos:");
        for (int i = 0; i < numEquipos; i++) {
            while (true) {
                System.out.print("Equipo " + (i + 1) + ": ");
                String nombreEquipo = salida.nextLine();
                try {
                    if (equipos.contains(nombreEquipo)) {
                        throw new EquipoRepetidoException("Error: El equipo '" + nombreEquipo + "' ya fue ingresado.");
                    }
                    equipos.add(nombreEquipo);
                    break; // Sale del bucle si el nombre es válido
                } catch (EquipoRepetidoException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        // Jugar las rondas hasta que quede un ganador
        String ganador = jugarTorneo(equipos);
        System.out.println("\n El equipo ganador del torneo es: " + ganador + "!");
    }
    // Método para jugar todas las rondas del torneo
    private String jugarTorneo(List<String> equipos) {
        while (equipos.size() > 1) {
            System.out.println("\n--- Partidos nuevo ---");
            List<String> ganadores = new ArrayList<>();
            // Mezclamos los equipos antes de cada ronda
            mezclarEquipos(equipos);
            for (int i = 0; i < equipos.size(); i += 2) {
                String equipo1 = equipos.get(i);
                String equipo2 = equipos.get(i + 1);
                // Determinar al ganador aleatoriamente
                String ganador = determinarGanador(equipo1, equipo2);
                System.out.println("Partido: " + equipo1 + " vs " + equipo2 + " -> Ganador: " + ganador);
                ganadores.add(ganador);
            }
            equipos = ganadores; // Actualizar equipos para la siguiente ronda
        }
        return equipos.get(0); // Retornar el único equipo restante como ganador
    }
    // Método para mezclar aleatoriamente los equipos
    private void mezclarEquipos(List<String> lista) {
        Random random = new Random();
        for (int i = lista.size() - 1; i > 0; i--) {
            int indiceAleatorio = random.nextInt(i + 1);
            // Intercambia elementos en las posiciones i e indiceAleatorio
            String temp = lista.get(i);
            lista.set(i, lista.get(indiceAleatorio));
            lista.set(indiceAleatorio, temp);
        }
    }
    // Método para determinar al ganador aleatoriamente entre dos equipos
    private String determinarGanador(String equipo1, String equipo2) {
        Random random = new Random();
        return random.nextBoolean() ? equipo1 : equipo2;
    }
}