package com.niit.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.DAO.UserDAO;
import com.niit.model.User;


	


	@Repository(value="userDAO")

	public  class UserImpl  implements UserDAO 
	
	{
		
			private static final Object UserName = null;
			private static final Object Password = null;
			@Autowired
			SessionFactory sessionFactory;
			public void addUser(User user) {

				Session session=sessionFactory.openSession();
		session.beginTransaction(); session.save(user);
		session.getTransaction().commit();
		session.close();
			
			}

			public void deleteUser(int uid) {

				Session session=sessionFactory.openSession();
		 session.beginTransaction(); 
		 User user=getUser(uid);
		
		session.delete(user);
		session.getTransaction().commit();
		session.close();
			
			}

			
			public void updateUser(User user) {

				Session session=sessionFactory.openSession();
		session.beginTransaction(); 
		

		
				session.update(user);
		session.getTransaction().commit();
		session.close();
		
			}

		

			@Override
			public User getUser(int UserID) {
				// TODO Auto-generated method stub
				Session session=sessionFactory.openSession();
				session.beginTransaction(); 
				

				
						User user=session.get(User.class,UserID);
				session.getTransaction().commit();
				session.close();
				return user;
			}

			@Override
			public boolean validateUser(String email, String password) {
				Session session=sessionFactory.openSession();
				boolean UserFound=false;
				String SQL_QUERY =" from User as o where o.EmailID=? and o.Password=?";
				Query query = session.createQuery(SQL_QUERY);
				query.setParameter(0,email);
				query.setParameter(1,password);
				List list = query.list();

				if ((list != null) && (list.size() > 0)) {
					UserFound= true;
				}

				session.close();
				return UserFound;
			}

			
	}
	
	
	


			
			

