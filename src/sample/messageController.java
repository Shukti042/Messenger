
package sample;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.net.URL;
import java.util.*;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

public class messageController {
    Main main;
    Client client;
    String reciever;
    String[] users;
    List<String> list = new ArrayList<String>();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ScrollPane scrollp;

    @FXML
     public TextFlow textfl;

    @FXML
    public TextField textfld;

    @FXML
    private Button send;
    @FXML
    private Button emobutton;

    @FXML
    private Button friend1;

    @FXML
    private Button friend3;

    @FXML
    private Button friend2;

    @FXML
    private Button friend5;

    @FXML
    private Button friend4;

    @FXML
    private Button friend6;

    @FXML
    private Button friend7;

    @FXML
    private Button friend8;

    @FXML
    private Button friend9;


    @FXML
    void sendaction(ActionEvent event) {
        String message = textfld.getText();
        if(message!=null)
        {
            Text t1 = new Text(message+" ");
            t1.setFont(Font.font("OpenSansEmoji",25));
            t1.setFill(Paint.valueOf("441212"));
            textfl.setTextAlignment(TextAlignment.LEFT);
            textfl.getChildren().add(t1);
            Text t2=new Text("\n");
            textfl.getChildren().add(t2);
            String message2=client.clientName+":"+reciever+":"+message;
            textfld.setText(null);
            new WriteThreadClient(client.nc,message2);

        }

    }
    void setMain(Main main) {

        this.main = main;
        int index = 0;
        for(int i=0;i<10;i++)
        {
            if(users[i].equals(client.clientName))
            {
                index=i;
            }
            list.add(users[i]);
        }
        list.remove(index);
        friend1.setText(list.get(0));
        friend2.setText(list.get(1));
        friend3.setText(list.get(2));
        friend4.setText(list.get(3));
        friend5.setText(list.get(4));
        friend6.setText(list.get(5));
        friend7.setText(list.get(6));
        friend8.setText(list.get(7));
        friend9.setText(list.get(8));


    }
    void notification(String sender,String filename)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notification");
        alert.setHeaderText(null);
        alert.setContentText(sender+" sent you "+filename);

        alert.showAndWait();
    }
    void givealart(String msg)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Notification");
        alert.setHeaderText(null);
        alert.setContentText(msg);

        alert.showAndWait();
    }
    void givealart2(String msg)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Notification");
        alert.setHeaderText(null);
        alert.setContentText(msg);

        alert.showAndWait();
    }
    void Show(String line)
    {
        if (line != null) {
            String s;
            String[] temp=line.split(":");
            if(temp[0].equals(client.clientName)&&temp[1].equals(reciever))
            {

                int i=temp[0].length()+temp[1].length()+2;
                int j=line.length();
                char[] temparray=line.toCharArray();
                s=new String(temparray,i,j-i);
                Text t1 = new Text(s);
                t1.setFont(Font.font("OpenSansEmoji",25));
                t1.setFill(Paint.valueOf("441212"));
                textfl.getChildren().add(t1);
                Text t2=new Text("\n");
                textfl.setTextAlignment(TextAlignment.LEFT);
                textfl.getChildren().add(t2);

            }
            else if(temp[1].equals(client.clientName)&&temp[0].equals(reciever))
            {
                int i=temp[0].length()+temp[1].length()+2;
                int j=line.length();
                char[] temparray=line.toCharArray();
                s=new String(temparray,i,j-i);
                s=temp[0]+" : "+s;
                Text t1 = new Text(s+" ");
                t1.setFont(Font.font("OpenSansEmoji",25));
                t1.setFill(Paint.valueOf("0A0A36"));
                textfl.getChildren().add(t1);
                Text t2=new Text("\n");
                textfl.setTextAlignment(TextAlignment.LEFT);
                textfl.getChildren().add(t2);

            }



        }
    }
    public void setClient(String name, String[] users) {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        Client client = new Client(serverAddress, serverPort,name,this);
        this.client=client;
        this.users=users;
        //Platform.setImplicitExit(false);
        new ReadThreadClient(client.nc,this,this.main,name);
    }


    public void showimogis(ActionEvent actionEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("emojis.fxml"));
        Parent root = loader.load();
        emojicontroller Control=loader.getController();
        Stage s =new Stage();
        s.setScene(new Scene(root));
        s.setTitle("Emogis");
        s.setResizable(false);
        Control.getMessageControle(this);
        s.show();

    }
    public void filesend(ActionEvent actionEvent) throws Exception {
        Pass.filesender=client.clientName;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("slectreciever.fxml"));
        Parent root = loader.load();
        selectrecieverController Control=loader.getController();
        Stage s =new Stage();
        s.setScene(new Scene(root));
        s.setTitle("SendFile");
        s.setResizable(false);
        Control.msgcontrol=this;
        Control.button1.setText(list.get(0));
        Control.button2.setText(list.get(1));
        Control.button3.setText(list.get(2));
        Control.button4.setText(list.get(3));
        Control.button5.setText(list.get(4));
        Control.button6.setText(list.get(5));
        Control.button7.setText(list.get(6));
        Control.button8.setText(list.get(7));
        Control.button9.setText(list.get(8));
        s.show();
    }

    public void setreciever(ActionEvent actionEvent) throws Exception {
        String[] s=actionEvent.toString().split("'");
        reciever=s[1];
        textfl.getChildren().clear();
        BufferedReader br=new BufferedReader(new FileReader("Messages.txt"));
        while (true)
        {
            String line=br.readLine();
            if(line==null)
            {
                break;
            }
            Show(line);

        }
        br.close();

    }


    public void logoutAction(ActionEvent actionEvent) {
        client.nc.write("Remove me");
        client.nc.closeConnection();
        try {
            main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
