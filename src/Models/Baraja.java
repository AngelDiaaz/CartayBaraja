package Models;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {

	// Propiedades
	private ArrayList<Carta> lista_cartas;

	// Constructores

	public Baraja() {
		lista_cartas = new ArrayList<Carta>();

		for (int i = 1; i <= 40; i++) {
			lista_cartas.add(new Carta(i));
		}

	}

	public Baraja(int tipobaraja) {
		switch (tipobaraja) {

		case 1:
			lista_cartas = new ArrayList<Carta>();
			for (int i = 1; i <= 40; i++) {
				lista_cartas.add(new Carta(i));
			}
			break;

		case 2:
			lista_cartas = new ArrayList<Carta>();
			for (int j = 0; j < 2; j++) {
				for (int i = 1; i <= 40; i++) {
					lista_cartas.add(new Carta(i));
				}
			}
			break;
		}
	}

	public Baraja(int tipobaraja, boolean barajar) {

		if (barajar == true) {
			switch (tipobaraja) {

			case 1:
				lista_cartas = new ArrayList<Carta>();
				for (int i = 1; i <= 40; i++) {
					lista_cartas.add(new Carta(i));
				}
				Barajar();
				break;

			case 2:
				lista_cartas = new ArrayList<Carta>();
				for (int j = 0; j < 2; j++) {
					for (int i = 1; i <= 40; i++) {
						lista_cartas.add(new Carta(i));
					}
					Barajar();
				}
				break;
			}
		} else {
			System.out.println("La baraja no se ha barajado");
		}
	}

	// Métodos

	public void Barajar() {
//		 ArrayList<Carta> nueva_baraja = new ArrayList<Carta>();
//		 
//		 for (Carta c : lista_cartas) {
//			 int num = (int) (Math.random()*lista_cartas.size()-1);
//			 
//			 nueva_baraja.add(num, c);
//			 lista_cartas.remove(num);
//		}
//		 

		Collections.shuffle(lista_cartas);

	}

	public void Cortar(int posicion) {

		for (int i = 0; i < posicion; i++) {
			lista_cartas.add(lista_cartas.get(0));
			lista_cartas.remove(0);
		}

	}
	
	public Carta Robar() {
		Carta a = lista_cartas.get(0);
		lista_cartas.remove(0);
		
		return a;
	}
	
	public void InsertaCartaFinal(int id_carta) {
		lista_cartas.add(new Carta(id_carta));
	}
	
	public void InsertarCartaPrincipio(int id_carta) {
		
		for (int i = 1; i <= 40; i++) {
			lista_cartas.add(0, new Carta(id_carta));
			lista_cartas.add(i, new Carta(i));
		}
		lista_cartas.add(0, new Carta(id_carta));
		
	}
	

	public void InsertaCartaFinal(Carta c) {
		lista_cartas.add(c);
	}
	
	public void InsertaCartaPrincipio(Carta c) {
		lista_cartas.add(0, c);
	}
	
	
	//Muestra el numero de cartas que quedan en la baraja
	public void getNumeroCartas() {
		System.out.println(lista_cartas.size());
		
	}
	
	public boolean isVacia() {
		if (lista_cartas.size() > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	
	// toString
}
