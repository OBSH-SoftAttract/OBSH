package presentation.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import presentation.view.BasicMessage;
import presentation.view.DealOrder;
import presentation.view.HotelStaff;
import presentation.view.PromotionItem;
import presentation.view.RoomMessage;

public class RoomMessageController {
	
	private RoomMessage roomMessage;
	
	@FXML
	private Button roommessage;
	
	@FXML
	private Button orderdeal;
	
	@FXML
	private Button addpromotion;
	
	@FXML
	private Button basic;
	
	@FXML
	private void CloseStage(){
		roomMessage.getPrimaryStage().close();
	}

	@FXML
	private void minimizeStage() {
		roomMessage.getPrimaryStage().setIconified(true); 
	}
	
	@FXML
	private void BackToSignIn() {
		roomMessage.getPrimaryStage().close();
		HotelStaff m = new HotelStaff();
		m.start(new Stage());
	}
	
	@FXML
	private void jumpToRoomMessage() {

	}
	
	@FXML
	private void jumpToDealOrder() {
		roomMessage.getPrimaryStage().close();
		DealOrder d = new DealOrder();
		d.start(new Stage());
	}
	
	@FXML
	private void jumpToPromotionItem() {
		roomMessage.getPrimaryStage().close();
		PromotionItem p = new PromotionItem();
		p.start(new Stage());
	}
	
	@FXML
	private void jumpToBasicMessage() {
		roomMessage.getPrimaryStage().close();
		BasicMessage b = new BasicMessage();
		b.start(new Stage());
	}
	

	public void setRoomMessage(RoomMessage roomMessage) {
		// TODO Auto-generated method stub
		this.roomMessage = roomMessage;
		
	}

}
