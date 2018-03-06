package com.niit.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.DAO.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Repository(value="supplierDAO")

public class SupplierImpl implements SupplierDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void addSupplier(Supplier  supplier)
	
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();session.save(supplier);
		session.getTransaction().commit();
		session.close();
	}
	public void deleteSupplier(Supplier supplier) {

		Session session=sessionFactory.openSession();
session.beginTransaction(); session.delete(supplier);
session.getTransaction().commit();
session.close();
	}

	
	
	
	public Supplier getSupplier(int SupplierId) {

		Session session=sessionFactory.openSession();
session.beginTransaction(); 
Supplier s=session.get(Supplier.class, SupplierId);
session.getTransaction().commit();
session.close();
return s;
	
	}
	public List<Supplier> getSuppliers()
	{
		Session session=sessionFactory.openSession();
		//session.beginTransaction();
		List<Supplier> slist=session.createQuery("from Supplier").getResultList();
		// TODO Auto-generated method stub
		session.close();

		return slist;
	}
	@Override
	public void deleteSupplier(int SupplierID) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Supplier s=session.get(Supplier.class, SupplierID);
		
         session.delete(s);

		session.getTransaction().commit();
		session.close();
			
	}

	@Override
		public void updateSupplier(Supplier Supplier) {
			
			System.out.println(Supplier.getSupplierID()+"-----------     "+Supplier.getSupplierName());
			Session session=sessionFactory.openSession();
	session.beginTransaction(); 
	session.update(Supplier);
	session.getTransaction().commit();
	session.close();
	
			

		}

}	




	
	


