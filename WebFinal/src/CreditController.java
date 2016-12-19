package presentation.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.view.UndoneOrder;
import presentation.view.CancelOrder;
import presentation.view.Web;
import presentation.view.WebPromotion;
import presentation.view.Credit;



public class CreditController {
	
	private Credit credit;
	
	@FXML
	private TextField CreditName;
	
	@FXML
	private TextField CreditMoney;
	
	
	@FXML
	private void addCredit(){
		String creditName = CreditName.getText();
		String creditMoney = CreditMoney.getText();
	}
	
	@FXML
	private void CloseStage(){
		credit.getPrimaryStage().close();
	}

	@FXML
	private void minimizeStage() {
		credit.getPrimaryStage().setIconified(true); 
	}
	
	@FXML
	private void BackToSignIn() {
		credit.getPrimaryStage().close();
		Web w = new Web();
		w.start(new Stage());
	}
	
	@FXML
	private void jumpToUndoneOrder() {
		credit.getPrimaryStage().close();
		UndoneOrder u = new UndoneOrder();
		u.start(new Stage());
	}
	
	@FXML
	private void jumpToCancelOrder() {
		credit.getPrimaryStage().close();
		CancelOrder c = new CancelOrder();
		c.start(new Stage());
	}
	
	@FXML
	private void jumpToWebPromotion() {
		credit.getPrimaryStage().close();
		WebPromotion w = new WebPromotion();
		w.start(new Stage());
	}
	
	@FXML
	private void jumpToCredit() {

	}
	
	public void setCredit(Credit credit) {
		this.credit = credit;
		
	}

}
