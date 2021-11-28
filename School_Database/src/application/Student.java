package application;

public class Student {
  private String id;
  private String s_name;
  private String std;
  private String s_div;
  private String roll;
  private String s_stream;

  public String Id() { return id; }

  public void Id(String id) { this.id = id; }

  public String Name() { return s_name; }

  public void Name(String s_name) { this.s_name = s_name; }

  public String Std() { return std; }

  public void Std(String std) { this.std = std; }

   public String Div() { return s_div; }

  public void Div(String s_div) { this.s_div = s_div; }

  public String Roll() { return roll; }

  public void Roll(String roll) { this.roll = roll; }

  public String Stream() { return s_stream; }

  public void Stream(String s_stream) { this.s_stream = s_stream; }
  
  
  public Student(String id, String s_name, String std, String s_div, String roll,String s_stream) {
      this.id = id;
      this.s_name = s_name;
      this.std = std;
      this.s_div = s_div;
      this.roll = roll;
      this.s_stream=s_stream;
  }
}



