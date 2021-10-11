package jdbcConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class jdbcdemo2 {
	public static void main(String[] arge) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/demojdbc", "root", "vathsa123");
	    Statement st= con.createStatement();
	    ResultSet rs = st.executeQuery("select * from credentials where cardname='credit'");
	    rs.next();
	    System.out.println(rs.getString("username"));
	    System.out.println(rs.getString("password"));
	    con.close();

	    
	}

}
