	package com.niit.DAOImpl;

	import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.DAO.ProductDAO;
import com.niit.model.Product;

	@Repository(value="productDAO")

	public class ProductImpl  implements ProductDAO 
	{
			@Autowired
			SessionFactory sessionFactory;

			@Override
			public void addProduct(Product product) {

				Session session=sessionFactory.openSession();
		session.beginTransaction(); session.save(product);
		session.getTransaction().commit();
		session.close();
			
			}
			
		
		
			@Override

			public Product getProduct(int ProductId) {

				Session session=sessionFactory.openSession();
		session.beginTransaction(); 
		Product p=session.get(Product.class, ProductId);
		session.getTransaction().commit();
		session.close();
		return p;
			
			
				
			}
			
			
			@Override

			public List<Product> getProducts()
			{
				Session session=sessionFactory.openSession();
				//session.beginTransaction();
				List<Product> plist=session.createQuery("from Product").getResultList();
				// TODO Auto-generated method stub
				session.close();

				return plist;
			}



		@Override
			public void updateProduct(Product Product) {
				
				System.out.println(Product.getProductID()+"-----------     "+Product.getProductName()+" --------------"+Product.getProductDesc());;
				Session session=sessionFactory.openSession();
		session.beginTransaction(); 
		session.update(Product);
		session.getTransaction().commit();
		session.close();
		
				
	
			}


			@Override
			public void deleteProduct(int ProductID) {
				Session session=sessionFactory.openSession();
				session.beginTransaction();
				Product p=session.get(Product.class, ProductID);
				//System.out.println(c.getProductID()+"_____________________________________________________________________________________________");
		         session.delete(p);

				session.getTransaction().commit();
				session.close();
					
			}




		
	
	}


