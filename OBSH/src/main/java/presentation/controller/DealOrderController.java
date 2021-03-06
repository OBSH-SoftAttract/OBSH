package presentation.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.view.BasicMessage;
import presentation.view.DealOrder;
import presentation.view.HotelStaff;
import presentation.view.PromotionItem;
import presentation.view.RoomMessage;
/**
 * BasicMessage在javafx下的控制器
 * @author bxh
 *
 */
public class DealOrderController {
	
	private DealOrder dealOrder;
	
	@FXML
	private Button roommessage;
	
	@FXML
	private Button orderdeal;
	
	@FXML
	private Button addpromotion;
	
	@FXML
	private Button basic;
	
	@FXML 
	private void delay() {
		Stage stage = new Stage();
		VBox vb = new VBox();
		Text delayt = new Text("订单延期至:");
		TextField delaytf = new TextField();
		delaytf.setMaxWidth(150);
		delaytf.setTooltip(new Tooltip("格式为:yyyy-MM-dd HH:mm:ss"));
		Button delay = new Button("延期");
		Button cancel = new Button("取消");
		HBox hb = new HBox();
		hb.setSpacing(40);
		hb.getChildren().addAll(delay,cancel);
		vb.getChildren().addAll(delayt,delaytf,hb);
		vb.setMaxSize(400,350);
		vb.setMinSize(400,350);
		vb.setSpacing(40);
		vb.setAlignment(Pos.CENTER);
		vb.setPadding(new Insets(20,20,20,20));
		hb.setAlignment(Pos.CENTER);
		Scene delayscene = new Scene(vb);
		stage.setScene(delayscene);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.show();
		
		delay.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				/**
				 * 处理延期事件
				 */
			}
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.close();
			}
			});
	}
	
	
	@FXML
	private void CloseStage(){
		dealOrder.getPrimaryStage().close();
	}

	@FXML
	private void minimizeStage() {
		dealOrder.getPrimaryStage().setIconified(true); 
	}
	
	@FXML
	private void BackToSignIn() {
		dealOrder.getPrimaryStage().close();
		HotelStaff m = new HotelStaff();
		m.start(new Stage());
	}
	
	@FXML
	private void jumpToRoomMessage() {
		dealOrder.getPrimaryStage().close();
		RoomMessage r = new RoomMessage();
		r.start(new Stage());
	}
	
	@FXML
	private void jumpToPromotionItem() {
		dealOrder.getPrimaryStage().close();
		PromotionItem p = new PromotionItem();
		p.start(new Stage());
	}
	
	@FXML
	private void jumpToBasicMessage() {
		dealOrder.getPrimaryStage().close();
		BasicMessage b = new BasicMessage();
		b.start(new Stage());
	}
	
	public void setDealOrder(DealOrder dealOrder) {
		// TODO Auto-generated method stub
		this.dealOrder= dealOrder;
		
	}


}
