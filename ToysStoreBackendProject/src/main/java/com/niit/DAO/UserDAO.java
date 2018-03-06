package com.niit.DAO;

import com.niit.model.User;



public interface UserDAO {
		public void addUser (User  user);
		public void deleteUser  (int UserID);	
		public void updateUser  (User  user);	
		public User getUser  (int  UserID);	

		public boolean validateUser(String email,String password);

}
