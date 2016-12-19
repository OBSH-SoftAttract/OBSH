package presentation.controller;

import java.rmi.RemoteException;

import ResultMessage.ResultMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import presentation.view.Web;
import presentation.view.RoomMessage;
import presentation.view.UserViewControllerService;


public class WebController {
	private UserViewControllerService userviewService = new UserViewControllerImpl();
	
	@FXML
	private Text welcome;
	
	@FXML
	private Label l1;
	
	@FXML
	private Label l2;
	
	@FXML
	private TextField name;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private Button minimize;
	
	@FXML
	private Button close;
	
	@FXML
	private Button sign;

	@FXML
	private Label failOutput;
	
	private Web main;
	
	/**
	 * 验证登录
	 * @throws RemoteException 
	 */
	@FXML
	private void confirmAction() throws RemoteException{
		String userID = name.getText();
		String enterpassword = password.getText();
		
		if(userID.equals("")||enterpassword.equals("")) {
			failOutput.setText("用户名密码不能为空!");
		}else {
			ResultMessage re = null;
			try {
				re = userviewService.Login(userID, enterpassword);
			} catch (RemoteException e) {
				e.printStackTrace();
			}

			switch (re) {
			case FormatWrong:
				failOutput.setText("用户名错误，请重新输入!");
				break;
			case NotExist:
				failOutput.setText("用户名不存在，请重新输入!");
				break;
			case WrongPassword:
				failOutput.setText("密码错误，请重新输入");
				break;
			default:
				main.getPrimaryStage().close();
				UndoneOrder u = new UndoneOrder();
				u.start(new Stage());
		}
		}
	}
	
	@FXML
	private void CloseStage(){
		main.getPrimaryStage().close();
	}

	@FXML
	private void minimizeStage() {
		 main.getPrimaryStage().setIconified(true); 
	}
	
	public void setLoginFrame(Web main) {
		// TODO Auto-generated method stub
		this.main = main;
		
	}


}
