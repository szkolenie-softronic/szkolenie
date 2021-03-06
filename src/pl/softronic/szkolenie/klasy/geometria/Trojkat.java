package pl.softronic.szkolenie.klasy.geometria;

public class Trojkat {

	private Punkt a;
	private Punkt b;
	private Punkt c;
	
	public Trojkat() {
	}

	public Trojkat(Punkt a, Punkt b, Punkt c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double getObwod(){
		double result =0;
		Odcinek ab = new Odcinek(a, b);
		Odcinek ac = new Odcinek(a, c);
		Odcinek bc = new Odcinek(b, c);
		result += ab.getDlugosc();
		result += ac.getDlugosc();
		result += bc.getDlugosc();
		return result;
	}
	
	public double getPole(){
		double result =0;
		result += a.getX() * (b.getY() - c.getY());
		result += b.getX() * (c.getY() - a.getY());
		result += c.getX() * (a.getY() - b.getY());
		result /= 2;
		result = Math.abs(result);
		return result;
	}
	

	public Punkt getA() {
		return a;
	}

	public void setA(Punkt a) {
		this.a = a;
	}

	public Punkt getB() {
		return b;
	}

	public void setB(Punkt b) {
		this.b = b;
	}

	public Punkt getC() {
		return c;
	}

	public void setC(Punkt c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Trojkat [\n\ta = " + a + ", \n\tb = " + b + ", \n\tc = " + c + "\n]";
	}
	
	
	
	
	
}
