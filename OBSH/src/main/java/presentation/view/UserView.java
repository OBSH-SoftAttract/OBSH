package presentation.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class UserView{
	String userId;
	String password;
	private Button login;
	private Button register;
	private UserViewControllerService controller;
	private TextField usernametf;
	private PasswordField passwordtf;
	private Scene scene;
	private Scene searchscene;
	private TextField locationtf;
	private TextField commercialtf;
	private Button searchIcon;
	private Text locationl;
	private Text commerciall;
	private DatePicker checkinDatePicker;
	private DatePicker checkoutDatePicker;
	private TextField userNametf;
	private TextField passwtf;
	private TextField conpasstf;
	private TextField phonenumtf;
	private final String pattern = "yyyy-MM-dd";
	private LocalDate checkindate;
	private LocalDate checkoutdate;
	private String address;
	private String commercial;
	private int priceSelectIndex;
	private int roomTypeSelectIndex;
	private int priceSort;

	public UserView(UserViewControllerService controller){
		this.controller = controller;
		String id = Integer.toString(controller.getUserId());
		this.userId = id;
	}
	
	public Stage Main(){
		Stage primaryStage = new Stage();
		primaryStage.setTitle("酒店线上预订系统OBSH");
		
		usernametf = new TextField();
	    usernametf.setPromptText("username");
	    usernametf.setMinSize(150, 10);

	    passwordtf = new PasswordField();
	    passwordtf.setPromptText("password");
	    passwordtf.setMinSize(150, 10);

	    register = new Button("注册");
	    register.setFont(Font.font("黑体",15));
	    register.setTextFill(Color.WHITE);
	    register.setMinSize(65, 10);
	    login = new Button("登录");
	    login.setFont(Font.font("黑体",15));
	    login.setTextFill(Color.WHITE);
	    login.setMinSize(65, 10);
	    register.setStyle("-fx-background-color:#7bbfea;");
	    login.setStyle("-fx-background-color:#7bbfea;");
	    
	    HBox hbBtn = new HBox(20);
	    hbBtn.getChildren().add(login);	
	    hbBtn.getChildren().add(register);	  
	    hbBtn.setSpacing(20);
	    
	    VBox root = new VBox(usernametf,passwordtf,hbBtn);
	    root.setSpacing(40);
	    root.setPadding(new Insets(300,600,10,600));
	    scene = new Scene(root);
	    scene.getStylesheets().add("main/application.css");
	    InitStage(primaryStage,scene);
	   
	    //注册按钮的事件
	    register.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				//跳转至注册界面
				controller.jumptoRegisterFrame(primaryStage);
			}	    	
	    });
	  //登录按钮的事件
	    login.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				userId = usernametf.getText();
		    	password = passwordtf.getText();
		    	int id = Integer.parseInt(userId);
		    	if(controller.successLogin(id,password)){
		    		//账号密码均正确，跳转到登录界面
		    		controller.jumptoUserMainFrame(primaryStage);
		    	}
		    	else{
		    		//显示登录失败
					VBox tip = new VBox();
		    		VBox vb = new VBox();
		    		Text faillogin = new Text();
		    		faillogin.setText("登录失败");
		    		faillogin.setFill(Color.YELLOWGREEN);
		    		addText(faillogin);
		    		Text tipinfo = new Text();
		    		tipinfo.setText("用户名或密码错误，请重新输入");
		    		tipinfo.setFill(Color.YELLOWGREEN);
		    		addText(tipinfo);
		    		Button confirm = new Button();
		    		confirm.setText("确定");
		    		confirm.getStyleClass().add("Button");
		    		vb.setSpacing(10);
		    		vb.getChildren().addAll(faillogin,tipinfo);
		    		tip.setSpacing(10);
		    		tip.getChildren().addAll(vb,confirm);
		    		VBox vbox = new VBox(usernametf,passwordtf,tip);
		    		vbox.setSpacing(40);
		    		vbox.setPadding(new Insets(300,600,10,600));
		    		Scene failloginscene = new Scene(vbox);
		    		failloginscene.getStylesheets().add("main/faillogin.css");
		    		InitStage(primaryStage,failloginscene);
		    		
		    		confirm.setOnAction(new EventHandler<ActionEvent>(){
						@Override
						public void handle(ActionEvent event) {
							//返回登录界面
							controller.backtoMain(primaryStage);						
						}
		    		});
		    	}
			}
	    });
	    return primaryStage;
	}
	/*客户主界面
     * 包括退出的链接，跳转到搜索酒店界面，查看订单界面，维护个人信息界面的按钮
     *  以及要求用户输入关于地址商圈信息的搜索框
     */
	public void jumptoUserMainFrame(Stage primaryStage) {
		VBox mainFrame = new VBox();
		HBox top = addTop();
		BorderPane second = new BorderPane();
		Text obsh = new Text();
		obsh.setText("酒店线上预订系统OBSH");
		obsh.setFill(Color.WHITE);
		obsh.setFont(Font.font("冬青黑体简体中文",40));
		second.setCenter(obsh);
		second.setMinHeight(150);
		second.setMaxHeight(150);
		//三个用于界面跳转的按钮
		Button searchHotel = new Button("搜索酒店信息");
		searchHotel.setMaxSize(150, 150);
		searchHotel.setMinSize(150, 150);
		Button checkOrder = new Button("查看订单信息");
		checkOrder.setMaxSize(140, 140);
		checkOrder.setMinSize(140, 140);
		Button maintainPersonalInfo = new Button("维护个人信息");
		maintainPersonalInfo.setMaxSize(140, 140);
		maintainPersonalInfo.setMinSize(140, 140);
		HBox center = new HBox();
		center.setAlignment(Pos.CENTER);
		center.setSpacing(15);
		center.getChildren().addAll(checkOrder,searchHotel,maintainPersonalInfo);
		//搜索框
		BorderPane search = new BorderPane();
		HBox searchhb = SearchAddressAndCommercial();
		searchhb.setPadding(new Insets(100,150,100,150));
		searchhb.setSpacing(10);
		searchhb.setAlignment(Pos.CENTER);
		searchhb.getChildren().add(AddSearchButton());
		search.setCenter(searchhb);			
		mainFrame.getChildren().addAll(top,second,center,search);
		searchscene = new Scene(mainFrame);
		//给各个组件添加css样式
		searchscene.getStylesheets().add("main/login.css");
		top.getStyleClass().add("Top");
		second.getStyleClass().add("Second");
		center.getStyleClass().add("Center");
		searchHotel.getStyleClass().add("SearchHotel");
		checkOrder.getStyleClass().add("CheckOrder");
		maintainPersonalInfo.getStyleClass().add("MaintainPersonalInfo");
		searchIcon.getStyleClass().add("SearchButton");
		//InitStage是将所有的stage都设置成一个大小的方法
		InitStage(primaryStage,searchscene);
		
		//搜索按钮的事件
		searchIcon.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				//跳至搜索酒店信息主界面
				controller.jumptoSearchHotelMainFrame(primaryStage);
				address = locationtf.getText();
				commercial = commercialtf.getText();
				//显示相应的酒店列表
			}
		});	
		//searchIcon(搜索按钮)和searchHotel(搜索酒店按钮)跳转到的是同一界面
		searchHotel.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				//跳至搜索酒店信息主界面
				controller.jumptoSearchHotelMainFrame(primaryStage);
				}
			});
		checkOrder.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				//跳至查看订单信息主界面
				controller.jumptoCheckOrder(primaryStage);
			}
		});
		maintainPersonalInfo.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				//跳至维护个人信息信息主界面
				controller.jumptoMaintainPersonalInfo(primaryStage);
			}
		});
	}
	//跳至查看订单信息主界面
	public void jumptoCheckOrder(Stage primaryStage){		
		VBox vb = new VBox();
		ToggleButton tb1 = new ToggleButton("未执行正常订单");
		ToggleButton tb2 = new ToggleButton("已执行正常订单");
		ToggleButton tb3 = new ToggleButton("撤销订单");
		ToggleButton tb4 = new ToggleButton("异常订单");
		final ToggleGroup tgroup = new ToggleGroup();
		tb1.setToggleGroup(tgroup);
		tb2.setToggleGroup(tgroup);
		tb3.setToggleGroup(tgroup);
		tb4.setToggleGroup(tgroup);
		vb.getChildren().addAll(tb1,tb2,tb3,tb4);
		vb.setSpacing(100);
		vb.setPadding(new Insets(160,120,0,60));
		BorderPane border = new BorderPane();
	    TableView table = new TableView();       
	    TableColumn orderNum = new TableColumn("订单号");
        TableColumn reserveHotel = new TableColumn("预定酒店");
        TableColumn reverseTime = new TableColumn("预订时间");
        TableColumn orderState = new TableColumn("订单状态");
        table.getColumns().addAll(orderNum, reserveHotel, reverseTime,orderState);
        orderNum.setMinWidth(100);
        reserveHotel.setMinWidth(100);
        reverseTime.setMinWidth(100);
        orderState.setMinWidth(100);
        border.setCenter(table);
        border.setPadding(new Insets(100,180,100,30));
		GridPane grid = new GridPane();
		grid.add(vb, 0, 0);
		grid.add(border, 1, 0);
        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        scene.getStylesheets().add("main/CheckOrder.css");
        tb1.getStyleClass().add("ToggleButton");
        tb2.getStyleClass().add("ToggleButton");
        tb3.getStyleClass().add("ToggleButton");
        tb4.getStyleClass().add("ToggleButton");
	}
	//跳至维护个人信息信息主界面
	public void jumptoMaintainPersonalInfo(Stage primaryStage){
		
	}
	public Button AddSearchButton(){
		searchIcon = new Button();
		searchIcon.setMinSize(25, 25);
		searchIcon.setAlignment(Pos.CENTER);
		return searchIcon;
	}
	public HBox addTop(){
		HBox top = new HBox();
		top.setMaxHeight(30);
		top.setMinHeight(30);
		top.setPadding(new Insets(5,700,5,840));
		return top;
	}
	public HBox SearchAddressAndCommercial(){
		HBox searchhb = new HBox();
		locationl = new Text();
		locationl.setText("地址");
		locationtf = new TextField();
		locationtf.setMinSize(150, 30);
		locationtf.setMaxSize(150, 30);
		commerciall = new Text();
		commerciall.setText("商圈");
		commercialtf = new TextField();
		commercialtf.setMinSize(150, 30);
		commercialtf.setMaxSize(150, 30);
		searchhb.setSpacing(15);
		searchhb.getChildren().addAll(locationl,locationtf,commerciall,commercialtf);
		return searchhb;
	}	
	public void InitStage(Stage primaryStage,Scene scene){
		primaryStage.setScene(scene);
		primaryStage.setTitle("酒店线上预订系统OBSH");
		primaryStage.setHeight(700);
		primaryStage.setWidth(900);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	//对text的字体设定
	public void addText(Text text){
		text.setFont(Font.font("冬青黑体简体中文",15));
	}
	//跳转到搜索酒店主界面
	public void jumptoSearchHotelMainFrame(Stage primaryStage){		
		VBox v = new VBox();
		HBox top = new HBox();
		Button returntoUserMainFrame = new Button();
		returntoUserMainFrame.setMaxSize(28, 28);
		returntoUserMainFrame.setMinSize(28, 28);
		top.getChildren().add(returntoUserMainFrame);
		VBox vb = new VBox();
		vb.setPrefSize(1200, 700);
		vb.setPadding(new Insets(20,20,10,10));
		vb.setSpacing(10);
		HBox searchLineone = SearchAddressAndCommercial();
		HBox searchLinetwo = new HBox();
		Text checkin = new Text("入住");
		Text checkout = new Text("退房");
		checkinDatePicker = new DatePicker();
		checkinDatePicker.setValue(LocalDate.now());
		checkoutDatePicker = new DatePicker();			
	    checkoutDatePicker.setValue(checkinDatePicker.getValue().plusDays(1));
		Button searchIcon = AddSearchButton();
		searchLinetwo.getChildren().addAll(checkin,addDatePicker(checkinDatePicker),
				checkout,addDatePicker(checkoutDatePicker),searchLineone,searchIcon);
		searchLinetwo.setSpacing(10);
		vb.getChildren().add(searchLinetwo);
		//价格
		HBox price = new HBox();
		RadioButton rb1 = new RadioButton();
		rb1.setText("￥150以下");
		RadioButton rb2 = new RadioButton();
		rb2.setText("￥150-300");
		RadioButton rb3 = new RadioButton();
		rb3.setText("￥301-450");
		RadioButton rb4 = new RadioButton();
		rb4.setText("￥451-600");
		RadioButton rb5 = new RadioButton();
		rb5.setText("￥600以上");
		RadioButton rb6 = new RadioButton();
		rb6.setText("不限");
		price.setSpacing(10);
		Text pricet = new Text("价格");
		price.getChildren().addAll(pricet,rb1,rb2,rb3,rb4,rb5,rb6);
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
		Text room = new Text("房间类型");
		RadioButton c1 = new RadioButton("大床房");
		RadioButton c2 = new RadioButton("双床房");
		RadioButton c3 = new RadioButton("家庭房/三人");
		RadioButton c4 = new RadioButton("套间");
		RadioButton c5 = new RadioButton("不限");
		roomType.setSpacing(10);
		roomType.getChildren().addAll(room,c1,c2,c3,c4,c5);
		final ToggleGroup roomTypeGroup = new ToggleGroup();
		c1.setToggleGroup(roomTypeGroup);
		c2.setToggleGroup(roomTypeGroup);
		c3.setToggleGroup(roomTypeGroup);
		c4.setToggleGroup(roomTypeGroup);
		c5.setToggleGroup(roomTypeGroup);
		vb.getChildren().add(roomType);
		
		//排序
		HBox sequence = new HBox();		
		Button popular = new Button("最受欢迎");	
		ObservableList<String> pricelist = FXCollections.observableArrayList(
		    "价格", "由高到低", "由低到高");
		ComboBox<String> price1 = new ComboBox<String>();
		price1.getItems().addAll(pricelist);
		price1.getSelectionModel().select(0);
		ObservableList<String> marklist = FXCollections.observableArrayList(
			    "评分", "由高到低", "由低到高");
		ComboBox<String> mark = new ComboBox<String>();
		mark.getItems().addAll(marklist);
		mark.getSelectionModel().select(0);
		ObservableList<String> starlist = FXCollections.observableArrayList(
			    "星级", "由高到低", "由低到高");
		ComboBox<String> starr = new ComboBox<String>();
		starr.getItems().addAll(starlist);
		starr.getSelectionModel().select(0);
		Button history = new Button("预定历史");
		sequence.setSpacing(10);
		sequence.getChildren().addAll(popular,price1,mark,starr,history);
		vb.getChildren().add(sequence);
		vb.getChildren().add(addHotel());	
		
		v.getChildren().addAll(top,vb);
		Scene scene = new Scene(v);
		scene.getStylesheets().add("main/SearchButton.css");
		searchIcon.getStyleClass().add("SearchButton");
		returntoUserMainFrame.getStyleClass().add("ReturnButton");
		primaryStage.setScene(scene);
		
		returntoUserMainFrame.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(searchscene);				
			}				
		});
		popular.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				//controller.SortbyPopularity();					
			}				
		});
		price1.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				if(price1.getSelectionModel().getSelectedIndex() == 1){
					//价格由高到低排序
				}
				if(price1.getSelectionModel().getSelectedIndex() == 2){
					//价格由低到高排序
				}
			}			
		});
		mark.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				if(mark.getSelectionModel().getSelectedIndex() == 1){
					//评分由高到低排序
				}
				if(mark.getSelectionModel().getSelectedIndex() == 2){
					//评分由低到高排序
				}
			}		
		});
		starr.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				if(starr.getSelectionModel().getSelectedIndex() == 1){
					//星级由高到低排序
				}
				if(starr.getSelectionModel().getSelectedIndex() == 2){
					//星级由低到高排序
				}
			}			
		});
		history.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				//显示预定历史				
			}
		});
		searchIcon.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				checkindate = checkinDatePicker.getValue();
				checkoutdate = checkoutDatePicker.getValue();
				address = locationtf.getText();
				commercial = commercialtf.getText();
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
	}
	/*未完成
	 * 
	 */
	public HBox addHotel(){
		HBox hb = new HBox();
		//获得酒店列表
		String[]hotelName = controller.getHotelName();
		String[]hotelStarLevel = controller.getRelatedHotelStarLevel();
		String[]hotelPrice = controller.getRelatedHotelPrice();
		String[]hotelMark = controller.getRelatedHotelMark();	
		return hb;
	}
	//跳转到注册界面
	public void jumptoRegisterFrame(Stage primaryStage){
		GridPane grid = new GridPane();
		grid.setVgap(15);
		grid.setHgap(15);
		grid.setAlignment(Pos.CENTER);
		Text username = new Text("名称");
		Text phonenum = new Text("手机号");
		Text password = new Text("密码");
		Text confirmpassword = new Text("确认密码");
		userNametf = new TextField();
		passwtf = new TextField();
		conpasstf = new TextField();
		phonenumtf = new TextField();
		grid.add(username, 0, 0);
		grid.add(userNametf, 0, 1);
		grid.add(phonenum, 1, 0);
		grid.add(phonenumtf, 1, 1);
		grid.add(password, 0, 2);
		grid.add(passwtf, 0, 3);
		grid.add(confirmpassword, 1, 2);
		grid.add(conpasstf, 1, 3);
		HBox button = new HBox();
		button.setSpacing(15);
		button.setPadding(new Insets(20,0,20,0));
		button.setAlignment(Pos.CENTER);
		Button confirm = new Button("确定");
		button.getChildren().add(confirm);
		button.setMaxSize(200, 20);
		
		VBox root = new VBox();
		root.setAlignment(Pos.BOTTOM_CENTER);
		root.getChildren().addAll(grid,button);
		Scene registerScene = new Scene(root);
		registerScene.getStylesheets().add("main/Register.css");
		confirm.getStyleClass().add("Button");
		primaryStage.setScene(registerScene);
		
		confirm.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				String username = userNametf.getText();
				String password = passwtf.getText();
				String conpassword = conpasstf.getText();
				String phonenum = phonenumtf.getText();
				/*处理用户输入
				 * 
				 * 
				 */
				
			}			
		});
	}
	//回到登录主界面
	public void backtoMain(Stage primaryStage){
		primaryStage.setScene(scene);
	}
	private DatePicker addDatePicker(DatePicker datePicker){
		datePicker.setMaxSize(150, 10);
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