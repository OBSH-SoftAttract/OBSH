package presentation.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import presentation.controller.UserViewControllerImpl;

public class UserView{
	String userId;
	String password;
	private Button login;
	private Button register;
	private UserViewControllerService controller;
	private Scene scene;
	private TextField usernametf;
	private PasswordField passwordtf;
	private TextField searchtf;
	private Stage primaryStage;

	public UserView(UserViewControllerService controller){
		this.controller = controller;
		String id = Integer.toString(controller.getUserId());
		this.userId = id;
	}
	
	public Stage Main(){
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
	    InitStage(scene);
	   
	    //注册按钮的事件
	    register.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				//跳转至注册界面
				controller.jumptoRegisterFrame();
			}	    	
	    });
	  //登录按钮的事件
	    login.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				userId = usernametf.getText();
		    	password = passwordtf.getText();
		    	int id = Integer.parseInt(userId);
		    	UserViewControllerService uvcs = new UserViewControllerImpl(id);
		    	if(uvcs.successLogin(id,password)){
		    		//账号密码均正确，跳转到登录界面
		    		controller.jumptoUserMainFrame();
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
		    		InitStage(failloginscene);
		    		
		    		confirm.setOnAction(new EventHandler<ActionEvent>(){
						@Override
						public void handle(ActionEvent event) {
							//返回登录界面
							controller.backtoMain();						
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
	public void jumptoUserMainFrame() {
		VBox mainFrame = new VBox();
		VBox top = new VBox();
		//退出的链接
		Hyperlink logout = new Hyperlink();
		logout.setText("退出");
		logout.setOnAction((ActionEvent e) -> {
			System.exit(0);
			});
		logout.setPadding(new Insets(5,870,5,5));
		top.getChildren().add(logout);
		BorderPane second = new BorderPane();
		Text obsh = new Text();
		obsh.setText("酒店线上预订系统OBSH");
		obsh.setFill(Color.WHITE);
		obsh.setFont(Font.font("冬青黑体简体中文",30));
		second.setCenter(obsh);
		//三个用于界面跳转的按钮
		Button searchHotel = new Button();
		searchHotel.setText("搜索酒店信息");
		searchHotel.setMaxSize(200, 200);
		searchHotel.setMinSize(200, 200);
		Button checkOrder = new Button();
		checkOrder.setText("查看订单信息");
		checkOrder.setMaxSize(190, 190);
		checkOrder.setMinSize(190, 190);
		Button maintainPersonalInfo = new Button();
		maintainPersonalInfo.setText("维护个人信息");	
		maintainPersonalInfo.setMaxSize(190, 190);
		maintainPersonalInfo.setMinSize(190, 190);
		VBox center = new VBox();
		center.getChildren().addAll(checkOrder,searchHotel,maintainPersonalInfo);
		//搜索框
		BorderPane search = new BorderPane();
		VBox searchvb = new VBox();
		searchtf = new TextField();
		searchtf.setPromptText("地址/商圈");
		searchtf.setAlignment(Pos.TOP_CENTER);
		Button searchIcon = new Button();
		searchIcon.setMinSize(20, 20);
		searchIcon.setAlignment(Pos.CENTER);
		searchvb.setSpacing(10);
		searchvb.getChildren().addAll(searchtf,searchIcon);
		search.setCenter(searchvb);
		mainFrame.getChildren().addAll(top,second,center,search);
		Scene scene = new Scene(mainFrame);
		//给各个组件添加css样式
		scene.getStylesheets().add("main/login.css");
		top.getStyleClass().add("Top");
		second.getStyleClass().add("Second");
		searchHotel.getStyleClass().add("SearchHotel");
		checkOrder.getStyleClass().add("CheckOrder");
		maintainPersonalInfo.getStyleClass().add("MaintainPersonalInfo");
		searchIcon.getStyleClass().add("SearchButton");
		//InitStage是将所有的stage都设置成一个大小的方法
		InitStage(scene);
		
		//搜索按钮的事件
		searchIcon.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				//跳至搜索酒店信息主界面
				controller.jumptoSearchHotelMainFrame();
			}
		});
		
		//searchIcon(搜索按钮)和searchHotel(搜索酒店按钮)跳转到的是同一界面
		searchHotel.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				//跳至搜索酒店信息主界面
				controller.jumptoSearchHotelMainFrame();
				}
			});
		}
	
	public void InitStage(Scene scene){
		primaryStage.setScene(scene);
		primaryStage.setTitle("酒店线上预订系统OBSH");
		primaryStage.setHeight(700);
		primaryStage.setWidth(900);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	//回到登录主界面
	public void backtoMain(){
		primaryStage.setScene(scene);
	}
	//对text的字体设定
	public void addText(Text text){
		text.setFont(Font.font("冬青黑体简体中文",15));
	}
	//跳转到搜索酒店主界面
	public void jumptoSearchHotelMainFrame(){		
		VBox vb = new VBox();
		vb.getStyleClass().add("Vbox");
		vb.setPrefSize(1200, 700);
		HBox searchLine = new HBox();
		Button search = new Button("搜索");
		search.getStyleClass().add("SearchButton");
		searchtf.setPrefSize(100, 30);
		Text checkin = new Text("入住");
		Text checkout = new Text("退房");
		Text keyword = new Text("关键词");
		DatePicker checkinDatePicker = new DatePicker();
		DatePicker checkoutDatePicker = new DatePicker();
		searchLine.getChildren().addAll(checkin,addDatePicker(checkinDatePicker),
				checkout,addDatePicker(checkoutDatePicker),keyword,addKeyWord(searchtf),search);
		searchLine.setSpacing(10);
		vb.getChildren().add(searchLine);
		
		
		//位置
		HBox location = new HBox();
		Text l = new Text("位置");
		location.getChildren().add(l);
		ComboBox<String> province = new ComboBox<String> ();		
		ComboBox<String> city = new ComboBox<String> ();		
		ComboBox<String> district = new ComboBox<String> ();	
		ComboBox<String> commercial = new ComboBox<String> ();
		//获得用户选择的省份、城市、地区、商圈的索引
		int selectedprovince = province.getSelectionModel().getSelectedIndex();
		int selectedcity = city.getSelectionModel().getSelectedIndex();
		int selecteddistrict = district.getSelectionModel().getSelectedIndex();
		int selectedcommercial = commercial.getSelectionModel().getSelectedIndex();
		location.getChildren().addAll(addComboBoxProvince(province),addComboBoxCity(selectedprovince,city),
				addComboBoxDistrict(selectedcity,district),addComboBoxCommercial(selecteddistrict,commercial),keyword,addKeyWord(searchtf));
		location.setSpacing(15);
		vb.getChildren().add(location);
		
		//获得用户输入的关键词
		String keywordt = searchtf.getText();
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
		
		//星级
		HBox starLevel = new HBox();	
		Text star = new Text();
		star.setText("星级");
		CheckBox cb1 = new CheckBox("二星级及以下/经济");
		CheckBox cb2 = new CheckBox("三星级/舒适");
		CheckBox cb3 = new CheckBox("四星级/高档");
		CheckBox cb4 = new CheckBox("五星级/豪华");
		starLevel.setSpacing(10);
		starLevel.getChildren().addAll(star,cb1,cb2,cb3,cb4);
		vb.getChildren().add(starLevel);
		
		//房间类型
		HBox roomType = new HBox();
		Text room = new Text();
		room.setText("房间类型");
		CheckBox c1 = new CheckBox("大床房");
		CheckBox c2 = new CheckBox("双床房");
		CheckBox c3 = new CheckBox("家庭房/三人");
		CheckBox c4 = new CheckBox("套间");
		roomType.setSpacing(10);
		roomType.getChildren().addAll(room,c1,c2,c3,c4);
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
		
		Scene scene = new Scene(vb);
		primaryStage.setScene(scene);
	}
	
	private HBox addHotel(){
		HBox hb = new HBox();
		
		//获得酒店列表
		String[]hotelName = controller.getHotelName();
		String[]hotelStarLevel = controller.getRelatedHotelStarLevel();
		String[]hotelPrice = controller.getRelatedHotelPrice();
		String[]hotelMark = controller.getRelatedHotelMark();
		
		
		//滚动条
//		ScrollBar sc = new ScrollBar();
//		sc.setLayoutX(hb.getWidth() - sc.getWidth());  
//		sc.setMin(0);  
//		sc.setOrientation(Orientation.VERTICAL);  
//		sc.setPrefHeight(180);  
//		sc.setMax(360);  
//		sc.valueProperty().addListener((ov, old_val, new_val) -> {  
//        hb.setLayoutY(-new_val.doubleValue());  
//        });  
//		hb.getChildren().add(sc);
		return hb;
	}
	//跳转到注册界面
	public void jumptoRegisterFrame(){
			
	}
	private TextField addKeyWord(TextField keywordtf){
		keywordtf.setFont(Font.font("黑体",15));
		return keywordtf;
	}
	private DatePicker addDatePicker(DatePicker datePicker){
		datePicker.setMaxSize(172, 10);
		datePicker.setShowWeekNumbers(true);
		return datePicker;
	}
	
	private ComboBox<String> addComboBoxProvince(ComboBox<String> province){
		province.getItems().addAll(controller.getProvince());
		province.setTooltip(new Tooltip("选择省份"));
		province.setMinSize(100, 30);
		province.getSelectionModel().select(0);
		return province;
	}
	private ComboBox<String> addComboBoxCity(int selectedprovince,ComboBox<String> city){
		city.getItems().addAll(controller.getRelatedCity(selectedprovince));
		city.setTooltip(new Tooltip("选择城市"));
		city.setMinSize(100, 30);
		city.getSelectionModel().select(0);
		return city;
	}
	private ComboBox<String> addComboBoxDistrict(int selectedcity,ComboBox<String> district) {
		district.getItems().addAll(controller.getRelatedDistrict(selectedcity));
		district.setTooltip(new Tooltip("选择地区"));
		district.setMinSize(100, 30);
		district.getSelectionModel().select(0);
		return district;
	}
	private ComboBox<String> addComboBoxCommercial(int selecteddistrict,ComboBox<String> commercial) {
		commercial.getItems().addAll(controller.getRelatedDistrict(selecteddistrict));
		commercial.getSelectionModel().select(0);
		commercial.setTooltip(new Tooltip("选择商圈"));
		commercial.setMinSize(100, 30);
		return commercial;
	}
}