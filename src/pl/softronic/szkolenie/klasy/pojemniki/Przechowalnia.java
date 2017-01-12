package pl.softronic.szkolenie.klasy.pojemniki;

import java.util.ArrayList;
import java.util.List;

public abstract class Przechowalnia implements Pojemny {

	private List<Object> lista = new ArrayList<>();
	
	public abstract String getNazwaTypuPrzechowalni();
	
	@Override
	public void oproznij() {
		System.out.println("Opró¿nianie przechowalni typu " + getNazwaTypuPrzechowalni() + ".");
		lista.clear();
	}
	
	@Override
	public long zlicz() {
		return lista.size();
	}
	
	@Override
	public void wypisz() {
		System.out.println("Zawartoœæ przechowalni typu " + getNazwaTypuPrzechowalni() + ":");
		for(int q = 0; q<lista.size(); q++){
			Object qObj = lista.get(q);
			System.out.printf("%7d: %s\n", q, qObj );
		}
	}
	
	@Override
	public Object wyjmij(Object o) {
		if(lista.remove(o)){
			System.out.println("Z przechowalni typu " + getNazwaTypuPrzechowalni() + " wyjêto element " + o);
			return o;
		} else {
			System.out.println("Przechowalni typu " + getNazwaTypuPrzechowalni() + " nie zawiera elementu " + o);
			return null;
		}
	}
	
	
	public List<Object> getLista(){
		return lista;
	}

}
