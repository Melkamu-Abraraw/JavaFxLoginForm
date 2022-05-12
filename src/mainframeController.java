
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class mainframeController extends Database {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button loginbtn;

   
    @FXML
    private BorderPane brp;
    @FXML
    private Label message;

    @FXML
    private TextField passTF;

    @FXML
    private Button signupbtn;

    @FXML
    private TextField usernameTF;

    @FXML
    void initialize() {
        assert loginbtn != null : "fx:id=\"loginbtn\" was not injected: check your FXML file 'mainframe.fxml'.";
        assert signupbtn != null : "fx:id=\"signupbtn\" was not injected: check your FXML file 'mainframe.fxml'.";
       
    }  
    @FXML
    void loginButtonAction(ActionEvent event) {
        
        if (usernameTF.getText().isBlank()==false && passTF.getText().isBlank()==false) {
            validator();
     } else {
       message.setText("Enter username and password !!!");
       
        
    
            
       
      }


    }
    public void validator(){
        Database c = new  Database();
        Connection con = c.getconnection();

        String verify = ("select count(1) From fill where userName ='"+usernameTF.getText()+"' and password = '"+passTF.getText() +"'");
           
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(verify);
            while (rs.next())
            if(rs.getInt(1)==1) {
               
                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                Stage stage = (Stage)loginbtn.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
               
            }
            else{
                message.setText("Invalid Login Please try again");
            }
        } catch (Exception e) {
            
        }
    }
    @FXML
    void action(ActionEvent event) throws Exception {

      
            Parent root= FXMLLoader.load(getClass().getResource("Registration.fxml"));
            
            Stage stage=(Stage)signupbtn.getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

         
        }

    }

 
    


