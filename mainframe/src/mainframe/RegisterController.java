package mainframe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RegisterController {
	@FXML private AnchorPane pane;
	@FXML private TextField username;
	@FXML private TextField password;
	@FXML private Button Confirm;
	@FXML private Button Cancel;
	@FXML private Button GetVerificationCode;
	@FXML private Label UserName;
	@FXML private Label Password;
	@FXML private Label Register;
	@FXML private Label vc;
	@FXML private Label ConfirmPassword;
	@FXML private Label mobilephone;
	@FXML private TextField phonenumber;
	@FXML private Label verificationcode;
	@FXML private TextField tfvc;
	@FXML private PasswordField password1;
	@FXML private PasswordField password2;
	@FXML private Label havesentvc;
	
	@FXML
	private void UserRegister(ActionEvent event){
		
	}
	@FXML 
	private void getUsername(ActionEvent event){
		
	}
	@FXML 
	private void getPhoneNum(ActionEvent event){
		
	}
	@FXML 
	private void getvc(ActionEvent event){
		havesentvc.setText("have sent to your phone");
		havesentvc.setVisible(true);
		GetVerificationCode.setText("send again");
	}
	@FXML 
	private void getPassword1(ActionEvent event){
		
	}
	@FXML 
	private void getPassword2(ActionEvent event){
		
	}
	@FXML 
	private void sendVerificationCode(ActionEvent event){
		
	}
	@FXML 
	private void backtologin(ActionEvent event){
		Cancel.getScene().getWindow().hide();
	}
	
}
