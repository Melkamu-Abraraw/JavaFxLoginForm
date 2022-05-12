import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
    
    public class RegistrationController implements Initializable{
    
        @FXML
        private ResourceBundle resources;
    
        @FXML
        private URL location;
    
        @FXML
        private Button backbtn;
    
        @FXML
        private TextField firstNameTF;
    
        @FXML
        private TextField lastNameTF;
    
        @FXML
        private Label lblid;
    
        @FXML
        private TextField passTF;
    
        @FXML
        private TextField pnumberTF;
    
        @FXML
        private Button regbtn;
        @FXML
        private BorderPane bpid;
        @FXML
        private Label tryid;
    
        @FXML
        private TextField usernameTF;
        @FXML
        private Label messageBtn;
       
        App lg = new App();
        
        @FXML
        void signup(ActionEvent event) {
            if (firstNameTF.getText().isBlank()==false && lastNameTF.getText().isBlank()==false  
            && passTF.getText().isBlank()==false
            && pnumberTF.getText().isBlank()==false  
            && usernameTF.getText().isBlank()==false) {
                store();
         } else {
            tryid.setText("Fill all Field !!!");
          }
        }
        public void store(){
            Database c = new  Database();
            Connection con = c.getconnection();
    
        String sql = ("insert into fill(firstName,lastName,userName,phoneNumber,password) values(?,?,?,?,?)");
        try {
            PreparedStatement st = con.prepareStatement(sql);
    
            st.setString(1, firstNameTF.getText());
            st.setString(2, lastNameTF.getText());
            st.setString(3, usernameTF.getText());
            st.setString(5, passTF.getText());
            st.setString(4, pnumberTF.getText());
           
        
            st.executeUpdate();
     
       
            } catch (Exception e) {
         System.out.println(e);
        }
    
    }
   
    
    
        @FXML
        void initialize() {
            assert backbtn != null : "fx:id=\"backbtn\" was not injected: check your FXML file 'Registration.fxml'.";
            assert firstNameTF != null : "fx:id=\"firstNameTF\" was not injected: check your FXML file 'Registration.fxml'.";
            assert lastNameTF != null : "fx:id=\"lastNameTF\" was not injected: check your FXML file 'Registration.fxml'.";
            assert lblid != null : "fx:id=\"lblid\" was not injected: check your FXML file 'Registration.fxml'.";
            assert passTF != null : "fx:id=\"passTF\" was not injected: check your FXML file 'Registration.fxml'.";
            assert pnumberTF != null : "fx:id=\"pnumberTF\" was not injected: check your FXML file 'Registration.fxml'.";
            assert regbtn != null : "fx:id=\"regbtn\" was not injected: check your FXML file 'Registration.fxml'.";
            assert usernameTF != null : "fx:id=\"usernameTF\" was not injected: check your FXML file 'Registration.fxml'.";
           
           
        }  @FXML
        void root(ActionEvent event) {

         
            try {
                Parent root = FXMLLoader.load(getClass().getResource("mainframe.fxml"));
                Stage stage=(Stage)backbtn.getScene().getWindow();
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
           

         
        }
        @Override
        public void initialize(URL arg0, ResourceBundle arg1) {
            
        }
    
        

        


      
           
           
               
            
        }
    
    
    
 




