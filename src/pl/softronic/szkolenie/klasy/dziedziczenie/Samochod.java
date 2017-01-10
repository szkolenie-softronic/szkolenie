package pl.softronic.szkolenie.klasy.dziedziczenie;

import pl.softronic.szkolenie.klasy.geometria.Punkt;

public class Samochod extends PojazdSilnikowy {

	private double skret;
	
	public Samochod(String nazwa, Punkt pozycja) {
		super(nazwa, pozycja);
		skret = 0;
	}
	
	@Override
	public void krok(){
		obroc(   getPredkosc()         );	
		obroc(   getPrzyspieszenie()   );
				
		super.krok();
	}

	private void obroc(Wektor w) {
		double kat = w.getKat();
		w.setKat(  kat + skret );
	}

	public double getSkret() {
		return skret;
	}

	public void setSkret(double skret) {
		this.skret = skret;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n"
				+"skrêt:   " + skret;
	}

}
