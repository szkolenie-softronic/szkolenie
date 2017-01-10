package pl.softronic.szkolenie.klasy.dziedziczenie;

import pl.softronic.szkolenie.klasy.geometria.Punkt;

public abstract class ObiektFizyczny {
	
	private Punkt pozycja;
	private Wektor predkosc;
	
	public ObiektFizyczny(Punkt abc) {
		this.pozycja = abc;
		predkosc = new Wektor(0, 0);
	}

	public abstract String getNazwa();

	
	
}
