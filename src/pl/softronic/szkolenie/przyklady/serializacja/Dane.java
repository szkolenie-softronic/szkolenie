package pl.softronic.szkolenie.przyklady.serializacja;

import java.io.Serializable;

public class Dane implements Serializable {

	public static enum Plec {
		KOBIETA, MEZCZYZNA, NIE_WIEM, NIE_POWIEM, WSTYD_MI, CZESC_ROWEROWA
	}
	
	private static final long serialVersionUID = -86449414565996654L;

	private String imie;
	private String nazwisko;
	private int wiek;
	private Plec plec;
	
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public int getWiek() {
		return wiek;
	}
	public void setWiek(int wiek) {
		this.wiek = wiek;
	}
	public Plec getPlec() {
		return plec;
	}
	public void setPlec(Plec plec) {
		this.plec = plec;
	}
	
	public static class Builder {
		private Dane instance;
		
		public Builder(){
			instance = new Dane();
		}
		
		public Dane get(){
			return instance;
		}
		
		public Builder withImie(String imie){
			instance.setImie(imie);
			return this;
		}
		
		public Builder withNazwisko(String nazwisko){
			instance.setImie(nazwisko);
			return this;
		}
		
		public Builder withWiek(int wiek){
			instance.setWiek(wiek);
			return this;
		}
		
		public Builder withPlec(Plec plec){
			instance.setPlec(plec);
			return this;
		}
		
		
	}
}
