package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Order extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("web.fxml"));
       
		Scene scene = new Scene(root, 856,680);
        stage.setTitle("OBSH");
        stage.setScene(scene);
        stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	
}