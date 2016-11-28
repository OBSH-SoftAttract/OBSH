package main;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Main extends Application {	
	final int WIDTH = 800;
    final int HEIGHT = 600;
    ToggleButton tb1;
    ToggleButton tb2;
    ToggleButton tb3;
    ToggleButton tb4;
    BorderPane border;
    DatePicker checkinDatePicker = new DatePicker();
	DatePicker checkoutDatePicker = new DatePicker();
	ComboBox<String> province = new ComboBox<String>();		   
	ComboBox<String>city = new ComboBox<String>();		   
	ComboBox<String> district = new ComboBox<String>();
	ComboBox<String> commercial = new ComboBox<String>();
    ObservableList<String> comboBox = FXCollections.observableArrayList("安徽","澳门","北京","重庆","福建",
			   "甘肃","广东","广西","贵州","海南","河北","河南","黑龙江","湖北","湖南","吉林","江苏","江西","辽宁","内蒙古",
			   "宁夏","青海","山东","山西","陕西","上海","四川","台湾","天津","西藏","香港","新疆","云南","浙江");
    ObservableList<String> anhui = FXCollections.observableArrayList("合肥市","芜湖市","亳州市","马鞍山","池州市",
			   "淮南市","淮北市","蚌埠市","巢湖市","安庆市","宿州市","宣城市","滁州市","黄山市","六安市","阜阳市","铜陵市");
    ObservableList<String> hefeishi = FXCollections.observableArrayList("包河区","滨湖新区","长丰县","肥东县","肥西县","高新区","经济技术开发区","庐阳区","蜀山区","新站区","瑶海区","政务区");
	ObservableList<String> aomenbandao = FXCollections.observableArrayList("花地玛堂区","圣安多尼堂区","大堂区","望德堂区","风顺堂区");
    ObservableList<String> aomenlidao = FXCollections.observableArrayList("嘉模堂区","圣方济各堂区");
    ObservableList<String> hefeiDistrict = FXCollections.observableArrayList("百货大楼","商之都","元一时代广场购物中心","新都会环球广场","鼓楼商厦");
    ObservableList<String> aomen = FXCollections.observableArrayList("澳门半岛","澳门离岛");
    TextField keywordtf = new TextField();
	   @Override
	   public void start(Stage primaryStage) {
		    primaryStage.setTitle("酒店线上预订系统OBSH");
		    
		    GridPane grid1 = new GridPane();
		    grid1.setAlignment(Pos.TOP_CENTER);
		    grid1.setPadding(new Insets(10, 10, 10, 10));
		    
		    Image logo =  new Image("/logo.png",true);
		    ImageView iv = new ImageView();
		    iv.setImage(logo);
		    grid1.add(iv,1,1);
		   
		    GridPane grid4 = new GridPane();
		    grid4.setMaxSize(360, 390);
		    grid4.setAlignment(Pos.CENTER);
		    grid4.setHgap(20);
		    grid4.setVgap(20);
		    grid4.setPadding(new Insets(10, 10, 10, 10));
		    
		    Text welcome = new Text("Welcome");
		    welcome.setFill(Color.BLACK);
		    welcome.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));  
		    grid4.add(welcome,0,0);
		    	    	   
		    GridPane grid5 = new GridPane();
		    grid5.setMaxSize(360, 390);
		    grid5.setAlignment(Pos.CENTER);
		    grid5.setHgap(20);
		    grid5.setVgap(20);
		    grid5.setPadding(new Insets(10, 10, 10, 10));
		    
		    TextField usernametf = new TextField();
		    usernametf.setPromptText("username");
		    grid5.add(usernametf,0,1);
	
		    TextField passwordtf = new TextField();
		    passwordtf.setPromptText("password");
		    
		    grid5.add(passwordtf,0,2);
	    
		    Button register = new Button("注册");
		    register.setFont(Font.font("黑体",15));
		    register.setTextFill(Color.WHITE);
		    Button btn = new Button("登录");
		    btn.setFont(Font.font("黑体",15));
		    btn.setTextFill(Color.WHITE);
		    register.setStyle("-fx-background-color:#7bbfea;");
	    	btn.setStyle("-fx-background-color:#7bbfea;");
		    
		    HBox hbBtn = new HBox(10);
		    hbBtn.setAlignment(Pos.BOTTOM_CENTER);
		    hbBtn.getChildren().add(btn);	
		    hbBtn.getChildren().add(register);	   
		    grid5.add(hbBtn,0,3);
		    
		    VBox root = new VBox(grid1,grid4,grid5);
		    root.setStyle("-fx-background-color:#F0F8FF;");
		    primaryStage.setScene(new Scene(root));
		    primaryStage.setResizable(false);
		    primaryStage.setWidth(330);
		    primaryStage.setHeight(400);
		    primaryStage.show();
		    
		    //注册
		    register.setOnAction((e)->{
		    	Stage stage1 = new Stage();
		    	stage1.setTitle("酒店线上预订系统OBSH");
		    	stage1.setWidth(WIDTH);
		    	stage1.setHeight(HEIGHT);
		    	
		    	GridPane registerpane = new GridPane();//注册账号
		    	Label r = new Label("Register");
		    	r.setFont(Font.font ("Verdana", 30));
		    	registerpane.add(r, 0, 0);
		    	registerpane.setAlignment(Pos.CENTER);
		    	registerpane.setHgap(10);
		    	registerpane.setVgap(10);
		    	Label username = new Label("账号");
		    	username.setFont(Font.font("黑体",15));
		    	registerpane.add(username, 0, 1);
		    	TextField un = new TextField();
		    	un.setFont(Font.font("黑体",15));
		    	registerpane.add(un, 1, 1);
		    	Label password = new Label("密码");
		    	password.setFont(Font.font("黑体",15));
		    	registerpane.add(password, 0, 2);
		    	PasswordField PW = new PasswordField();
		    	PW.setFont(Font.font("黑体",15));
		    	registerpane.add(PW, 1, 2);
		    	Label Cpassword = new Label("确认密码");
		    	Cpassword.setFont(Font.font("黑体",15));
		    	registerpane.add(Cpassword, 0, 3);
		    	PasswordField CPW = new PasswordField();//确认密码
		    	CPW.setFont(Font.font("黑体",15));
		    	registerpane.add(CPW, 1, 3);
		    	Label phonenum = new Label("手机号");
		    	phonenum.setFont(Font.font("黑体",15));
		    	registerpane.add(phonenum, 0, 4);
		    	TextField pn = new TextField();
		    	pn.setFont(Font.font("黑体",15));
		    	registerpane.add(pn, 1, 4);
		    	Label vc = new Label("验证码");//验证码
		    	vc.setFont(Font.font("黑体",15));
		    	registerpane.add(vc, 0, 5);
		    	
		    	/*缺了验证码
		    	 * 
		    	 * 
		    	 * 
		    	 */
		    	    	
		    	TextField vericificationcode = new TextField();
		    	vericificationcode.setFont(Font.font("黑体",15));
		    	registerpane.add(vericificationcode, 1, 5);
		    	Button confirm = new Button("确定");
		    	confirm.setFont(Font.font("黑体",15));
		    	confirm.setTextFill(Color.WHITE);
		    	Button cancel = new Button("取消");
		    	cancel.setFont(Font.font("黑体",15));
		    	cancel.setTextFill(Color.WHITE);
		    	   
		    	HBox button = new HBox(10);
		    	button.setAlignment(Pos.BOTTOM_CENTER);
		    	button.getChildren().add(confirm);
		    	button.getChildren().add(cancel);
		    	confirm.setStyle("-fx-background-color:#7bbfea;");
		    	cancel.setStyle("-fx-background-color:#7bbfea;");
		    	registerpane.add(button, 1, 6);		
		    	registerpane.setMaxHeight(500);    	

		    	VBox v = new VBox(registerpane);
		    	v.setPadding(new Insets(0,220,0,220));
		    	
		    	GridPane l = new GridPane();
		    	l.setAlignment(Pos.TOP_LEFT);
			    ImageView iv2 = new ImageView();
			    iv2.setImage(logo);
		    	l.add(iv2, 0, 0);
		    	Text text = new Text();
		    	text.setText("酒店线上预订系统OBSH");
			    text.setFont(Font.font ("Verdana", 30));
			    Color pink = Color.rgb(218, 37, 246);
			    Color blue = Color.rgb(130, 127, 246);		    
			    text.setFill(new LinearGradient(0, 0, 1, 2, true, CycleMethod.REPEAT, new Stop[]{new Stop(0, pink), new Stop(0.5f, blue)}));	    
		    	l.add(text, 1, 0);
		    	l.setMinHeight(130);
		  
		    	VBox vb = new VBox(l,v);	  		    	
		    	Scene registerscene = new Scene(vb);
		    	registerscene.getStylesheets().add("main/register.css");
		    	stage1.setScene(registerscene);
		    	stage1.show();
		    	
		    	
		    	//注册的取消
		    	 cancel.setOnAction(e1->{
				    	stage1.close();
				    });
		    });
		    
		   
		    //登录
			btn.setOnAction(e->{
				Stage loginStage = new Stage();
				loginStage.setTitle("酒店线上预订系统OBSH");
				border = new BorderPane();
				HBox hbox = new HBox();
				border.setTop(hbox);
				tb1 = new ToggleButton ("搜索酒店");
				tb2 = new ToggleButton ("查看订单信息");
				tb3 = new ToggleButton ("维护个人信息");
				final ToggleGroup group = new ToggleGroup();
				tb1.setToggleGroup(group);
				tb2.setToggleGroup(group);
				tb3.setToggleGroup(group);
				
				Scene scene  = new Scene(border);
				scene.getStylesheets().add("main/application.css");
				loginStage.setScene(scene);
				loginStage.setWidth(1200);
				loginStage.setHeight(800);
				loginStage.show();
				/*添加一个客户的图标
					  * 
					  * 
					  * 
					  *  
					  */
				/*获得用户名
					  * 
					  */
				Text text = new Text();
				text.setText("客户: "+"username");//获得用户名
				text.getStyleClass().add("text");
				text.setFont(Font.font("SimSun"));
				border.setBottom(text);

				GridPane searchHotel = addGridPane();
				border.setCenter(searchHotel);
				group.selectedToggleProperty().addListener(
			            (ObservableValue<? extends Toggle> ov, 
			            Toggle toggle, Toggle new_toggle) -> {
			            	if (new_toggle == tb1){		            	
			            	border.setCenter(addVBox());
			            }			               
			            else if(new_toggle == tb2){
							border.setCenter(addOrderInfo());
			            }
			            else if(new_toggle == tb3){
			            	border.setCenter(maintainPersonalInfo());
			            }
			        });
	
				hbox.getChildren().addAll(tb1,tb2,tb3);
				hbox.setPadding(new Insets(15,15,15,15));	        
			});			
	   }
	  private VBox maintainPersonalInfo() {
		GridPane gp = new GridPane();
		gp.setHgap(20);
		gp.setVgap(20);
		gp.setPadding(new Insets(20,220,20,20));
		TextField nametf = new TextField();
		TextField idtf = new TextField();
		TextField phonetf = new TextField();
		TextField credittf = new TextField();
		TextField viptf = new TextField();
		gp.add(addText("名称"),0,0);
		gp.add(nametf,1,0);
		gp.add(addText("账号"),0,1);
		gp.add(idtf, 1, 1);
		gp.add(addText("联系方式"),0,2);
		gp.add(phonetf, 1, 2);
		gp.add(addText("信用值"), 0,3);
		gp.add(credittf, 1, 3);
		gp.add(addText("会员"),0,4);
		gp.add(viptf,1,4);
		
		VBox vb = new VBox();
		VBox vb1 = new VBox();
		Image image = new Image("/46.jpeg",0,0,false,false);
		ImageView iv = new ImageView();
		iv.setImage(image);	
		vb1.getChildren().add(iv);
		vb1.setPadding(new Insets(10,400,10,10));
		vb.getChildren().addAll(gp,vb1);
		return vb;
	}
	private VBox addOrderInfo() {
		VBox OrderVb = new VBox();
		OrderVb.setPrefSize(1200, 700);
		OrderVb.setSpacing(30);
		OrderVb.setPadding(new Insets(25,15,15,15));
		
		HBox hb = new HBox();
		ToggleButton tb1 = new ToggleButton("未执行正常订单");
		ToggleButton tb2 = new ToggleButton("已执行正常订单");
		ToggleButton tb3 = new ToggleButton("异常订单");
		ToggleButton tb4 = new ToggleButton("已撤销订单");
		final ToggleGroup tg = new ToggleGroup();
		
		tb1.setToggleGroup(tg);
		tb2.setToggleGroup(tg);
		tb3.setToggleGroup(tg);
		tb4.setToggleGroup(tg);
		hb.getChildren().addAll(tb1,tb2,tb3,tb4);
		tg.selectedToggleProperty().addListener(
				(ObservableValue<? extends Toggle> ov,
						Toggle toggle,Toggle new_toggle) ->{
							if(new_toggle == tb1){
								tb1.getStyleClass().add("ToggleButton1");
							}
							else if(new_toggle == tb2){
								tb2.getStyleClass().add("ToggleButton2");
							}
							else if(new_toggle == tb3){
								tb3.getStyleClass().add("ToggleButton3");
							}
							else if(new_toggle == tb4){
								tb4.getStyleClass().add("ToggleButton4");
							}
						});
		OrderVb.getChildren().add(hb);	
		
		//Orderlist
		final TableView table = new TableView();
		table.setEditable(true);	 
        TableColumn orderNum = new TableColumn("订单号");
        TableColumn reserveHotel = new TableColumn("预定酒店");
        TableColumn reverseTime = new TableColumn("预订时间");
        TableColumn orderState = new TableColumn("订单状态");
        table.getColumns().addAll(orderNum, reserveHotel, reverseTime,orderState);
        OrderVb.getChildren().add(table);
        Image image = new Image("/45.png",0,0,false,false);
		ImageView iv = new ImageView();
		iv.setImage(image);	
		iv.setFitWidth(1170);
		iv.setFitHeight(60);
		OrderVb.getChildren().add(iv);
		return OrderVb;
	}
	public VBox addVBox() {
		VBox vb = new VBox();
		vb.getStyleClass().add("Vbox");
		vb.setPrefSize(1200, 700);
		HBox searchLine = new HBox();
		Button search = new Button("搜索");
		search.getStyleClass().add("SearchButton");
		keywordtf.setPrefSize(100, 30);
		searchLine.getChildren().addAll(addText("入住"),addDatePicker(checkinDatePicker),
				addText("退房"),addDatePicker(checkoutDatePicker),addText("关键词"),addKeyWord(keywordtf),search);
		searchLine.setSpacing(10);
		vb.getChildren().add(searchLine);
		
		//位置
		HBox location = new HBox();
		location.getChildren().add(addText("位置"));
		location.getChildren().addAll(addComboBoxProvince(province),addComboBoxCity(city),
				addComboBoxDistrict(district),addComboBoxCommercial(commercial));
		location.setSpacing(15);
		vb.getChildren().add(location);
		
		//价格
		HBox price = new HBox();
		RadioButton rb1 = new RadioButton();
		rb1.setText("¥150以下");
		RadioButton rb2 = new RadioButton();
		rb2.setText("¥150-300");
		RadioButton rb3 = new RadioButton();
		rb3.setText("¥301-450");
		RadioButton rb4 = new RadioButton();
		rb4.setText("¥451-600");
		RadioButton rb5 = new RadioButton();
		rb5.setText("¥600以上");
		RadioButton rb6 = new RadioButton();
		rb6.setText("不限");
		price.setSpacing(10);
		price.getChildren().addAll(addText("价格"),rb1,rb2,rb3,rb4,rb5,rb6);
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
		CheckBox cb1 = new CheckBox("二星级及以下/经济");
		CheckBox cb2 = new CheckBox("三星级/舒适");
		CheckBox cb3 = new CheckBox("四星级/高档");
		CheckBox cb4 = new CheckBox("五星级/豪华");
		starLevel.setSpacing(10);
		starLevel.getChildren().addAll(addText("星级"),cb1,cb2,cb3,cb4);
		vb.getChildren().add(starLevel);
		
		//房间类型
		HBox roomType = new HBox();
		CheckBox c1 = new CheckBox("大床房");
		CheckBox c2 = new CheckBox("双床房");
		CheckBox c3 = new CheckBox("家庭房/三人");
		CheckBox c4 = new CheckBox("套间");
		roomType.setSpacing(10);
		roomType.getChildren().addAll(addText("房间类型"),c1,c2,c3,c4);
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
		ComboBox<String> star = new ComboBox<String>();
		star.getItems().addAll(starlist);
		star.getSelectionModel().select(0);
		Button history = new Button("预定历史");
		sequence.setSpacing(10);
		sequence.getChildren().addAll(popular,price1,mark,star,history);
		vb.getChildren().add(sequence);
		vb.getChildren().add(addHotel());
	
		return vb;
	}
	private HBox addHotel(){
		HBox hb = new HBox();
		
		//hotellist
		/*从数据库中获得酒店信息
		 * 
		 * 
		 * 
		 * 
		 */
		
		ScrollBar sc = new ScrollBar();
		sc.setLayoutX(hb.getWidth() - sc.getWidth());  
        sc.setMin(0);  
        sc.setOrientation(Orientation.VERTICAL);  
        sc.setPrefHeight(180);  
        sc.setMax(360);  
        sc.valueProperty().addListener((ov, old_val, new_val) -> {  
            hb.setLayoutY(-new_val.doubleValue());  
        });  
        hb.getChildren().add(sc);
		return hb;
	}
	private GridPane addGridPane() {
		   GridPane grid = new GridPane();
		   grid.setMaxSize(500, 300);
		   grid.getStyleClass().add("Gridpane");
		   grid.setHgap(10);
		   grid.setVgap(10);
		   grid.setPadding(new Insets(0, 10, 0, 10));
		   grid.setAlignment(Pos.CENTER_LEFT);
		   
		   HBox b1 = new HBox();
		   b1.setPadding(new Insets(10,10,10,10));
		   b1.setSpacing(10);
		   //目的地
		   b1.getChildren().add(addText("目的地"));
		   
		   /*如何从数据库中获得
		    * 
		    * 
		    * 
		    * 
		    * 
		    */
		   
		  
		   b1.getChildren().add(addComboBoxProvince(province));

		   b1.getChildren().add(addComboBoxCity(city));
		   CityInital(city,province);

		   b1.getChildren().add(addComboBoxDistrict(district));
		   
		   b1.getChildren().add(addComboBoxCommercial(commercial));
		   CommercialAndDistrictInital(commercial,district,city);
		   
		   HBox b2 = new HBox();
		   b2.setPadding(new Insets(10,10,10,10));
		   b2.setSpacing(10);		   
		   b2.getChildren().add(addText("入住日期"));
		   
		   //时间选择器		  
		   b2.getChildren().add(addDatePicker(checkinDatePicker));
		   checkinDatePicker.setValue(LocalDate.now());
		   b2.getChildren().add(addText("退房日期"));
	
		   b2.getChildren().add(addDatePicker(checkoutDatePicker));
		   HandleDatePicker(checkoutDatePicker, checkinDatePicker);
		   
		        
		        //关键词
				HBox b3 = new HBox();
				b3.setPadding(new Insets(10,10,10,10));
				b3.setSpacing(10);
				b3.getChildren().add(addText("关键词"));
				
				keywordtf.setPrefSize(360, 30);
				keywordtf.setPromptText("(选填)酒店名/地标/商圈");
				b3.getChildren().add(addKeyWord(keywordtf));
				 
				 HBox b5 = new HBox();
				 b5.setPadding(new Insets(10,10,10,305));
				 b5.setSpacing(10);
				 Button button = new Button();
				 button.setText("确定");
				 button.getStyleClass().add("Button");
				 button.setMinSize(180, 5);
				 button.setStyle("-fx-background-color:#fbcb45");
				 b5.getChildren().add(button);
				 
				 button.setOnAction((ActionEvent ev)->{
					 button.getStyleClass().add("ChangedButton");
					 VBox vb = addVBox();
					 border.setLeft(vb);
					 /*同时获得用户输入
					  * 
					  * 
					  * 
					  * 
					  * 
					  */
				 });
				 grid.add(b1, 0, 0);
				 grid.add(b2, 0, 1);
				 grid.add(b3, 0, 2);
				 grid.add(b5, 0, 3);
				 
				 HBox b4 = new HBox();
				 b4.setPadding(new Insets(10,10,10,10));
				 b4.setSpacing(10);
				 return grid;
		   }


	private void CommercialAndDistrictInital(ComboBox<String> commercial, ComboBox<String> district,ComboBox<String> city) {
		city.setOnAction((ActionEvent ev)->{
			   String City=city.getSelectionModel().getSelectedItem().toString();	
			   if(City=="合肥市"){
				   district.getItems().clear();
				   district.getItems().addAll(hefeishi);
				   district.getSelectionModel().select(0);
				   
				   commercial.getItems().clear();
				   commercial.getItems().addAll(hefeiDistrict);
				   commercial.getSelectionModel().select(0);
			   }
			   if(City=="澳门半岛"){
				   district.getItems().clear();
				   district.getItems().addAll(aomenbandao);
				   district.getSelectionModel().select(0);
				   }	
			   if(City=="澳门离岛"){
				   district.getItems().clear();
				   district.getItems().addAll(aomenlidao);
				   district.getSelectionModel().select(0);
			   }
		   });
	}
	private void CityInital(ComboBox<String> city, ComboBox<String> province) {
		province.setOnAction((ActionEvent ev)->{
			   String  Province= province.getSelectionModel().getSelectedItem().toString();			  
				   if(Province=="安徽"){
					   city.getItems().clear();
					   city.getItems().addAll(anhui);
					   city.getSelectionModel().select(0);
					   }	
				   if(Province=="澳门"){
					   city.getItems().clear();
					   city.getItems().addAll(aomen);
					   city.getSelectionModel().select(0);
				   }
			   });
	}
	private void HandleDatePicker(DatePicker checkoutDatePicker, DatePicker checkinDatePicker) {
		final Callback<DatePicker, DateCell> dayCellFactory = 
	            new Callback<DatePicker, DateCell>() {
	                @Override
	                public DateCell call(final DatePicker datePicker) {
	                    return new DateCell() {
	                        @Override
	                        public void updateItem(LocalDate item, boolean empty) {
	                            super.updateItem(item, empty);
	                           
	                            if (item.isBefore(
	                                    checkinDatePicker.getValue().plusDays(1))
	                                ) {
	                                    setDisable(true);
	                                    setStyle("-fx-background-color: #ffc0cb;");
	                            }   
	                            long p = ChronoUnit.DAYS.between(
	                                    checkinDatePicker.getValue(), item
	                            );
	                            setTooltip(new Tooltip(
	                                    "你将入住" + p + "天")
	                                );
	                    }
	                };
	            }
	        };
	        checkoutDatePicker.setDayCellFactory(dayCellFactory);
	        checkoutDatePicker.setValue(checkinDatePicker.getValue().plusDays(1));
	}
	private Text addText(String text){   
		   Text t = new Text(text);
		   t.setId(text);
		   t.getStyleClass().add("text");
		   return t;
	}
	private ComboBox<String> addComboBoxProvince(ComboBox<String> province){
		province.getItems().addAll(comboBox);
	    province.setTooltip(new Tooltip("选择省份"));
		province.setMinSize(100, 30);
		province.getSelectionModel().select(0);
		 return province;
	}
	private ComboBox<String> addComboBoxCity(ComboBox<String> city){
		city.getItems().addAll(anhui);
		city.setTooltip(new Tooltip("选择城市"));
		city.setMinSize(100, 30);
		city.getSelectionModel().select(0);
		 return city;
	}
	private ComboBox<String> addComboBoxDistrict(ComboBox<String> district) {
		 district.getItems().addAll(hefeishi);
		 district.setTooltip(new Tooltip("选择地区"));
		 district.setMinSize(100, 30);
		 district.getSelectionModel().select(0);
		return district;
	}
	private ComboBox<String> addComboBoxCommercial(ComboBox<String> commercial) {
		commercial.getItems().addAll(hefeiDistrict);
		commercial.getSelectionModel().select(0);
		commercial.setTooltip(new Tooltip("选择商圈"));
		commercial.setMinSize(100, 30);
		return commercial;
	}
	private DatePicker addDatePicker(DatePicker datePicker){
		datePicker.setMaxSize(172, 10);
		datePicker.setShowWeekNumbers(true);
		return datePicker;
	}
	private TextField addKeyWord(TextField keywordtf){
		keywordtf.setFont(Font.font("黑体",15));
		return keywordtf;
	}
	public static void main(String[] args) {
		launch(args);
	}
}

