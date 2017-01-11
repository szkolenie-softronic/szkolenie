package pl.softronic.szkolenie.klasy.dziedziczenie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pl.softronic.szkolenie.klasy.geometria.Punkt;

public class Main {

	public static void main(String[] args) {

		List<ObiektFizyczny> tab = new ArrayList<>();
		tab.add( new Samochod("car", new Punkt(0, 0)) );
		tab.add( new PojazdSilnikowy("zabawka", new Punkt(0, 0)) );
		tab.add( new PojazdSilnikowy("robot", new Punkt(0, 0)) );
		tab.add( new Samochod("Maciek", new Punkt(0, 0)) );
		tab.add( new Samochod("Halina", new Punkt(0, 0)) );
		tab.add( new Samochod("Andrzej", new Punkt(0, 0)) );
		tab.add( new Samochod("Janusz", new Punkt(0, 0)) );
		
		
		
		Collections.sort(tab);
		
		for(ObiektFizyczny o : tab){
			System.out.println(o.getNazwa());
		}

		
		
	}


}
