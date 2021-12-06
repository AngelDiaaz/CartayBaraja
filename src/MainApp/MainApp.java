package MainApp;

import java.util.Scanner;

import Models.Baraja;
import Models.Carta;

public class MainApp {
	static Baraja baraja = new Baraja();
	static Carta carta;
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		baraja.Barajar();

		System.out.println("Hola bienvenido al juego de las 7 y media");
		System.out.println("¿Quieres jugar?(si/no)");
		String jugar = s.nextLine();

		if (jugar.equalsIgnoreCase("si")) {
			System.out.println("¿Contra la maquina?(si/no)");
			String maquina = s.nextLine();

			if (maquina.equalsIgnoreCase("no")) {
				singlePlayer();
				System.out.println("Gracias que tenga un buen dia");
			} else {
				IA();
			}

		} else {
			System.out.println("Gracias que tenga un buen dia");
		}
		s.close();
	}

	public static void singlePlayer() {
		String repetir;

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
					if (cont.equalsIgnoreCase("no")) {
						System.out.println("Fin del juego\nPuntuacion total: " + valor);
					}

				} else {
					// throw new Exception("\nTe has pasado de 7 y medio.\nHas perdido!!!");
					System.out.println("\nTe has pasado de 7 y medio.\nHas perdido!!!");
					break;
				}
			} while (cont.equalsIgnoreCase("si"));
			System.out.println("¿Quieres volver a jugar?");
			repetir = s.nextLine();

		} while (repetir.equalsIgnoreCase("si"));

	}

	public static void IA() {
		String cont;
		String repetir;
		boolean fin = false;

		do {
			double valor = 0;
			double valorIA = 0;

			do {
				carta = baraja.Robar();
				System.out.println("Tu carta: " + carta);
				valor += carta.getValor7ymedia();
				System.out.println("Tu puntuacion: " + valor);

				if (valorIA <= 5.5) {
					carta = baraja.Robar();
					System.out.println("\nCarta maquina: " + carta);
					valorIA += carta.getValor7ymedia();
					System.out.println("Puntucion maquina: " + valorIA);
				} else {
					System.out.println("Puntucion maquina: " + valorIA);

				}

				if (valor == 7.5) {
					System.out.println("7 y medio!!! Felicidades has ganado a la maquina!!!!");
					break;
				} else if (valorIA == 7.5) {
					System.out.println("7 y medio para la maquina!!!\nLo siento has perdido\nGanador la maquina!!!!");
					break;
				}

				if (valor > 7.5) {
					System.out.println("Lo siento has perdido\nGanador la maquina!!!!");
					break;
				} else if (valorIA > 7.5) {
					System.out.println("Felicidades has ganado a la maquina!!!!");
					break;
				} else if (valor == valorIA && fin == true) {
					System.out
							.println("Habeis empatado, pero la banca siempre gana\nHas perdido contra la maquina!!!!");
					break;
				}

				System.out.println("¿Quieres otra carta?");
				cont = s.nextLine();
				if (cont.equalsIgnoreCase("no")) {
					fin = true;
					if (valor > valorIA) {
						if (valorIA <= 5.5) {
							while (valorIA <= 6) {
								carta = baraja.Robar();
								System.out.println("\nCarta maquina: " + carta);
								valorIA += carta.getValor7ymedia();
								System.out.println("Puntucion maquina: " + valorIA);
								if (valorIA > 7.5) {
									System.out.println("Felicidades has ganado a la maquina!!!!");
									break;
								} else if (valorIA == 7.5) {
									System.out.println(
											"7 y medio para la maquina!!!\nLo siento has perdido\nGanador la maquina!!!!");
									break;
								}

							}
							break;
						}
					}
					if (valorIA < valor) {
						System.out.println("Felicidades has ganado a la maquina!!!!");
						break;
					} else if (valor < valorIA) {
						System.out.println("Lo siento has perdido\nGanador la maquina!!!!");
						break;
					} else if (valor == valorIA && fin == true) {
						System.out.println(
								"Habeis empatado, pero la banca siempre gana\nHas perdido contra la maquina!!!!");
					}
				}

			} while (cont.equalsIgnoreCase("si"));
			System.out.println("¿Quieres volver a jugar?(si/no)");
			repetir = s.nextLine();
			if (repetir.equalsIgnoreCase("no")) {

			}
		} while (repetir.equalsIgnoreCase("si"));
		System.out.println("Gracias que tenga un buen dia");

	}

}
