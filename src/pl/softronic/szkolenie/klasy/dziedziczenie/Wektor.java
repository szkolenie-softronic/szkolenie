package pl.softronic.szkolenie.klasy.dziedziczenie;

import pl.softronic.szkolenie.klasy.geometria.Odcinek;
import pl.softronic.szkolenie.klasy.geometria.Punkt;

public class Wektor extends Punkt {

	public Wektor(double x, double y) {
		super(x, y);
	}
	
	public void dodaj(Wektor w){
		if(w == null){
			return;
		}
		setX(  w.getX() + getX()  );
		setY(  w.getY() + getY()  );
	}
	
	public double getDlugosc(){
		return 
			new Odcinek(this , new Punkt() )
				.getDlugosc();
	}
	
	public double getKat(){
		return Math.atan2( getY() , getX() );
	}
	
	public void setKat(double beta){
		double d = getDlugosc();
		setX(   d * Math.cos(beta)   );
		setY(   d * Math.sin(beta)   );
	}

	@Override
	public String toString() {
		return "Wektor [" + super.toString() + "]";
	}
	
	

	
	
}
