package com.niit.ToysStoreBackendProject;


	
	
	
	
	
	import static org.junit.Assert.assertEquals;

	import org.junit.BeforeClass;
	import org.junit.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.AnnotationConfigApplicationContext;

	import com.niit.DAO.UserDAO;
	import com.niit.model.User;
	
	public class UserTestJunit {
		@Autowired
		static AnnotationConfigApplicationContext context;

		static UserDAO userDAO;

		// The above objects need to initialize
		/**
		 * This method is going execute before calling any one of test case and will
		 * execute only once
		 */
		@BeforeClass
		public static void initialize() {
			context = new AnnotationConfigApplicationContext();
			context.scan("com.niit");
			context.refresh();

			// get the userDAO from context
			userDAO = (UserDAO) context.getBean("userDAO");

			// get the user from context

		}

		@Test
		public void validateUser() {
boolean validate=userDAO.validateUser("basha", "basha"
		+ "");
System.out.println(validate+"------------------------------------------------------------");
assertEquals(true, validate);
		}

	}



