package pl.softronic.szkolenie.klasy.dziedziczenie;

import pl.softronic.szkolenie.klasy.geometria.Punkt;

public class Main {

	public static void main(String[] args) {
		
		Wektor w = new Wektor(10, 00);

		System.out.println("Wartoœci inicjalne");
		System.out.println("dl  " + w.getDlugosc());
		System.out.println("k¹t " + w.getKat() * 180/Math.PI );
		
		w.setKat(45  *  Math.PI/180);
		System.out.println("Po zmianie k¹ta");
		
		System.out.println("dl  " + w.getDlugosc());
		System.out.println("k¹t " + w.getKat() * 180/Math.PI );
		System.out.println("Rad " + w.getKat() );
		System.out.println(w);
	}

}
