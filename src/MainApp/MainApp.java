package MainApp;

import Models.Baraja;
import Models.Carta;

public class MainApp {

	public static void main(String[] args) {
		
		Carta carta = new Carta(8, 2);
		Carta carta2 = new Carta(10);
		Baraja baraja = new Baraja();
		

		System.out.println(carta2.getNombreCarta());
		System.out.println(carta2.getNombrePalo());
		System.out.println(carta2.getNombreNumero());
		
		baraja.Robar();
		baraja.getNumeroCartas();
		
	}

	

}
