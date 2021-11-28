package application;
import java.net.URL;
import java.sql.Connection;
import java.sql.ConnectionBuilder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

public class table_view1 implements Initializable {
  @FXML public TableView<Student> table;
  @FXML public TableColumn<Student, String> table_id;
  @FXML public TableColumn<Student, String> table_name;
  @FXML public TableColumn<Student, String> table_std;
  @FXML public TableColumn<Student, String> table_div;
  @FXML public TableColumn<Student, String> table_roll;
  @FXML public TableColumn<Student, String> table_stream;

  @FXML public TextField txt_id;

  @FXML public TextField txt_name;

  @FXML public TextField txt_std;

  @FXML public TextField txt_div;

  @FXML public TextField txt_roll;

  @FXML public TextField txt_stream;

  public void clear_data() {
    txt_id.clear();
    txt_name.clear();
    txt_std.clear();
    txt_div.clear();
    txt_roll.clear();
    txt_stream.clear();
  }

  ObservableList<Student> oblist = FXCollections.observableArrayList();
  int index = -1;
  Connection conn = null;
  ResultSet rs = null;
  PreparedStatement pst = null;

  ObservableList<Student> listM;
  ObservableList<Student> dataList;

  public void save() {
    conn = StudentDB.getConnection();
    String sql =
        "insert into info (id,s_name,std,s_div,roll,s_stream) values (?,?,?,?,?,? )";
    try {
      pst = conn.prepareStatement(sql);
      pst.setString(1, txt_id.getText());
      pst.setString(2, txt_name.getText());
      pst.setString(3, txt_std.getText());
      pst.setString(4, txt_div.getText());
      pst.setString(5, txt_roll.getText());
      pst.setString(6, txt_stream.getText());
      pst.execute();

      JOptionPane.showMessageDialog(null, "Student added successfully!");
      UpdateTable();
      //        search_user();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    }
  }
  @FXML
  void getSelected(MouseEvent event) {
    index = table.getSelectionModel().getSelectedIndex();
    if (index <= -1) {

      return;
    }
    // txt_id.setText(table_id.getCellData(index).toString());
    txt_id.setText(table_id.getCellData(index).toString());
    txt_name.setText(table_name.getCellData(index).toString());
    txt_std.setText(table_std.getCellData(index).toString());
    txt_div.setText(table_div.getCellData(index).toString());
    txt_roll.setText(table_roll.getCellData(index).toString());
    txt_stream.setText(table_stream.getCellData(index).toString());
  }

  public void update() {
    try {
      conn = StudentDB.getConnection();
      String value1 = txt_id.getText();
      String value2 = txt_name.getText();
      String value3 = txt_std.getText();
      String value4 = txt_div.getText();
      String value5 = txt_roll.getText();
      String value6 = txt_stream.getText();
      String sql = "update info set s_name= '" + value2 + "',std= '" + value3 +
                   "',s_div= '" + value4 + "',roll= '" + value5 +
                   "',s_stream='" + value6 + "' where id='" + value1 + "'";
      pst = conn.prepareStatement(sql);
      pst.execute();
      JOptionPane.showMessageDialog(null, "Updated!");
      UpdateTable();

      //        search_user();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    }
  }
  public void delete() {
    conn = StudentDB.getConnection();
    String sql = "delete from info where id = ?";
    try {
      pst = conn.prepareStatement(sql);
      pst.setString(1, txt_id.getText());
      pst.execute();
      JOptionPane.showMessageDialog(null, "Deleted!");
      UpdateTable();
      //        search_user();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    }
  }
  public void UpdateTable() {
    table_id.setCellValueFactory(
        cellData -> new ReadOnlyStringWrapper(cellData.getValue().Id()));
    table_name.setCellValueFactory(
        cellData -> new ReadOnlyStringWrapper(cellData.getValue().Name()));
    table_std.setCellValueFactory(
        cellData -> new ReadOnlyStringWrapper(cellData.getValue().Std()));
    table_div.setCellValueFactory(
        cellData -> new ReadOnlyStringWrapper(cellData.getValue().Div()));
    table_roll.setCellValueFactory(
        cellData -> new ReadOnlyStringWrapper(cellData.getValue().Roll()));
    table_stream.setCellValueFactory(
        cellData -> new ReadOnlyStringWrapper(cellData.getValue().Stream()));

    listM = StudentDB.getDatausers();
    table.setItems(listM);
  }

  @FXML public Button add;

  @FXML public Button del;

  @FXML public Button upd;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    UpdateTable();
  }
}
