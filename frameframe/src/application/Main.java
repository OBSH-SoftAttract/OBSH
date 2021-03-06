package application;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
	   @Override
	   public void start(Stage primaryStage) {
		    primaryStage.setTitle("酒店线上预订系统OBSH");
		    
		    GridPane grid1 = new GridPane();
		    grid1.setAlignment(Pos.TOP_CENTER);
		    grid1.setPadding(new Insets(10, 10, 10, 10));
		    
		    Image logo = new Image("application/logo.png",true);
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
		    
		    //创建文本输入框，放到第1列，第1行
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
		    	//registerpane.setStyle("-fx-background-color:#ffffff;");
		    	registerpane.setMaxHeight(500);    	

		    	VBox v = new VBox(registerpane);
		    	v.setPadding(new Insets(0,220,0,220));
		    	//v.setStyle("-fx-border-color: #cde6c7;");
		    	
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
		    	//vb.setStyle("-fx-background-color:#F0F8FF;");
		    	Scene registerscene = new Scene(vb);
		    	registerscene.getStylesheets().add("application/register.css");
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
				BorderPane border = new BorderPane();
				HBox hbox = new HBox();
				border.setTop(hbox);
				ToggleButton tb1 = new ToggleButton ("搜索酒店");
				ToggleButton tb2 = new ToggleButton ("查看订单信息");
				ToggleButton tb3 = new ToggleButton ("维护个人信息");
				final ToggleGroup group = new ToggleGroup();
				tb1.setToggleGroup(group);
				tb1.setSelected(true);
				tb2.setToggleGroup(group);
				tb3.setToggleGroup(group);
				
				//border.setStyle("-fx-background-color:#F0F8FF;");
				Scene scene  = new Scene(border);
				scene.getStylesheets().add("application/application.css");
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
				text.setId("text");
				border.setBottom(text);
				if(tb1.isSelected()){
					border.setLeft(addGridPane());
					}
				else if(tb2.isSelected()){
					border.setCenter(addVBox());
				}
				else if(tb3.isSelected()){
					
					
				}
				hbox.getChildren().addAll(tb1,tb2,tb3);
				hbox.setPadding(new Insets(15,15,15,15));
				
				/*分页
				 * 
				 * 
				 * 
				 * 
				 */
				
		        
			});	
			
	   }
	  public VBox addVBox() {
		VBox vb = new VBox();
		
		return vb;
	}
	public GridPane addGridPane() {
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
		   Text destination = new Text("目的地");
		   destination.setId("text");
		   b1.getChildren().add(destination);
		   
		   /*如何从数据库中获得
		    * 
		    * 
		    * 
		    * 
		    * 
		    */
		   ComboBox<String> comboBox = new ComboBox<String>(FXCollections.observableArrayList("安徽","澳门","北京","重庆","福建",
				   "甘肃","广东","广西","贵州","海南","河北","河南","黑龙江","湖北","湖南","吉林","江苏","江西","辽宁","内蒙古",
				   "宁夏","青海","山东","山西","陕西","上海","四川","台湾","天津","西藏","香港","新疆","云南","浙江"));
		   ComboBox<String> province = comboBox;
		   province.getSelectionModel().select(0);
		   province.setTooltip(new Tooltip("选择省份"));
		   province.setMaxSize(100, 10);
		   b1.getChildren().add(province);
		   		   
		   ObservableList<String> anhui = FXCollections.observableArrayList("合肥市","芜湖市","亳州市","马鞍山","池州市",
				   "淮南市","淮北市","蚌埠市","巢湖市","安庆市","宿州市","宣城市","滁州市","黄山市","六安市","阜阳市","铜陵市");
		   ObservableList<String> aomen = FXCollections.observableArrayList("澳门半岛","澳门离岛");
		   ComboBox<String>city = new ComboBox<String>();
		   city.getItems().addAll(anhui);
		   city.getSelectionModel().select(0);
		   city.setTooltip(new Tooltip("选择城市"));
		   city.setMaxSize(100, 10);
		   b1.getChildren().add(city);
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
		   ObservableList<String> hefeishi = FXCollections.observableArrayList("包河区","滨湖新区","长丰县","肥东县","肥西县","高新区","经济技术开发区","庐阳区","蜀山区","新站区","瑶海区","政务区");
		   ObservableList<String> aomenbandao = FXCollections.observableArrayList("花地玛堂区","圣安多尼堂区","大堂区","望德堂区","风顺堂区");
		   ObservableList<String> aomenlidao = FXCollections.observableArrayList("嘉模堂区","圣方济各堂区");
		   ComboBox<String> district = new ComboBox<String>();
		   district.getItems().addAll(hefeishi);
		   district.getSelectionModel().select(0);
		   district.setTooltip(new Tooltip("选择地区"));
		   district.setMaxSize(100, 10);
		   b1.getChildren().add(district);
		   //商圈
		   ObservableList<String> hefeiDistrict = FXCollections.observableArrayList("百货大楼","商之都","元一时代广场购物中心","新都会环球广场","鼓楼商厦");
		   ComboBox<String> commercial = new ComboBox<String>();
		   commercial.getItems().addAll(hefeiDistrict);
		   commercial.getSelectionModel().select(0);
		   commercial.setTooltip(new Tooltip("选择商圈"));
		   commercial.setMaxSize(120, 10);
		   b1.getChildren().add(commercial);
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
		   
		   HBox b2 = new HBox();
		   b2.setPadding(new Insets(10,10,10,10));
		   b2.setSpacing(10);
		   //入住日期，退房日期
		   Text checkinDate = new Text("入住日期");
		   checkinDate.setId("text");
		   b2.getChildren().add(checkinDate);
		   
		   //时间选择器
		   DatePicker checkinDatePicker = new DatePicker();
		   checkinDatePicker.setMaxSize(165, 10);
		   b2.getChildren().add(checkinDatePicker);
		   checkinDatePicker.setValue(LocalDate.now());
		   checkinDatePicker.setShowWeekNumbers(true);
		   
		   Text checkoutDate = new Text("退房日期");
		   checkoutDate.setId("text");
		   b2.getChildren().add(checkoutDate);
		   
		   DatePicker checkoutDatePicker = new DatePicker();
		   checkoutDatePicker.setMaxSize(165, 10);
		   b2.getChildren().add(checkoutDatePicker);
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
				checkoutDatePicker.setShowWeekNumbers(true);
				HBox b3 = new HBox();
				b3.setPadding(new Insets(10,10,10,10));
				b3.setSpacing(10);
				//关键词
				 Text keyword = new Text("关键词");
				 keyword.setId("text");
				 b3.getChildren().add(keyword);
				 
				 TextField keywordtf = new TextField();
				 keywordtf.setFont(Font.font("黑体",15));
				 keywordtf.setPrefSize(360, 30);
				 keywordtf.setPromptText("(选填)酒店名/地标/商圈");
				 b3.getChildren().add(keywordtf);
				 
				 HBox b5 = new HBox();
				 b5.setPadding(new Insets(10,10,10,310));
				 b5.setSpacing(10);
				 Button button = new Button();
				 button.setText("确定");
				 button.getStyleClass().add("Button");
				 button.setMinSize(180, 5);
				 button.setStyle("-fx-background-color:#fbcb45");
				 b5.getChildren().add(button);
				 
				 button.setOnAction((ActionEvent ev)->{
					 button.getStyleClass().add("ChangedButton");
					 /*获得用户输入
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
	   
	public static void main(String[] args) {
		launch(args);
	}
}
