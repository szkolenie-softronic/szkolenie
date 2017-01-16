package pl.softronic.szkolenie.przyklady.db.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Dokument implements Serializable, Comparable<Dokument> {
	private static final long serialVersionUID = 3603214016468395083L;
	
	final private static Object TYTUL = new Object();
	final private static Object TRESC = new Object();
	final private static Object AUTOR  = new Object();

	private Map<Object, Object> pola = new HashMap<>();
	
	public String getTytul() {
		return (String)pola.get(TYTUL);
	}
	public void setTytul(String tytul) {
		pola.put(TYTUL, tytul);
	}
	public String getTresc() {
		return (String)pola.get(TRESC);
	}
	public void setTresc(String tresc) {
		pola.put(TRESC, tresc);
	}
	public User getAutor() {
		return (User)pola.get(AUTOR);
	}
	public void setAutor(User autor) {
		pola.put(AUTOR, autor);
	}

	@Override
	public String toString() {
		return getTytul() +"\t"+ (getTresc()==null ? "" : getTresc().length());
	}
	
	@Override public int compareTo(Dokument o) {
		if(getTytul()==null){
			return -1;
		}
		if(o.getTytul()==null){
			return 1;
		}
		return getTytul().toLowerCase().compareTo(o.getTytul().toLowerCase());
	}
	
	
}
