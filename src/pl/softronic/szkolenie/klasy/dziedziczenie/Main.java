package pl.softronic.szkolenie.klasy.dziedziczenie;

import pl.softronic.szkolenie.klasy.geometria.Punkt;

public class Main {

	public static void main(String[] args) {

		ObiektFizyczny[] tab = new ObiektFizyczny[3];
		tab[0] = new Samochod("car", new Punkt(10, 23));
		tab[1] = new Pojazd("zabawka", new Punkt(30, 12));
		tab[2] = new PojazdSilnikowy("robot", new Punkt(15, 11));
		
		for(Object o : tab){
			System.out.println("Obiekt klasy " + o.getClass().getSimpleName());
			if(o instanceof Przyspieszalny){
				System.out.println("   Jest przyspieszalny.");
				
				Przyspieszalny p = (Przyspieszalny)o;
				p.przyspiesz(100);
				
			}
		}
		
//		Przyspieszalny p = new Rakieta();
//		p.przyspiesz(1);
//		
//		p = (Samochod)tab[0];
//		p.przyspiesz(1);
		
		
	}


}
