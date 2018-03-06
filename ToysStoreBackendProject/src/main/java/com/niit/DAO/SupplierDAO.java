package com.niit.DAO;

import java.util.List;

import com.niit.model.Supplier;




public interface SupplierDAO {
	
	public void addSupplier ( Supplier supplier);
	public void deleteSupplier (int SupplierID);	
	public void updateSupplier (Supplier SupplierID);	
	public Supplier getSupplier (int SupplierID);
	
	public List<Supplier>getSuppliers();

		
	}


