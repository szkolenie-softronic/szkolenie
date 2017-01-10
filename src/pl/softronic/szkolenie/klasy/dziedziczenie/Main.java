package pl.softronic.szkolenie.klasy.dziedziczenie;

import pl.softronic.szkolenie.klasy.geometria.Punkt;

public class Main {

	public static void main(String[] args) {
		
		PojazdSilnikowy zabawka = new PojazdSilnikowy("zabawka", new Punkt(100, 0));
		zabawka.setPredkosc(new Wektor(10, 0));
		zabawka.setPrzyspieszenie(new Wektor(-1, 0));
		
		System.out.println("Pozycja startowa");
		System.out.println(zabawka);
		
		for(int t=0; t<100; t++){
			zabawka.krok();
		}
		System.out.println("Pozycja koñcowa");
		System.out.println(zabawka);
		
	}

}
