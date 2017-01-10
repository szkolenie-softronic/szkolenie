package pl.softronic.szkolenie.klasy.dziedziczenie;

import pl.softronic.szkolenie.klasy.geometria.Punkt;

public class Main {

	public static void main(String[] args) {
		
		Pojazd zabawka = new PojazdSilnikowy("zabawka", new Punkt(100, 0));
		zabawka.setPredkosc(new Wektor(10, 0));
		
		System.out.println("Pozycja startowa");
		System.out.println(zabawka);
		
		zabawka.krok();
		
		System.out.println("Pozycja koñcowa");
		System.out.println(zabawka);
		
	}

}
