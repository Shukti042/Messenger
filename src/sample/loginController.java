package sample;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class loginController {
    Main main;
    String users[]=new String[10];
    public HashMap<String, String> PassMap;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane acropanelogin;

    @FXML
    private TextField username;

    @FXML
    private PasswordField pass;

    @FXML
    private Button loginbutton;

    @FXML
    private Button resetbutton;

    @FXML
    void loginAction(ActionEvent event) {
        users[0]="Shukti";
        users[1]="Saif";
        users[2]="Marzia";
        users[3]="Ema";
        users[4]="Nishat";
        users[5]="Dyuti";
        users[6]="Swati";
        users[7]="Tasin";
        users[8]="Mim";
        users[9]="Shuvo";
        PassMap = new HashMap<>();
        PassMap.put(users[0],"shukti");
        PassMap.put(users[1],"saif");
        PassMap.put(users[2],"marzia");
        PassMap.put(users[3],"ema");
        PassMap.put(users[4],"nishat");
        PassMap.put(users[5],"dyuti");
        PassMap.put(users[6],"swati");
        PassMap.put(users[7],"tasin");
        PassMap.put(users[8],"mim");
        PassMap.put(users[9],"shuvo");

        String name=username.getText();
        String password=pass.getText();
        if(!name.equals(users[0])&&!name.equals(users[1])&&!name.equals(users[2])&&!name.equals(users[3])&&!name.equals(users[4])&&!name.equals(users[5])&&!name.equals(users[6])&&!name.equals(users[7])&&!name.equals(users[8])&&!name.equals(users[9]))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Credentials");
            alert.setHeaderText("Incorrect Credentials");
            alert.setContentText("The username and password you provided is not correct.");
            alert.showAndWait();
        }
        else if(PassMap.get(name).equals(password))
        {
            try {
                main.showMessages(name,users);
            }catch (Exception e)
            {
                System.out.println(e);
            }
        }
        else {
            // failed login
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Credentials");
            alert.setHeaderText("Incorrect Credentials");
            alert.setContentText("The username and password you provided is not correct.");
            alert.showAndWait();
        }


    }

    @FXML
    void resetAction(ActionEvent event) {
        username.setText(null);
        pass.setText(null);
    }

    void setMain(Main main) {
        this.main = main;
    }

}
