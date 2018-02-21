package net.viralpatel.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.Types;

public class LoginAction extends ActionSupport {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	data.User user;
    public data.User getUser() {
        return user;
    }
    public void setUser(data.User user) {
        this.user = user;
    }
    public String execute(){
    		Connection conn = null;

        try {
           String URL = "jdbc:mysql://localhost/Person";
        		//String URL = "jdbc:mysql://173.91.115.247:3306/Person";
           Class.forName("com.mysql.jdbc.Driver");
           conn = DriverManager.getConnection(URL, "root", "root");
           for(data.Person person: user.getPersons()) {
        	   	  String sql = "INSERT INTO Person.Person (id, last_name, first_name, email, created, modified, archived, creted_by, modified_by, archived_by)\r\n";
              sql += "VALUES (?, ?, ?, ?, ?, ?, ?, 'admin', ?, ?) ";
              sql += "ON DUPLICATE KEY UPDATE " +
            		  	"last_name = ?, first_name = ?, email = ?, "
                              + "modified = ?, archived = ?, modified_by = 'admin', archived_by = 'admin'";
        
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setInt(1, person.getId());
               ps.setString(2, person.getLast_name());
               ps.setString(3, person.getFirst_name());
               ps.setString(4, person.getEmail());
               
               //Calendar calendar = Calendar.getInstance();
               Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
               
               ps.setTimestamp(5, currentTimestamp);
               ps.setNull(6, Types.TIMESTAMP);
               ps.setNull(7, Types.TIMESTAMP);
              
               ps.setNull(8, Types.VARCHAR);
               ps.setNull(9, Types.VARCHAR);
               
               ps.setString(10, person.getLast_name());
               ps.setString(11, person.getFirst_name());
               ps.setString(12, person.getEmail());
               ps.setTimestamp(13, currentTimestamp);
               ps.setTimestamp(14, currentTimestamp);
               
               
               ps.executeUpdate();
               ps.close();
           }
  
        } catch (Exception e) {
           System.out.println(e);
        } finally {
           if (conn != null) {
              try {
                 conn.close();
              } catch (Exception e) {
              }
           }
        }
        return "success";
    }

}

