package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import java.io.File;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.io.*;

public class ChoosefileController {
    public selectrecieverController selecter;
    File file;

    @FXML
    private Button send;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button choosefiledialogue;
    @FXML
    private Label filename;

    @FXML
    void choosefile(ActionEvent event) {
        Stage s =new Stage();
        s.setTitle("SendFile");
        s.setResizable(false);
        FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(s);
        filename.setText(file.getName());



    }
    @FXML
    void sendfileaction(ActionEvent event) throws Exception {
        if(file!=null)
        {
            InputStream in=new FileInputStream(file);
            Data data=new Data(selecter.msgcontrol.client.clientName,selecter.reciever,file.getName());
            data.b=new byte[in.available()];
            in.read(data.b);
            in.close();
            selecter.msgcontrol.client.nc.write(data);
            filename.setText("no file choosen");
            Stage stage = (Stage)send.getScene().getWindow();
            // do what you have to do
            stage.close();
        }



    }
}
