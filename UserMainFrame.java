package mainframe;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class UserMainFrame {
	private Button searchIcon = new Button();
    private Button button = new Button();
	private int priceSelectIndex;
	private int roomTypeSelectIndex;
	private int priceSort;
	private final String pattern = "yyyy-MM-dd";
	private DatePicker checkinDatePicker;
	private DatePicker checkoutDatePicker;
	private LocalDate checkindate;
	private LocalDate checkoutdate;
	/*客户主界面
     * 包括退出的链接，跳转到搜索酒店界面，查看订单界面，维护个人信息界面的按钮
     *  以及要求用户输入关于地址商圈信息的搜索框
     */
	final ObservableList<String> Saddress = FXCollections.observableArrayList("南京","常州","苏州");		
	final ObservableList<String> NJcommercial = FXCollections.observableArrayList("新街口","湖南路","珠江路","夫子庙","中央门");		
	final ObservableList<String> CZcommercial = FXCollections.observableArrayList("南大街","文化宫","花园街");		
	final ObservableList<String> SZcommercial = FXCollections.observableArrayList("观前街","石路","南门","新区");		
	final ComboBox<String>  address = new ComboBox<String> (Saddress);
	final ComboBox<String>  commercial = new ComboBox<String> (NJcommercial);
	public void jumptoUserMainFrame(String id) {
		BorderPane mainFrame = new BorderPane();
		VBox guideline = new VBox();
		//三个用于界面跳转的按钮
		Button searchHotel = new Button();
		searchHotel.setText("搜索酒店信息");
		searchHotel.setMaxSize(120, 40);
		searchHotel.setMinSize(120, 40);
		Button checkOrder = new Button();
		checkOrder.setText("查看订单信息");
		checkOrder.setMaxSize(120, 40);
		checkOrder.setMinSize(120, 40);
		Button maintainPersonalInfo = new Button();
		maintainPersonalInfo.setText("维护个人信息");	
		maintainPersonalInfo.setMaxSize(120, 40);
		maintainPersonalInfo.setMinSize(120, 40);
		Button reversehistory = new Button();
		reversehistory.setText("查看预定历史");	
		reversehistory.setMaxSize(120, 40);
		reversehistory.setMinSize(120, 40);
		VBox head = new VBox();
		Image image = new Image("/blue_35.png");
		ImageView iv = new ImageView();
		iv.setFitHeight(80);
		iv.setFitWidth(80);
		iv.setImage(image);
		HBox userIdhb = new HBox();
		Text idt = new Text("账号:");
		Text IDt = new Text();
		IDt.setText(id);
		userIdhb.getChildren().addAll(idt,IDt);
		userIdhb.setSpacing(15);
		//根据id获得昵称
		String s = "妮妮";
		HBox namehb = new HBox();
		Text namet = new Text("昵称:");
		Text NAMEt = new Text();
		NAMEt.setText(s);
		namehb.getChildren().addAll(namet,NAMEt);
		namehb.setSpacing(15);
		head.getChildren().addAll(iv,userIdhb,namehb);
		head.setAlignment(Pos.TOP_CENTER);
		guideline.getChildren().addAll(head,searchHotel,checkOrder,maintainPersonalInfo,reversehistory);
		guideline.setSpacing(30);
		guideline.setAlignment(Pos.CENTER);
		HBox hb1 = new HBox();
		HBox hb2 = new HBox();
		Button flexiblebt = new Button();
		Button expandbt = new Button();
		HBox label = new HBox();
		label.getChildren().add(guideline);
		label.setMinSize(200, 630);
		label.setMaxSize(200, 630);
		label.setAlignment(Pos.CENTER);
		flexiblebt.setMinSize(45, 90);
		flexiblebt.setMaxSize(45, 90);
		expandbt.setMinSize(45, 90);
		expandbt.setMaxSize(45, 90);
		hb1.setAlignment(Pos.CENTER);
		hb1.getChildren().add(flexiblebt);
		HBox exhb = new HBox();
		exhb.getChildren().add(expandbt);
		exhb.setMinSize(45, 90);
		exhb.setMaxSize(45, 90);
		exhb.setPadding(new Insets(290,0,0,0));
		hb2.getChildren().addAll(label,exhb);
		mainFrame.setLeft(hb1);
		//搜索框	
		HBox hb = new HBox();
		address.setPromptText("南京");	
		address.setMaxWidth(100);
		address.setMinWidth(100);
		commercial.setPromptText("新街口");
		commercial.setMaxWidth(100);
		commercial.setMinWidth(100);
		hb.setSpacing(20);
		hb.setMaxSize(500, 30);
		hb.setMinSize(500, 30);
		hb.setAlignment(Pos.TOP_CENTER);
		mainFrame.setCenter(hb);
		address.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				int Aindex = address.getSelectionModel().getSelectedIndex();
				if(Aindex == 0){
					commercial.setItems(null);
					commercial.setPromptText("新街口");
					commercial.setItems(NJcommercial);
				}
				if(Aindex == 1){
					commercial.setItems(null);
					commercial.setPromptText("南大街");
					commercial.setItems(CZcommercial);
				}
				if(Aindex == 2){
					commercial.setItems(null);
					commercial.setPromptText("观前街");
					commercial.setItems(SZcommercial);
				}
			}			
		});
		commercial.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub                                         
				int Cindex = commercial.getSelectionModel().getSelectedIndex();
			}
		});
		searchIcon.setMinSize(25, 25);
		hb.getChildren().addAll(addText("地址:"),address,addText("商圈:"),commercial,searchIcon);
				
		VBox top = new VBox();
	    Button close = new Button();
	    close.setMaxSize(30,30);
	    close.setMinSize(30,30);
	    top.getChildren().add(close);
	    top.setMaxHeight(30);
	    top.setAlignment(Pos.TOP_RIGHT);
	    VBox tsvb = new VBox();
	    tsvb.getChildren().add(top);
	    tsvb.setSpacing(10);
	    Scene scene = new Scene(mainFrame);
	    scene.getStylesheets().add("mainframe/login.css");
	    Stage primaryStage = new Stage();
	    primaryStage.setScene(scene);
	    primaryStage.setHeight(700);
		primaryStage.setWidth(900);
		primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();	
	    close.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
	    });
	    mainFrame.setTop(tsvb);
		searchHotel.getStyleClass().add("SearchHotel");
		checkOrder.getStyleClass().add("CheckOrder");
		maintainPersonalInfo.getStyleClass().add("MaintainPersonalInfo");
		reversehistory.getStyleClass().add("ReverseHistory");
		flexiblebt.getStyleClass().add("FlexibleButton");
		label.getStyleClass().add("Label");
		expandbt.getStyleClass().add("FlexibleButton");
		searchIcon.getStyleClass().add("SearchButton");
		close.getStyleClass().add("CloseButton");
		flexiblebt.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				mainFrame.setLeft(hb2);
			}
		});
		expandbt.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				mainFrame.setLeft(hb1);
			}
		});
		//搜索按钮的事件
		searchIcon.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				//跳至搜索酒店信息主界面
				mainFrame.setLeft(hb1);
				VBox searchHotelvb = jumptoSearchHotelMainFrame(mainFrame);
				mainFrame.setCenter(searchHotelvb);					
			}
		});	
		//searchHotel(搜索酒店按钮)返回初始搜索界面
		searchHotel.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				primaryStage.close();
				jumptoUserMainFrame(id);			
				}
			});
		checkOrder.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				//跳至查看订单信息主界面
				mainFrame.setLeft(hb1);
				CheckOrderFrame cof = new CheckOrderFrame();
				BorderPane checkOrderborder = cof.jumptoCheckOrder();
				mainFrame.setCenter(checkOrderborder);
			}
		});
		maintainPersonalInfo.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){				
				//跳至维护个人信息信息主界面
				mainFrame.setLeft(hb1);
				MaintainPersonalInfo mpi = new MaintainPersonalInfo();
				GridPane mpigridpane = mpi.jumptoMaintainPersonalInfo(mainFrame);
				mainFrame.setCenter(mpigridpane);
			}
		});
		reversehistory.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){				
				//跳至查看预定历史主界面
				mainFrame.setLeft(hb1);
				ReverseHistory rh = new  ReverseHistory();
				BorderPane rhborder = rh.jumptoReverseHistory();
				mainFrame.setCenter(rhborder);
			}
		});
		}
	//跳转到搜索酒店主界面
	public VBox jumptoSearchHotelMainFrame(BorderPane mainFrame){	
		VBox v = new VBox();
		v.setMinSize(800, 600);
		v.setMaxSize(800, 600);
		VBox vb = new VBox();
		vb.setSpacing(10);
		HBox searchLineone = new HBox();
		searchLineone.setSpacing(10);
		searchLineone.getChildren().addAll(addText("地址:"),address,addText("商圈:"),commercial,searchIcon);
		searchLineone.setPadding(new Insets(0,0,0,50));
		vb.getChildren().add(searchLineone);
		HBox searchLinetwo = new HBox();
		checkinDatePicker = new DatePicker();
		checkinDatePicker.setValue(LocalDate.now());
		checkoutDatePicker = new DatePicker();			
	    checkoutDatePicker.setValue(checkinDatePicker.getValue().plusDays(1));	
		searchLinetwo.getChildren().addAll(addText("入住:"),addDatePicker(checkinDatePicker),
				addText("退房:"),addDatePicker(checkoutDatePicker));
		searchLinetwo.setSpacing(10);
		searchLinetwo.setPadding(new Insets(0,0,0,50));
		vb.getChildren().add(searchLinetwo);
		//价格
		HBox price = new HBox();
		RadioButton rb1 = new RadioButton();
		rb1.setText("不限");
		rb1.setSelected(true);
		RadioButton rb2 = new RadioButton();
		rb2.setText("￥150以下");
		RadioButton rb3 = new RadioButton();
		rb3.setText("￥150-300");
		RadioButton rb4 = new RadioButton();
		rb4.setText("￥301-450");
		RadioButton rb5 = new RadioButton();
		rb5.setText("￥451-600");
		RadioButton rb6 = new RadioButton();
		rb6.setText("￥600以上");
		price.setSpacing(10);
		price.getChildren().addAll(addText("价格:"),rb1,rb2,rb3,rb4,rb5,rb6);
		price.setPadding(new Insets(0,0,0,50));
		vb.getChildren().add(price);
		final ToggleGroup tgroup = new ToggleGroup();
		rb1.setToggleGroup(tgroup);
		rb2.setToggleGroup(tgroup);
		rb3.setToggleGroup(tgroup);
		rb4.setToggleGroup(tgroup);
		rb5.setToggleGroup(tgroup);
		rb6.setToggleGroup(tgroup);
		
		//房间类型
		HBox roomType = new HBox();
		RadioButton c1 = new RadioButton("不限");
		c1.setSelected(true);
		RadioButton c2 = new RadioButton("双床房");
		RadioButton c3 = new RadioButton("大床房");
		RadioButton c4 = new RadioButton("家庭房/三人");
		RadioButton c5 = new RadioButton("套间");
		roomType.setSpacing(10);
		roomType.getChildren().addAll(addText("房间类型"),c1,c2,c3,c4,c5);
		final ToggleGroup roomTypeGroup = new ToggleGroup();
		c1.setToggleGroup(roomTypeGroup);
		c2.setToggleGroup(roomTypeGroup);
		c3.setToggleGroup(roomTypeGroup);
		c4.setToggleGroup(roomTypeGroup);
		c5.setToggleGroup(roomTypeGroup);
		roomType.setPadding(new Insets(0,0,0,50));
		vb.getChildren().add(roomType);

//		ObservableList<String> pricelist = FXCollections.observableArrayList(
//		    "价格", "由高到低", "由低到高");
//		ComboBox<String> price1 = new ComboBox<String>();
//		price1.getItems().addAll(pricelist);
//		price1.getSelectionModel().select(0);
//		ObservableList<String> marklist = FXCollections.observableArrayList(
//			    "评分", "由高到低", "由低到高");
//		ComboBox<String> mark = new ComboBox<String>();
//		mark.getItems().addAll(marklist);
//		mark.getSelectionModel().select(0);
//		ObservableList<String> starlist = FXCollections.observableArrayList(
//			    "星级", "由高到低", "由低到高");
//		ComboBox<String> starr = new ComboBox<String>();
//		starr.getItems().addAll(starlist);
//		starr.getSelectionModel().select(0);		

		//这里应该有一个根据酒店和商圈获得相应酒店的controller调用
		HotelList hl = new HotelList();
		BorderPane hotellist = hl.addHotelList(mainFrame);
		vb.getChildren().add(hotellist);	
		v.getChildren().add(vb);
		searchIcon.getStyleClass().add("SearchButton");
		
//		price1.setOnAction(new EventHandler<ActionEvent>(){
//			@Override
//			public void handle(ActionEvent event) {
//				if(price1.getSelectionModel().getSelectedIndex() == 1){
//					//价格由高到低排序
//				}
//				if(price1.getSelectionModel().getSelectedIndex() == 2){
//					//价格由低到高排序
//				}
//			}
//			
//		});
//		mark.setOnAction(new EventHandler<ActionEvent>(){
//			@Override
//			public void handle(ActionEvent event) {
//				if(mark.getSelectionModel().getSelectedIndex() == 1){
//					//评分由高到低排序
//				}
//				if(mark.getSelectionModel().getSelectedIndex() == 2){
//					//评分由低到高排序
//				}
//			}			
//		});
//		starr.setOnAction(new EventHandler<ActionEvent>(){
//			@Override
//			public void handle(ActionEvent event) {
//				if(starr.getSelectionModel().getSelectedIndex() == 1){
//					//星级由高到低排序
//				}
//				if(starr.getSelectionModel().getSelectedIndex() == 2){
//					//星级由低到高排序
//				}
//			}				
//		});
		searchIcon.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				checkindate = checkinDatePicker.getValue();
				checkoutdate = checkoutDatePicker.getValue();
				priceSelectIndex = 6;
				tgroup.selectedToggleProperty().addListener(
					    (ObservableValue<? extends Toggle> ov, Toggle old_Toggle,
					    Toggle new_Toggle) -> {
					        if (tgroup.getSelectedToggle() == rb1) {
					        	priceSelectIndex = 1;
					        }
					        else if (tgroup.getSelectedToggle() == rb2) {
					        	priceSelectIndex = 2;
					        }
					        else if (tgroup.getSelectedToggle() == rb3) {
					        	priceSelectIndex = 3;
					        }
					        else if (tgroup.getSelectedToggle() == rb4) {
					        	priceSelectIndex = 4;
					        }
					        else if (tgroup.getSelectedToggle() == rb5) {
					        	priceSelectIndex = 5;
					        }
					        else if (tgroup.getSelectedToggle() == rb6) {
					        	priceSelectIndex = 6;
					        }
					});
				roomTypeSelectIndex = 5;
				roomTypeGroup.selectedToggleProperty().addListener(
					    (ObservableValue<? extends Toggle> ov, Toggle old_Toggle,
					    Toggle new_Toggle) -> {
					        if (roomTypeGroup.getSelectedToggle() == c1) {
					        	 roomTypeSelectIndex = 1;
					        }
					        else if (roomTypeGroup.getSelectedToggle() == c2) {
					        	 roomTypeSelectIndex = 2;
					        }
					        else if (roomTypeGroup.getSelectedToggle() == c3) {
					        	 roomTypeSelectIndex = 3;
					        }
					        else if (roomTypeGroup.getSelectedToggle() == c4) {
					        	 roomTypeSelectIndex = 4;
					        }
					        else if (roomTypeGroup.getSelectedToggle() == c5) {
					        	 roomTypeSelectIndex = 5;
					        }
					});
			}				
		});
		return v;
	}	
	//对text的字体设定
	public Text addText(String s){
		Text text = new Text(s);
		text.setFont(Font.font("冬青黑体简体中文",15));
		return text;
	}
	public HBox addSearchhb(BorderPane mainFrame, HBox hb1){
		HBox searchhb = new HBox();
		TextField locationtf = new TextField();
		TextField commercialtf = new TextField();
		locationtf.setMinSize(150, 30);
		locationtf.setMaxSize(150, 30);
		commercialtf.setMinSize(150, 30);
		commercialtf.setMaxSize(150, 30);
		searchhb.setSpacing(15);
		searchhb.getChildren().addAll(addText("地址"),address,addText("商圈"),commercial,button);
		searchhb.setPadding(new Insets(100,150,100,150));
		searchhb.setSpacing(10);
		searchhb.setAlignment(Pos.CENTER);
		button.getStyleClass().add("SearchButton");
		searchIcon.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				//跳至搜索酒店信息主界面
				mainFrame.setLeft(hb1);
				VBox searchHotelvb = jumptoSearchHotelMainFrame(mainFrame);
				mainFrame.setCenter(searchHotelvb);
			}
		});
		return searchhb;
	}
