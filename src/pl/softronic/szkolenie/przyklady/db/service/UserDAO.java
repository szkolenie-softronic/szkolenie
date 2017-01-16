package pl.softronic.szkolenie.przyklady.db.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;
import java.util.TreeSet;

import pl.softronic.szkolenie.przyklady.db.model.User;

public class UserDAO {
	
	public static final String ADMIN_USERNAME = "admin";
	private static final File plik = new File("db.dat");
	private static Set<User> db = new TreeSet<>();
	
	public static void save(){
		try {
			FileOutputStream fos = new FileOutputStream(plik);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(db);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(3);
		}
	}
	
	/** loading and preparing database */
	public static void load(){
		if(plik.exists()){
			if(plik.isDirectory()){
				System.out.println(plik.getAbsolutePath() + " jest katalogiem!");
				System.exit(1);
			}
			//plik istnieje i jest poprawny
			try {
				FileInputStream fis = new FileInputStream(plik);
				ObjectInputStream ois = new ObjectInputStream(fis);
				db = (Set<User>)ois.readObject();
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(2);
			}
		} 
		validateThenCreateAdmin();
	}
	
	private static void validateThenCreateAdmin(){
		boolean hasAdmin = false;
		for(User u : db){
			if(ADMIN_USERNAME.equals(u.getUsername())) {
				hasAdmin = true;
				break;
			}
		}
		if(!hasAdmin){
			User admin = new User();
			admin.setUsername(ADMIN_USERNAME);
			admin.setAdmin(true);
			db.add(admin);
		}
	}
	
	public static Set<User> getDb() {
		return db;
	}
	
	public static User getByUsername(String name){
		for(User u : db){
			if(name.equals(u.getUsername())) {
				return u;
			}
		}
		return null;
	}

}
