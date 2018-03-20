	package com.niit.model;

	import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;



	@Entity
	@Table
	public class Product {
		


			@Id
			@GeneratedValue
			private int ProductID;
			private String  ProductName;
			private int  ProductPrice;
			
			@Lob
			private String  ProductDesc;
			private int  ProductInStock;
			
			
			@ManyToOne(fetch=FetchType.EAGER)
			@JoinColumn(name="categoryID")
		    private Category category;
			private String imgName;	

			

			@ManyToOne
			@JoinColumn(name="SupplierID")
			private Supplier supplier;
			
		

			public String getImgName() {
				return imgName;
			}
			public void setImgName(String imgName) {
				this.imgName = imgName;
			}
			public int getProductID() {
				return ProductID;
			}
			public void setProductID(int productID) {
				ProductID = productID;
			}
			public String getProductName() {
				return ProductName;
			}
			public void setProductName(String productName) {
				ProductName = productName;
			}
			public String getProductDesc() {
				return ProductDesc;
			}
			public void setProductDesc(String productDesc) {
				ProductDesc = productDesc;
			}
			public int getProductPrice() {
				return ProductPrice;
			}
			public void setProductPrice(int productPrice) {
				ProductPrice = productPrice;
			}
			public int getProductInStock() {
				return ProductInStock;
			}
			public void setProductInStock(int productInStock) {
				ProductInStock = productInStock;
			}
			public Category getCategory() {
				return category;
			}
			public void setCategory(Category category) {
				this.category = category;
			}
			public Supplier getSupplier() {
				return supplier;
			}
			public void setSupplier(Supplier supplier) {
				this.supplier = supplier;
			}
			@Override
			public String toString() {
				return "Product [ProductID=" + ProductID + ", ProductName=" + ProductName + ", ProductPrice="
						+ ProductPrice + ", ProductDesc=" + ProductDesc + ", ProductInStock=" + ProductInStock
						+ ", category=" + category + ", imgName=" + imgName + ", supplier=" + supplier + "]";
			}
		
			
			
			

	}


