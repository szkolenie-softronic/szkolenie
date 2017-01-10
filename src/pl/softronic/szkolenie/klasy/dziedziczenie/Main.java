package pl.softronic.szkolenie.klasy.dziedziczenie;

import pl.softronic.szkolenie.klasy.geometria.Punkt;

public class Main {

	public static void main(String[] args) {
		
		Samochod a = new Samochod("szybki", new Punkt(0, 0));
		a.setPredkosc(new Wektor(100, 0));
		
		Samochod b = new Samochod("wolny", new Punkt(0, 0));
		b.setPrzyspieszenie(new Wektor(4, 0));
		
		System.out.println("Pozycja startowa");
		System.out.println(a);
		System.out.println(b);
		
		int t=0;
		do {
			a.krok();
			b.krok();
			t++;
		} while( b.getPozycja().getX() <= a.getPozycja().getX() );
		
		System.out.println("Pozycja koñcowa   t="+t);
		System.out.println(a);
		System.out.println(b);
		
	}

}
