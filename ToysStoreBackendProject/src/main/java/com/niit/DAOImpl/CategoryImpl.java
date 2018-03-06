package com.niit.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.DAO.CategoryDAO;
import com.niit.model.Category;
import com.niit.model.User;

@Repository(value="categoryDAO")
public class CategoryImpl implements CategoryDAO {
	@Autowired
	SessionFactory sessionFactory;
@Override
	public void addCategory(Category category) {

		Session session=sessionFactory.openSession();
session.beginTransaction(); session.save(category);
session.getTransaction().commit();
session.close();
	
	}
	
	@Override
	public void updateCategory(Category category) {
System.out.println(category.getCategoryID()+"-----------     "+category.getCategoryDesc()+" --------------"+category.getCategoryName());;
		Session session=sessionFactory.openSession();
session.beginTransaction(); 
session.update(category);
session.getTransaction().commit();
session.close();
	
	}
	
	
	public Category getCategory(int categoryId) {

		Session session=sessionFactory.openSession();
Category c=session.get(Category.class, categoryId);

session.close();
return c;
	
	}
	
	public List<Category> getCategories()
	{
		Session session=sessionFactory.openSession();
		//session.beginTransaction();
		List<Category> clist=session.createQuery("from Category").getResultList();
		// TODO Auto-generated method stub
		session.close();

		return clist;
	}
	
	

	@Override
	public void deleteCategory(int categoryID) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Category c=session.get(Category.class, categoryID);
		//System.out.println(c.getCategoryID()+"_____________________________________________________________________________________________");
         session.delete(c);

		session.getTransaction().commit();
		session.close();
			
	}

	
}