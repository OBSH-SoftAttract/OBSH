package presentation.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
public class BasicMessageController {
	
	private BasicMessage basicMessage;
	
	@FXML
	private TextField hotelName;
	
	@FXML
	private TextField address;
	
	@FXML
	private TextField tradingArea;
	
	@FXML
	private TextArea services;
	
	@FXML
	private TextArea briefInfo;
	
	@FXML
	private ChoiceBox star;
	
	@FXML
	private Button roommessage;
	
	@FXML
	private Button orderdeal;
	
	@FXML
	private Button addpromotion;
	
	@FXML
	private Button basic;
	
	@FXML
	private Label tip; //这个是修改成功失败的提示域
	
	/**
	 * 这是一个初始化的方法 
	 * 里面要调逻辑层得到目前酒店的基本信息
	 */
	@FXML
	private void initialize() {
		hotelName.setText("hotelVO里的name");
		address.setText("");
		tradingArea.setText("");
		services.setText("");
		briefInfo.setText("");
		star.getItems().addAll("一星级","两星级","三星级","四星级","五星级");
		
	}
	
	/**
	 * 酒店工作人员修改酒店信息
	 * 问题是这里没有实现查看酒店信息！！！
	 */
	@FXML
	private void modifyHotel() {
		String hotelname = hotelName.getText();      //酒店名称
		String hotelstar = (String) star.getValue(); //酒店星级
		String hoteladdress = address.getText();     //地址
		String hotelTrading = tradingArea.getText(); //商圈
		String service = services.getText();         //服务
		String brief = briefInfo.getText();          //简介

	}
	
	@FXML
	private void CloseStage(){
		basicMessage.getPrimaryStage().close();
	}

	@FXML
	private void minimizeStage() {
		basicMessage.getPrimaryStage().setIconified(true); 
	}
	
	@FXML
	private void BackToSignIn() {
		basicMessage.getPrimaryStage().close();
		HotelStaff m = new HotelStaff();
		m.start(new Stage());
	}
	
	@FXML
	private void jumpToRoomMessage() {
		basicMessage.getPrimaryStage().close();
		RoomMessage r = new RoomMessage();
		r.start(new Stage());
	}
	
	@FXML
	private void jumpToDealOrder() {
		basicMessage.getPrimaryStage().close();
		DealOrder d = new DealOrder();
		d.start(new Stage());
	}
	
	@FXML
	private void jumpToPromotionItem() {
		basicMessage.getPrimaryStage().close();
		PromotionItem p = new PromotionItem();
		p.start(new Stage());
	}
	
	@FXML
	private void jumpToBasicMessage() {

	}
	
	public void setBasicMessage(BasicMessage basicMessage) {
		this.basicMessage = basicMessage;
		
	}

}
