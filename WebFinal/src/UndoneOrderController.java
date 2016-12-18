package presentation.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import presentation.view.UndoneOrder;
import presentation.view.CancelOrder;
import presentation.view.Web;
import presentation.view.WebPromotion;
import presentation.view.Credit;

public class UndoneOrderController {
	
	private UndoneOrder undoneOrder;
	
	@FXML
	private Button undoneorder;
	
	@FXML
	private Button cancelorder;
	
	@FXML
	private Button addpromotion;
	
	@FXML
	private Button credit;
	
	@FXML
	private Button cancel;
	
	@FXML
	private void CloseStage(){
		undoneOrder.getPrimaryStage().close();
	}

	@FXML
	private void minimizeStage() {
		undoneOrder.getPrimaryStage().setIconified(true); 
	}
	
	@FXML
	private void BackToSignIn() {
		undoneOrder.getPrimaryStage().close();
		Web w = new Web();
		w.start(new Stage());
	}
	
	@FXML
	private void jumpToUndoneOrder() {

	}
	
	@FXML
	private void jumpToCancelOrder() {
		undoneOrder.getPrimaryStage().close();
		CancelOrder c = new CancelOrder();
		c.start(new Stage());
	}
	
	@FXML
	private void jumpToPromotionItem() {
		undoneOrder.getPrimaryStage().close();
		WebPromotion w = new WebPromotion();
		w.start(new Stage());
	}
	
	@FXML
	private void jumpToBasicMessage() {
		undoneOrder.getPrimaryStage().close();
		Credit cr = new Credit();
		cr.start(new Stage());
	}
	

	public void setUndoneOrder(UndoneOrder undoneOrder) {
		// TODO Auto-generated method stub
		this.undoneOrder = undoneOrder;
		
	}

}
