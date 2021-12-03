package MainApp;

import java.util.Scanner;

import Models.Baraja;
import Models.Carta;

public class MainApp {

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		Baraja baraja = new Baraja();
		baraja.Barajar();

		Carta carta;
		String repetir;

		System.out.println("Hola bienvenido al juego de las 7 y media");
		System.out.println("¿Quieres jugar?(si/no)");
		String jugar = s.nextLine();

		if (jugar.equalsIgnoreCase("si")) {
			do {
				String cont = "si";
				double valor = 0;
				
				do {
					carta = baraja.Robar();
					System.out.println("Carta: " + carta);
					valor += carta.getValor7ymedia();
					System.out.println("Puntuacion: " + valor);

					if (valor <= 7.5) {
						System.out.println("¿Quieres otra carta?");
						cont = s.nextLine();
						if(cont.equalsIgnoreCase("no")) {
							System.out.println("Fin del juego\nPuntuacion total: " + valor);
						}
						
					} else {
						//throw new Exception("\nTe has pasado de 7 y medio.\nHas perdido!!!");
						System.out.println("\nTe has pasado de 7 y medio.\nHas perdido!!!");
						break;
					}
				} while (cont.equalsIgnoreCase("si"));
				System.out.println("¿Quieres volver a jugar?");
				repetir = s.nextLine();

			} while (repetir.equalsIgnoreCase("si"));
			
			System.out.println("Gracias que tenga un buen dia");

		} else {
			System.out.println("Gracias que tenga un buen dia");
		}
		s.close();
	}

}
