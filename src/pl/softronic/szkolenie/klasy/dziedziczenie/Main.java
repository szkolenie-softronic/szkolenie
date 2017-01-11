package pl.softronic.szkolenie.klasy.dziedziczenie;

import pl.softronic.szkolenie.klasy.geometria.Punkt;

public class Main {

	public static void main(String[] args) {

		ObiektFizyczny[] tab = new ObiektFizyczny[3];
		tab[0] = new Samochod("car", new Punkt(10, 23));
		tab[1] = new Pojazd("zabawka", new Punkt(30, 12));
		tab[2] = new PojazdSilnikowy("robot", new Punkt(15, 11));
		
		tab[0].setPredkosc(new Wektor(-1, -2.3));
		tab[1].setPredkosc(new Wektor(-3, -1.2));
		tab[2].setPredkosc(new Wektor(-1.5, -1.1));
		
		if(tab[0] instanceof Pojazd){
			((Samochod)tab[0]).setSkret(Math.PI / 30);
		}
		if(tab[2] instanceof PojazdSilnikowy){
			((PojazdSilnikowy)tab[2]).setPrzyspieszenie(new Wektor(0.1, 0));
		}
		
		for(ObiektFizyczny o : tab){
			for(int i=0; i<10; i++){
				o.krok();
			}
		}
		for(ObiektFizyczny o : tab){
			System.out.println(o);
		}
	}


}
