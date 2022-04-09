package session10lab1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class DemoSQL extends Application {
    public final static String connectionString = "jdbc:mysql://localhost:3306/t2108m";
    public final static String user = "root" ;
    public final static String password = "" ;

    public static ObservableList<Person> personList = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("listperson.fxml"));
        primaryStage.setTitle("Session10 lab1");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();
    }

    public static void main(String[] args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString,user,password);
            Statement stt = conn.createStatement();
            String txt_sql = "select * from persons";
            ResultSet rs =stt.executeQuery(txt_sql);
            while (rs.next()){
                personList.add(new Person(rs.getString("fullname"),rs.getString("email"),rs.getInt("age")));
            }launch(args);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
