package presentation.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import presentation.view.UndoneOrder;
import presentation.view.CancelOrder;
import presentation.view.Web;
import presentation.view.WebPromotion;
import presentation.view.Credit;

public class CancelOrderController {
	
	private CancelOrder cancelOrder;
	
	@FXML
	private Button undoneorder;
	
	@FXML
	private Button cancelorder;
	
	@FXML
	private Button addpromotion;
	
	@FXML
	private Button credit;
	
	@FXML
	private void CloseStage(){
		cancelOrder.getPrimaryStage().close();
	}

	@FXML
	private void minimizeStage() {
		cancelOrder.getPrimaryStage().setIconified(true); 
	}
	
	@FXML
	private void BackToSignIn() {
		cancelOrder.getPrimaryStage().close();
		Web w = new Web();
		w.start(new Stage());
	}
	
	@FXML
	private void jumpToUndoneOrder() {
		cancelOrder.getPrimaryStage().close();
		UndoneOrder u = new UndoneOrder();
		u.start(new Stage());
	}
	
	@FXML
	private void jumpToCancelOrder() {

	}
	
	@FXML
	private void jumpToWebPromotion() {
		cancelOrder.getPrimaryStage().close();
		WebPromotion w = new WebPromotion();
		w.start(new Stage());
	}
	
	@FXML
	private void jumpToCredit() {
		cancelOrder.getPrimaryStage().close();
		Credit cr = new Credit();
		cr.start(new Stage());
	}
	

	public void setCancelOrder(CancelOrder cancelOrder) {
		// TODO Auto-generated method stub
		this.cancelOrder = cancelOrder;
		
	}

}
