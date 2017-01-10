package pl.softronic.szkolenie.klasy.dziedziczenie;

import pl.softronic.szkolenie.klasy.geometria.Punkt;

public class Pojazd extends ObiektFizyczny {

	private String nazwa;
	
	public Pojazd(String nazwa, Punkt pozycja) {
		super(pozycja);
		this.nazwa = nazwa;
	}
	
	
	@Override
	public String getNazwa() {
		return nazwa;
	}

}
