package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Order0Controller {
	@FXML
	private Button pButton;
	@FXML
	private TextField name;
	@FXML
	private TextField discount;
	
	@FXML
	private Button cButton;
	@FXML
	private TextField userID;
	@FXML
	private TextField addcredit;
	
	@FXML
	private TableView View1;
	@FXML
	private TableColumn tcorderid;
	@FXML
	private TableColumn tcorderState;
	@FXML
	private TableColumn tcStartTime;
	@FXML
	private TableColumn tcEndTime;
	@FXML
	private TableColumn tclastTime;
	@FXML
	private TableColumn tcuserid;
	@FXML
	private TableColumn tcprice;
	@FXML
	private TableColumn tchotelID;
	@FXML
	private TableColumn tcroomInfo;
	
	@FXML
	private TableView View2;
	@FXML
	private TableColumn tcorderid1;

	@FXML
	private TableColumn tcStartTime1;
	@FXML
	private TableColumn tcCancelTime;
	@FXML
	private TableColumn tclastTime1;
	@FXML
	private TableColumn tcuserid1;
	@FXML
	private TableColumn tcprice1;
	@FXML
	private TableColumn tchotelID1;
	@FXML
	private TableColumn tcroomInfo1;
	
	public void showList(){
		 ObservableList<OrderUndone> list = FXCollections.observableArrayList();
		 OrderUndone order = new OrderUndone();
		 order.setorderid("000001");
		 order.setorderState("1");
		 order.setStartTime("2016-12-12");
		 order.setEndTime("2016-12-13");
		 order.setlastTime("2016-12-13");
		 order.setuserid("00001");
		 order.setprice(300);
		 order.sethotelID("X00001");
		 order.setroomInfo("xxxxx");
		 
		 tcorderid1.setCellValueFactory(new PropertyValueFactory("orderid"));
		 tcorderState.setCellValueFactory(new PropertyValueFactory("orderState"));
		 tcStartTime1.setCellValueFactory(new PropertyValueFactory("StartTime"));
		 tcEndTime.setCellValueFactory(new PropertyValueFactory("EndTime"));
		 tclastTime.setCellValueFactory(new PropertyValueFactory("lastTime"));
		 tcuserid.setCellValueFactory(new PropertyValueFactory("userid"));
		 tcprice.setCellValueFactory(new PropertyValueFactory("price"));
		 tchotelID.setCellValueFactory(new PropertyValueFactory("hotelID"));
		 tcroomInfo.setCellValueFactory(new PropertyValueFactory("information"));
		 
		 list.add(order);
		 View1.setItems(list);
	}
	
    public void initialize(URL url, ResourceBundle rb) {
        showList();
        }  
	
	public void showList1(){
		 ObservableList<OrderUndone> list = FXCollections.observableArrayList();
		 OrderUndone order = new OrderUndone();
		 order.setorderid("000001");
		 order.setorderState("1");
		 order.setStartTime("2016-12-12");
		 order.setEndTime("2016-12-13");
		 order.setlastTime("2016-12-13");
		 order.setuserid("00001");
		 order.setprice(300);
		 order.sethotelID("X00001");
		 order.setroomInfo("xxxxx");
		 
		 tcorderid1.setCellValueFactory(new PropertyValueFactory("orderid1"));
		 tcStartTime1.setCellValueFactory(new PropertyValueFactory("StartTime1"));
		 tcCancelTime.setCellValueFactory(new PropertyValueFactory("CancelTime"));
		 tclastTime1.setCellValueFactory(new PropertyValueFactory("lastTime1"));
		 tcuserid1.setCellValueFactory(new PropertyValueFactory("userid1"));
		 tcprice1.setCellValueFactory(new PropertyValueFactory("price1"));
		 tchotelID1.setCellValueFactory(new PropertyValueFactory("hotelID1"));
		 tcroomInfo.setCellValueFactory(new PropertyValueFactory("information1"));
		 
		 list.add(order);
		 View2.setItems(list);
	}
	
   public void initialize1(URL url, ResourceBundle rb) {
       showList1();
       }  
   
   
}
