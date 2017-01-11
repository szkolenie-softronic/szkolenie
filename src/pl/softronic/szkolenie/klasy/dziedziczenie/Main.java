package pl.softronic.szkolenie.klasy.dziedziczenie;

import pl.softronic.szkolenie.klasy.geometria.Punkt;

public class Main {

	public static void main(String[] args) {
	
		
		Object a = new PojazdSilnikowy("szybki", new Punkt(0, 0));
		
		coTo(a);
		
		
	}
	
	public static void coTo(Object jakisObiekt){
		if(jakisObiekt instanceof Object){
			System.out.println("jest to Object");
		}
		if(jakisObiekt instanceof ObiektFizyczny){
			System.out.println("jest to ObiektFizyczny");
		}
		if(jakisObiekt instanceof Pojazd){
			System.out.println("jest to Pojazd");
		}
		if(jakisObiekt instanceof PojazdSilnikowy){
			System.out.println("jest to PojazdSilnikowy");
			if(jakisObiekt instanceof Samochod){
				System.out.println("jest to Samochod");
			}
		}
		
	}

}
