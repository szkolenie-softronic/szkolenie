package pl.softronic.szkolenie.klasy.pojemniki;

import java.util.ArrayList;
import java.util.List;

public abstract class Przechowalnia implements Pojemny {

	private List<Object> lista = new ArrayList<>();
	
	public abstract String getNazwaTypuPrzechowalni();
	
	@Override
	public void wloz(Object o) {
		System.out.println("Do przechowalni "+ getNazwa() + " wk�adam " + o);
		lista.add(o);
	}
	
	@Override
	public void oproznij() {
		System.out.println("Opr�nianie przechowalni " + getNazwa() + ".");
		lista.clear();
	}
	
	@Override
	public long zlicz() {
		return lista.size();
	}
	
	@Override
	public void wypisz() {
		System.out.println("Zawarto�� przechowalni " + getNazwa() + ":");
		for(int q = 0; q<lista.size(); q++){
			Object qObj = lista.get(q);
			System.out.printf("%7d: %s\n", q+1, qObj );
		}
	}
	
	@Override
	public Object wyjmij(Object o) {
		if(lista.remove(o)){
			System.out.println("Z przechowalni " + getNazwa() + " wyj�to element " + o);
			return o;
		} else {
			System.out.println("Przechowalni " + getNazwa() + " nie zawiera elementu " + o);
			return null;
		}
	}
	
	private String getNazwa(){
		return "typu " + getNazwaTypuPrzechowalni();
	}
	
	public List<Object> getLista(){
		return lista;
	}

}
