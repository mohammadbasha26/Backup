	package com.niit.DAOImpl;

	import java.util.List;

import org.hibernate.Query;
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


			public List<Product> getProductsByCategory(int cid) {
				Session session=sessionFactory.openSession();
				/*List<Product> products =null;
				session.beginTransaction();
				Query q=session.createQuery("from product where categoryid=:categoryid"); 
				q.setParameter(":categoryid", cid);
				
			products=	q.getResultList();
			session.getTransaction().commit();
				 return products;*/
				
				
				List<Product> products =null;
				session.beginTransaction();
				products= session.createQuery("from Product where categoryID="+cid).list();   
				session.getTransaction().commit();
				return products;
			
			
			}
			
			public List<Product> getProductsBySupplier(int sid) {
				Session session=sessionFactory.openSession();
				List<Product> products =null;
				session.beginTransaction();
				products= session.createQuery("from Supplier where sid="+sid).list();   
				session.getTransaction().commit();
				 return products;
				}

		
	
	}


