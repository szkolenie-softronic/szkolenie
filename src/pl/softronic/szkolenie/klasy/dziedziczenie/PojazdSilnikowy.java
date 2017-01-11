package pl.softronic.szkolenie.klasy.dziedziczenie;

import pl.softronic.szkolenie.klasy.geometria.Punkt;

public class PojazdSilnikowy extends Pojazd implements Przyspieszalny {
	
	private Wektor przyspieszenie;

	public PojazdSilnikowy(String nazwa, Punkt pozycja) {
		super(nazwa, pozycja);
		przyspieszenie = new Wektor(0, 0);
	}
	
	public PojazdSilnikowy(String nazwa, Punkt pozycja, Wektor przyspieszenie) {
		this(nazwa, pozycja);
		this.przyspieszenie = przyspieszenie;
	}
	
	@Override
	public void krok(){
		if(przyspieszenie!=null){
			getPredkosc().dodaj(przyspieszenie);
		}
		super.krok();
	}
	

	public Wektor getPrzyspieszenie() {
		return przyspieszenie;
	}

	public void setPrzyspieszenie(Wektor przyspieszenie) {
		this.przyspieszenie = przyspieszenie;
	}

	@Override
	public String toString() {
		return super.toString()
				+"a:       " + przyspieszenie;
	}

	@Override
	public void przyspiesz(double x) {
		System.out.println("Pojazd silnikowy chcemy przyspieszyæ o: "+x);
		
	}

	
	
}
