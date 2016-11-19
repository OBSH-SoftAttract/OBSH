package mainframe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {
	@FXML private AnchorPane pane;
	@FXML private TextField username;
	@FXML private TextField password;
	@FXML private Button cancel;
	@FXML private Button register;
	@FXML private Button login;
	@FXML private Label UserName;
	@FXML private Label Password;
	
	@FXML
	private void closelogin(ActionEvent event){
		System.exit(0);
	}
	@FXML 
	private void getUsername(ActionEvent event){
		
	}
	@FXML 
	private void getPassword(ActionEvent event){
		
	}
	@FXML 
	private void Register(ActionEvent event) throws Exception{
		Register r = new Register();
		Stage primaryStage = new Stage();
		r.start(primaryStage);
	}
}
