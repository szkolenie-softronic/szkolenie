package pl.softronic.szkolenie.przyklady.db.model;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import pl.softronic.szkolenie.przyklady.serializacja.Dane;

public class User implements Serializable, Comparable<User>{
	private static final long serialVersionUID = 9073683165335813142L;

	private Dane daneOsobowe;
	private String username;
	private Set<Dokument> dokumenty = new TreeSet<>();
	private boolean isAdmin = false;
	
	public Dane getDaneOsobowe() {
		return daneOsobowe;
	}
	public void setDaneOsobowe(Dane daneOsobowe) {
		this.daneOsobowe = daneOsobowe;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Set<Dokument> getDokumenty() {
		return dokumenty;
	}
	public void setDokumenty(Set<Dokument> dokumenty) {
		this.dokumenty = dokumenty;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return username +"\t"+ dokumenty.size();
	}
	@Override
	public int compareTo(User o) {
		if(username==null){
			return -1;
		}
		if(o.username==null){
			return 1;
		}
		return username.toLowerCase().compareTo(o.username.toLowerCase());
	}
	
	
	
	
}
