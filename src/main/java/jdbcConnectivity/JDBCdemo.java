package jdbcConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCdemo {

	public static void main(String[] args) {
		Studentdemo demo= new Studentdemo();
		Student s1= demo.getStudent(1);
		System.out.println(s1.fname);

	}
}
class Studentdemo{
	
	public Student getStudent(int rollno)
	{
		try {
			
		Student s= new Student();
		s.rollno= rollno;
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdemo2", "root", "vathsa123");
		    Statement st= con.createStatement();
			ResultSet rs = st.executeQuery("select fname  from students where rollno ="+rollno);
			rs.next();
			String name= rs.getString(1);
			s.fname = name;
		   // System.out.println(rs.getString("fname"));
		return s;
		}
		catch (Exception e) {
			
			System.out.println(e);
		}
		return null;
	}
}

class Student{
	int rollno;
	String fname;
	
}