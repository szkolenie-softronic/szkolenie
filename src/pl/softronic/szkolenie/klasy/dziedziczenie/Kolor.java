package pl.softronic.szkolenie.klasy.dziedziczenie;

public enum Kolor {

	BIALY     (255, 255, 255), 
	CZARNY    (  0,   0,   0),
	
	CZERWONY  (255,   0,   0),
	ZIELONY   (  0, 255,   0),
	NIEBIESKI (  0,   0, 255),
	
	ZOLTY     (255, 255,   0),
	SELEDYN   (  0, 255, 255),
	FIOLETOWY (255,   0, 255);
	
	private final int r, g, b;
	
	private Kolor(int r, int g, int b){
		this.r =  r;
		this.g =  g;
		this.b =  b;
	}
	
	public String getNazwa(){
		String name = name();
		String n = name.substring(1);
		n = n.toLowerCase();
		n = name.charAt(0) + n;
		return n;
	}

	public int getR() {
		return r;
	}

	public int getG() {
		return g;
	}

	public int getB() {
		return b;
	}

	
	
	
	
}
