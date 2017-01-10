package pl.softronic.szkolenie.klasy.geometria;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		//Punkt o = new Punkt(0,0);
		Object o = new Punkt(0,0);
		pisz(o);

	}
	
	static void pisz(String s){
		System.out.println(s);
	}
	
	static void pisz(Object obj){
		pisz(obj.toString());
	}
	
	static void pisz(Punkt p){
		System.out.println("to jest punkt");
	}

}
