package pl.softronic.szkolenie.klasy.pojemniki;

public class Niszczarka implements Pojemny {

	@Override
	public void wloz(Object o) {
		System.out.println("Wpad�o do niszczarki: "+ o);
	}

	@Override
	public void oproznij() {
		System.out.println("Nic si� nie sta�o. <<Twoja narodowo�� tutaj>>. Nic si� nie sta�o.");
	}

	@Override
	public long zlicz() {
		return 0;
	}

	@Override
	public void wypisz() {
		System.out.println("Niszczarka jest pusta!");
	}

	@Override
	public Object wyjmij(Object o) {
		System.out.println("Nie powiod�a si� pr�ba wyj�cia z niszczarki elementu: " + o);
		return null;
	}

}
