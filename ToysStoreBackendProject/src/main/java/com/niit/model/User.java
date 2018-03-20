	package com.niit.model;

	import javax.persistence.Column;
import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.Table;



	@Entity
	@Table
	public class User {
		


			@Id
			@GeneratedValue
			private int UserID;
			private String  UserName;
			
			@Column(unique=true)
			private String EmailID;
			private String  Password;
			private String  gender;
			private String  role;
			private int  MobileNO;
			private String  UserAddress;
			
			
			
			
			public String getRole() {
				return role;
			}
			public void setRole(String role) {
				this.role = role;
			}
			public String getEmailID() {
				return EmailID;
			}
			public void setEmailID(String emailID) {
				EmailID = emailID;
			}
			public String getGender() {
				return gender;
			}
			public void setGender(String gender) {
				this.gender = gender;
			}
		
			
			public int getUserID() {
				return UserID;
			}
			public void setUserID(int userID) {
				UserID = userID;
			}
			public String getUserName() {
				return UserName;
			}
			public void setUserName(String userName) {
				UserName = userName;
			}
			public String getPassword() {
				return Password;
			}
			public void setPassword(String password) {
				Password = password;
			}
			public int getMobileNO() {
				return MobileNO;
			}
			public void setMobileNO(int mobileNO) {
				MobileNO = mobileNO;
			}
			public String getUserAddress() {
				return UserAddress;
			}
			public void setUserAddress(String userAddress) {
				UserAddress = userAddress;
			}
			
			
			

}
