package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class selectrecieverController {
    messageController msgcontrol;
    String reciever;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public Button button1;

    @FXML
    public Button button2;

    @FXML
    public Button button3;

    @FXML
    public Button button4;

    @FXML
    public Button button5;

    @FXML
    public Button button6;

    @FXML
    public Button button7;

    @FXML
    public Button button8;

    @FXML
    public Button button9;

    @FXML
    void setreciever(ActionEvent event) throws Exception {
        String[] ss=event.toString().split("'");
        reciever=ss[1];
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("choosefile.fxml"));
        Parent root = loader.load();
        ChoosefileController Control=loader.getController();
        Stage s =new Stage();
        s.setScene(new Scene(root));
        s.setTitle("SendFile");
        s.setResizable(false);
        Control.selecter=this;
        s.show();
        Stage stage = (Stage)button1.getScene().getWindow();
        // do what you have to do
        stage.close();

    }
}
