package session10lab1;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TableView<Person> tView;
    public TableColumn<Person, String > cName;
    public TableColumn<Person, String > cEmail;
    public TableColumn<Person, Integer > cAge;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cName.setCellValueFactory(new PropertyValueFactory<Person, String>("fullname"));
        cEmail.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
        cAge.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));
        tView.setItems(DemoSQL.personList);
    }
}
