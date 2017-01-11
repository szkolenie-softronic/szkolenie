package pl.softronic.szkolenie.klasy.dziedziczenie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pl.softronic.szkolenie.klasy.geometria.Punkt;

public class Main {

	public static void main(String[] args) {

		List<ObiektFizyczny> tab = new ArrayList<>();
		tab.add( new Samochod("car", new Punkt(56, 0), new Wektor(1, 0)) );
		tab.add( new PojazdSilnikowy("zabawka", new Punkt(34, 0), new Wektor(2, 0)) );
		tab.add( new PojazdSilnikowy("robot", new Punkt(22, 0), new Wektor(3, 0)) );
		tab.add( new Samochod("Maciek", new Punkt(45, 0), new Wektor(4, 0)) );
		tab.add( new Samochod("Halina", new Punkt(11, 0), new Wektor(5, 0)) );
		tab.add( new Samochod("Andrzej", new Punkt(2, 0), new Wektor(6, 0)) );
		tab.add( new Samochod("Janusz", new Punkt(1, 0), new Wektor(7, 0)) );
		
		for(ObiektFizyczny o : tab){
			for(int t=0; t<10; t++){
				o.krok();
			}
		}
		
		Collections.sort(tab);
		
		for(ObiektFizyczny o : tab){
			System.out.println(o.getPozycja().getX() +" "
							      + o.getNazwa());
		}

		
		
	}


}
