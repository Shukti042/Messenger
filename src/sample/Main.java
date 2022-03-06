package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main extends Application{

    Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        stage.setOnCloseRequest(e -> Platform.exit());
        showLoginPage();
    }

    public void showLoginPage() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();

        // Loading the controller
        loginController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void showMessages(String name, String[] users) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("messages.fxml"));
        Parent root = loader.load();

        // Loading the controller
        messageController controller = loader.getController();
        Text t1 = new Text("Please Select A Friend");
        t1.setFont(Font.font("Courier",20));
        t1.setFill(Paint.valueOf("040736"));
        Text t2 = new Text("\n\n" + "NOTE: Please Log Out Before Exiting,Lest Your Friends Should Face Troubles While Sending You Files");
        t2.setFont(Font.font("Courier",15));
        t2.setFill(Paint.valueOf("6F0303"));
        controller.textfl.getChildren().add(t1);
        controller.textfl.getChildren().add(t2);


        stage.setTitle(name);
        stage.setScene(new Scene(root));
        controller.setClient(name,users);
        controller.setMain(this);
        stage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }

}
