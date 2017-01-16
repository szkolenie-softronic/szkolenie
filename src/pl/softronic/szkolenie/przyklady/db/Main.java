package pl.softronic.szkolenie.przyklady.db;

import pl.softronic.szkolenie.przyklady.db.model.User;
import pl.softronic.szkolenie.przyklady.db.service.UserDAO;

public class Main {

	public static void main(String[] args) {
		System.out.println("Start");
		
		UserDAO.load();
		
		User u = UserDAO.getByUsername(UserDAO.ADMIN_USERNAME);
		System.out.println(u);
		
		UserDAO.save();
		
		System.out.println("End.");
	}

}
