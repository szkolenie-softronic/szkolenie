package pl.softronic.szkolenie.klasy.dziedziczenie;

import pl.softronic.szkolenie.klasy.geometria.Punkt;

public abstract class ObiektFizyczny implements Comparable<ObiektFizyczny>{
	
	private Wektor pozycja;
	private Wektor predkosc;
	
	public ObiektFizyczny(Punkt pozycja) {
		this.pozycja = new Wektor(pozycja.getX(), pozycja.getY());
		predkosc = new Wektor(0, 0);
	}

	public abstract String getNazwa();

	public void krok(){
		pozycja.dodaj(predkosc);
	}
	
	
	public Punkt getPozycja() {
		return pozycja;
	}

	public void setPozycja(Punkt pozycja) {
		this.pozycja = new Wektor(pozycja.getX(), pozycja.getY());
	}

	public Wektor getPredkosc() {
		return predkosc;
	}

	public void setPredkosc(Wektor predkosc) {
		this.predkosc = predkosc;
	}

	@Override
	public String toString(){
		return    "pos:     " + pozycja + "\n"
				+ "v:       " + predkosc + "\n";
	}
	
//	@Override
//	public int compareTo(ObiektFizyczny b){
//		return (int)(getPozycja().getX()
//	              -b.getPozycja().getX());
//	}
	
	@Override
	public int compareTo(ObiektFizyczny b){
		Double pierwszy =   getPozycja().getX();
		Double drugi    = b.getPozycja().getX();
		return pierwszy.compareTo(drugi);
	}
	
}
