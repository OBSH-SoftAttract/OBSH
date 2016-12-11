package presentation.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.view.AddPromotion;
import presentation.view.BasicMessage;
import presentation.view.DealOrder;
import presentation.view.HotelStaff;
import presentation.view.PromotionItem;
import presentation.view.RoomMessage;
/**
 * 缺少对列表的操作 不懂
 * @author asus1
 *
 */
public class PromotionItemController {
	
	private PromotionItem promotionItem;
	
	@FXML
	private Button roommessage;
	
	@FXML
	private Button orderdeal;
	
	@FXML
	private Button addpromotion;
	
	@FXML
	private Button basic;
	
	@FXML
	private Button add;
	
	@FXML
	private TableColumn name;
	
	@FXML
	private TableColumn start;
	
	@FXML
	private TableColumn end;
	
	@FXML
	private TableColumn info;
	
	@FXML
	private TableColumn count;
	
	@FXML
	private void initialize() {

	}
	
	/**
	 * 打开添加策略的界面
	 */
	@FXML
	private void jumpToAddpromotion() {
		AddPromotion a = new AddPromotion();
		a.start(new Stage());
	}
	
	@FXML
	private void CloseStage(){
		promotionItem.getPrimaryStage().close();
	}

	@FXML
	private void minimizeStage() {
		promotionItem.getPrimaryStage().setIconified(true); 
	}
	
	@FXML
	private void BackToSignIn() {
		promotionItem.getPrimaryStage().close();
		HotelStaff m = new HotelStaff();
		m.start(new Stage());
	}
	
	@FXML
	private void jumpToRoomMessage() {
		promotionItem.getPrimaryStage().close();
		RoomMessage r = new RoomMessage();
		r.start(new Stage());
	}
	
	@FXML
	private void jumpToDealOrder() {
		promotionItem.getPrimaryStage().close();
		DealOrder d = new DealOrder();
		d.start(new Stage());
	}
	
	@FXML
	private void jumpToPromotionItem() {

	}
	
	@FXML
	private void jumpToBasicMessage() {
		promotionItem.getPrimaryStage().close();
		BasicMessage b = new BasicMessage();
		b.start(new Stage());
	}

	public void setPromotionItem(PromotionItem promotionItem) {
		// TODO Auto-generated method stub
		this.promotionItem = promotionItem;
		
	}


}