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
		return "Trojkat [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	
	
	
	
	
}
