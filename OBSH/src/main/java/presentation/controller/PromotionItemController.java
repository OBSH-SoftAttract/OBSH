package presentation.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
	private TableView table;
	
	@FXML
	private void initialize() {
		final ObservableList<Promotion> data = FXCollections.observableArrayList(
			    new Promotion("生日特惠折扣","2016-11-25","2018-12-25","全体用户","0.7"),
			    new Promotion("三间及以上预订优惠","2016-11-25","2017-02-03","全体用户","0.9"),
			    new Promotion("合作企业用户折扣","2016-11-25","2018-12-25","合作企业用户","0.88"),
			    new Promotion("双十一活动折扣","2016-11-10","2016-11-12","全体用户","0.88"));

        name.setCellValueFactory(
                new PropertyValueFactory<>("promotionname")
            );
        start.setCellValueFactory(
                new PropertyValueFactory<>("startdate")
            );
        end.setCellValueFactory(
                new PropertyValueFactory<>("enddate")
            );
        info.setCellValueFactory(
                new PropertyValueFactory<>("information")
            );
        count.setCellValueFactory(
                new PropertyValueFactory<>("discount")
            );
		table.setItems(data);
	}
	
	
	@FXML
	private void deletepromotion() {
		/**
		 * 删除策略
		 */
	}
	
	@FXML
	private void modifypromotion() {
		/**
		 * 修改策略
		 */
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

	/**
	 * 构造了PromotionList中的内容
	 * @author asus1
	 *
	 */
	public static class Promotion {
		private final SimpleStringProperty promotionname;
		private final SimpleStringProperty startdate;
		private final SimpleStringProperty enddate;
		private final SimpleStringProperty information;
		private final SimpleStringProperty discount;
	 
		private Promotion(String pn, String sd, String ed, String in, String dc) {
			this.promotionname = new SimpleStringProperty(pn);
			this.startdate = new SimpleStringProperty(sd);
			this.enddate = new SimpleStringProperty(ed);
			this.information = new SimpleStringProperty(in);
			this.discount = new SimpleStringProperty(dc);
		}
	 
		public String getPromotionname() {
			return promotionname.get();
		}	 
		public void setPromotionname(String on) {
			promotionname.set(on);
		} 
		public String getStartdate() {
			return startdate.get();
		}	 
		public void setStartdate(String sd) {
			startdate.set(sd);
		}
		public String getEnddate() {
			return enddate.get();
		}	 
		public void setEnddate(String ed) {
			enddate.set(ed);
		}
		public String getInformation() {
			return information.get();
		}
	 
		public void setInformation(String in) {
			information.set(in);
		}
		
		public String getDiscount() {
			return discount.get();
		}
	 
		public void setDiscount(String ds) {
			discount.set(ds);
		}

	}
	
	public void setPromotionItem(PromotionItem promotionItem) {
		// TODO Auto-generated method stub
		this.promotionItem = promotionItem;
		
	}


}