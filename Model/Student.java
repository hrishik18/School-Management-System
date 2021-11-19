package School_Management_System.Model;

public class Student {
  private int id;
  private String s_name;
  private int std;
  private char s_div;
  private int roll;
  private String s_stream;

  public int Id() { return id; }

  public void Id(int id) { this.id = id; }

  public String Name() { return s_name; }

  public void Name(String s_name) { this.s_name = s_name; }

  public int Std() { return std; }

  public void Std(int std) { this.std = std; }

  public char Div() { return s_div; }

  public void Div(char s_div) { this.s_div = s_div; }

  public int Roll() { return roll; }

  public void Roll(int roll) { this.roll = roll; }

  public String Stream() { return s_stream; }

  public void Stream(String s_stream) { this.s_stream = s_stream; }
}



