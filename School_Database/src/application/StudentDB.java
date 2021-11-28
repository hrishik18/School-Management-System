package application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;

public class StudentDB {

 public static Connection getConnection() {
   // Connection getConnection()
   try {

     Class.forName("com.mysql.jdbc.Driver");
     // com.mysql.cj.jdbc.driver
     // com.mysql.jdbc.Driver
     Connection con = DriverManager.getConnection(
         "jdbc:mysql://localhost:3306/school_db?characterEncoding=latin1&useConfigs=maxPerformance",
         "root", "");

     Statement stmt = con.createStatement();

     ResultSet rs = stmt.executeQuery("select * from info");

     while (rs.next())
     return con;

   } catch (Exception e) {
     System.out.println(e);
   }
  return null;
   
 }
 
 public static ObservableList<Student>getDatausers(){
	 Connection con=StudentDB.getConnection();
	ObservableList<Student> list = FXCollections.observableArrayList();
	try {
		PreparedStatement ps = con.prepareStatement("select * from info");
        ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		list.add(new Student(rs.getString("id"),rs.getString("s_name"),rs.getString("std"),rs.getString("s_div"),rs.getString("roll"),rs.getString("s_stream")));
	}
	}
	catch(Exception e) {
	}
		
	return list;
		
	}
}
