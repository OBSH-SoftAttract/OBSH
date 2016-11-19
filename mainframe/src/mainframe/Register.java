package mainframe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Register extends Application{
	
	@Override
	public void start(final Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));  	  
        Scene scene = new Scene(root);  
        primaryStage.setScene(scene);  
        primaryStage.setTitle("酒店线上预订系统OBSH");  
        primaryStage.show();
	}
}
