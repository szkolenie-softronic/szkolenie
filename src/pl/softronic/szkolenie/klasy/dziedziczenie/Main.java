package pl.softronic.szkolenie.klasy.dziedziczenie;

import pl.softronic.szkolenie.klasy.geometria.Punkt;

public class Main {

	public static void main(String[] args) {
		
		ObiektFizyczny f = new Pojazd("£otr 1", new Punkt(100, -15634562346245635645624d));
		String nazwa = f.getNazwa();
		System.out.println(nazwa);
		
		Wektor w = new Wektor(10, 33);
		System.out.println(w);
	}

}
