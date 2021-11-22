package School_Management_System.Controller;
import School_Management_System.Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Student_cont implements Student_I {

  @Override
  public void save(Student students) {
    try {
      Connection con = StudentDb.getConnection();
      String sql =
          "INSERT INTO info(s_name,std,s_div,roll,s_stream) VALUES (?,?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, students.Name());
      ps.setString(2, students.Std());
      ps.setInt(3, students.Div());
      ps.setInt(3, students.Roll());
      ps.setInt(3, students.Stream());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Saved!");
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(null, "Error");
    }
  }

  @Override
  public void update(Student students) {
    // TODO Auto-generated method stub
  }

  @Override
  public void delete(Student students) {
    // TODO Auto-generated method stub
  }

  @Override
  public Student get(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Student> list() {
    // TODO Auto-generated method stub
    return null;
  }
}
