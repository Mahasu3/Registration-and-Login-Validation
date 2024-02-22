
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintDatabase {

	
        static void results(ResultSet result) {
        	
        	
       //displaying results
        	try {
				while(result.next()==true) {
					
				 
					System.out.println(result.getString("gmail")+result.getString("password")+result.getString("name"));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
        	
        	
        }
	

}
