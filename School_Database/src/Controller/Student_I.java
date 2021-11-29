package Controller;
import java.util.List;

import Model.Student;

public interface Student_I {

  public void save(Student students);
  public void update(Student students);
  public void delete(Student students);
  public List<Student> list();
}