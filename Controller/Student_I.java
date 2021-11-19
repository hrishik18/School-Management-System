package School_Management_System.Controller;
import java.util.List;

import School_Management_System.Model.Student;

public interface Student_I {

  public void save(Student students);
  public void update(Student students);
  public void delete(Student students);
  public Student get(int id);
  public List<Student> list();
}