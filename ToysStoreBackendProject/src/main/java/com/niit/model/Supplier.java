package com.niit.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Supplier {
	

		


			@Id
			@GeneratedValue
			private int SupplierID;
			private String SupplierName;
			private int   SupplierMobileNO;
			private String SupplierAddress;
			
		
			@OneToMany(targetEntity=Product.class,fetch=FetchType.EAGER,mappedBy="supplier")
			private Set<Product> product= new HashSet<Product>(0);

			
			

			
			
			public Set<Product> getProduct() {
				return product;
			}
			public void setProduct(Set<Product> product) {
				this.product = product;
			}
			public int getSupplierID() {
				return SupplierID;
			}
			public void setSupplierID(int supplierID) {
				SupplierID = supplierID;
			}
			public String getSupplierName() {
				return SupplierName;
			}
			public void setSupplierName(String supplierName) {
				SupplierName = supplierName;
			}
			public int getSupplierMobileNO() {
				return SupplierMobileNO;
			}
			public void setSupplierMobileNO(int supplierMobileNO) {
				SupplierMobileNO = supplierMobileNO;
			}
			public String getSupplierAddress() {
				return SupplierAddress;
			}
			public void setSupplierAddress(String supplierAddress) {
				SupplierAddress = supplierAddress;
			}
		
			

}
