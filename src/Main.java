import persons.Jugador;

public class Main {
    public static void main(String[] args) {
        Jugador jugador = new Jugador("nom",
                "cognom",
                "datanAix",
                10000,
                true,
                5,
                Jugador.Posicio.MIG
                );

        System.out.println(jugador.getPuntuacio());
        jugador.entrenar();
        System.out.println(jugador.getPuntuacio());
    }
}