package pl.softronic.szkolenie.klasy.geometria;

public class Odcinek {

	Punkt a;
	Punkt b;
	
	public Odcinek() {}

	public Odcinek(Punkt a, Punkt b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	public Odcinek(double ax, double ay, double bx, double by) {
		a = new Punkt(ax, ay);
		b = new Punkt(bx, by);
	}
	
	public double dlugosc(){
		double result = Math.sqrt( (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y) );
		return result;
	}
	
	
}
