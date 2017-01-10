package pl.softronic.szkolenie.klasy.geometria;

import java.util.Locale;

/** Opis punktu
 *  */
public class Punkt {

	private double x;
	private double y;

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

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	
	
}