private DatePicker addDatePicker(DatePicker datePicker){
	datePicker.setMaxSize(120, 25);
	datePicker.setMinSize(120, 25);
	StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
    	DateTimeFormatter dateFormatter =DateTimeFormatter.ofPattern(pattern);
    	@Override
    	public String toString(LocalDate date) {
    		if (date != null) {
    			return dateFormatter.format(date);
    		} else {
    				return "";
    			}
    	}	    	
    	@Override
    	public LocalDate fromString(String string) {
    		if (string != null && !string.isEmpty()) {
    			return LocalDate.parse(string, dateFormatter);
    			} else {
    				return null;
    				}
    		}
    	};     
    datePicker.setConverter(converter);
    datePicker.setPromptText(pattern.toLowerCase());
    datePicker.requestFocus();
	
    final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
    	@Override
    	public DateCell call(final DatePicker datePicker) {
    		return new DateCell() {
    			@Override
    			public void updateItem(LocalDate item, boolean empty) {
    				super.updateItem(item, empty);
    				
    				if(datePicker == checkinDatePicker){
    					if (item.isBefore(
    							checkinDatePicker.getValue().plusDays(0))
    							) {
    						setDisable(true);
    						setStyle("-fx-background-color: #ffc0cb;");
    						}
    					}
    				else if(datePicker == checkoutDatePicker){
    					if (item.isBefore(
    							checkinDatePicker.getValue().plusDays(1))
    							) {
    						setDisable(true);
    						setStyle("-fx-background-color: #ffc0cb;");
    						}   
    					}
    				};
    			};
    		}	
    };
    datePicker.setDayCellFactory(dayCellFactory);
    return datePicker;
    }
}
