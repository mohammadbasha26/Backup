package com.niit.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

import com.niit.DAO.CategoryDAO;
import com.niit.DAO.ProductDAO;
import com.niit.DAO.SupplierDAO;
import com.niit.DAOImpl.CategoryImpl;
import com.niit.DAOImpl.ProductImpl;
import com.niit.DAOImpl.SupplierImpl;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;

@Configuration
@ComponentScan(basePackages = { "com.niit" })

public class DBConfig {
	@Bean

	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/Basha");
		dataSource.setUsername("sa");
		dataSource.setPassword("");

		System.out.println("Data Source Created");
		return dataSource;
	}

	@Bean(value = "sessionFactory")
	public SessionFactory getSessionFactory() {

		Properties hibernateProp = new Properties();

		hibernateProp.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

		LocalSessionFactoryBuilder factoryBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
		factoryBuilder.addAnnotatedClass(Category.class);
		factoryBuilder.addAnnotatedClass(Product.class);
		factoryBuilder.addAnnotatedClass(User.class);
		factoryBuilder.addAnnotatedClasses(Supplier.class);
		factoryBuilder.addProperties(hibernateProp);

		System.out.println("Creating SessionFactory Bean");
		return factoryBuilder.buildSessionFactory();
	}

	@Bean(name = "categoryDAO")
	public CategoryDAO getCategoryDAO() {
		System.out.println("----DAO Implementation---");
		return new CategoryImpl();
	}

	@Bean(name = "productDAO")
	public ProductDAO getProductDAO() {
		System.out.println("----DAO Implementation---");
		return new ProductImpl();
	}

	@Bean(name = "supplierDAO")
	public SupplierDAO getSupplierDAO() {
		System.out.println("----DAO Implementation---");
		return new SupplierImpl();
	}

	@Bean(name = "txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		System.out.println("---Transaction Manager----");
		return new HibernateTransactionManager(sessionFactory);
	}

}
