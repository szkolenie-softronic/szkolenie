package pl.softronic.szkolenie.klasy.pojemniki;

public class Szufladka implements Pojemny {
	
	private Object zawartosc = null;

	@Override
	public void wloz(Object o) {
		System.out.println("Wciskam do szufladki: "+ o);
		if(zawartosc == null){
			zawartosc = o;
		} else {
			System.out.println("Wciskanie nie powiod�o si�, bo w szufladce jest ju�: "+ zawartosc);
		}
	}

	@Override
	public void oproznij() {
		zawartosc = null;
	}

	@Override
	public long zlicz() {
		return (zawartosc == null) ? 0 : 1 ;
	}

	@Override
	public void wypisz() {
		if(zawartosc == null){
			System.out.println("Szufladka jest pusta!");
		} else {
			System.out.println("Zawarto�� szufladki:");
			System.out.println(zawartosc);
		}
	}

	@Override
	public Object wyjmij(Object o) {
		if(zawartosc == o){
			zawartosc = null;
			System.out.println("Z szufladki wyj�to element: " + o);
			return o;
		} else {
			System.out.println("Nie powiod�a si� pr�ba wyj�cia z szufladki elementu: " + o);
			return null;
		}
	}

}
