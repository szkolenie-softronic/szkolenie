package pl.softronic.szkolenie.klasy.geometria;

import java.util.Locale;

/** Opis punktu
 *  */
public class Punkt {

	double x = 667;
	double y;
	

	public Punkt(double x, double y) {
		this.x = x;
		this.y = y;
	}



	/** Wypisuje informacje o punkcie na ekran 
	 *  */
	public void pisz(){
		System.out.printf(new Locale("PL"), 
				"Punkt p(%7.2f;%7.2f)", x, y);
	}
	
}
