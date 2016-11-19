package mainframe;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

public class Mainframe extends Application {	
	final int WIDTH = 900;
    final int HEIGHT = 675;
	   @Override
	   public void start(Stage primaryStage) {
		    primaryStage.setTitle("酒店线上预订系统OBSH");
		    
		    GridPane grid1 = new GridPane();
		    grid1.setAlignment(Pos.TOP_LEFT);
		    grid1.setPadding(new Insets(10, 10, 10, 10));
		    
		    Image logo = new Image("/logo.png",true);
		    ImageView iv = new ImageView();
		    iv.setImage(logo);
		    grid1.add(iv,1,1);
		    
		    GridPane grid2 = new GridPane();
		    grid2.setAlignment(Pos.TOP_CENTER);
		    grid2.setVgap(20);
		    grid2.setPadding(new Insets(10, 10, 10, 10));
		   
		    Text text = new Text();
		    text.setText("酒店线上预订系统OBSH");
		    text.setFont(Font.font ("Verdana", 30));
		    Color pink = Color.rgb(218, 37, 246);
		    Color blue = Color.rgb(130, 127, 246);		    
		    text.setFill(new LinearGradient(0, 0, 1, 2, true, CycleMethod.REPEAT, new Stop[]{new Stop(0, pink), new Stop(0.5f, blue)}));
		    grid2.add(text,0,2);

		    GridPane grid3 = new GridPane();
		    grid3.setAlignment(Pos.CENTER_LEFT);
		    grid3.setHgap(20);
		    grid3.setVgap(20);
		    grid3.setPadding(new Insets(10, 10, 40, 30));
		    
		    Text t1 = new Text();
		    t1.setText("生活中的美好之物");
		    t1.setFont(Font.font("宋体",14));
		    t1.setFill(new LinearGradient(0, 0, 1, 2, true, CycleMethod.REPEAT, new Stop[]{new Stop(0, pink), new Stop(0.5f, blue)}));
		    Text t2 = new Text();
		    t2.setText("      就是出现的恰到好处");
		    t2.setFont(Font.font("宋体",14));
		    t2.setFill(new LinearGradient(0, 0, 1, 2, true, CycleMethod.REPEAT, new Stop[]{new Stop(0, pink), new Stop(0.5f, blue)}));
		    grid3.add(t1,0,0);
		    grid3.add(t2,0,1);
		    
		    GridPane grid4 = new GridPane();
		    grid4.setAlignment(Pos.CENTER);
		    grid4.setPadding(new Insets(0, 10, 0, 10));
		    
		    Image illustration = new Image("/插画.jpg",300,390,false,false);//插画
		    ImageView iv2 = new ImageView();
		    iv2.setImage(illustration);
		    grid4.add(iv2,0,0);
		    
		    GridPane grid5 = new GridPane();
		    grid5.setMaxSize(360, 390);
		    grid5.setAlignment(Pos.CENTER_RIGHT);
		    grid5.setHgap(20);
		    grid5.setVgap(20);
		    grid5.setPadding(new Insets(10, 10, 10, 10));
		    
		    Text welcome = new Text("Welcome");
		    welcome.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));  
		    grid5.add(welcome,1,0);
		    
		    
		    //创建Label对象，放到第0列，第1行
		    Label userName = new Label("用户名:");
		    grid5.add(userName,1,1);
		    
		    //创建文本输入框，放到第1列，第1行
		    TextField userTextField = new TextField();
		    grid5.add(userTextField,2,1);
		    
		    Label pw = new Label("密码:");
		    grid5.add(pw,1,2);
		    
		    PasswordField pwBox = new PasswordField();
		    grid5.add(pwBox,2,2);
		    
		    Button btn = new Button("登录");
		    btn.setTextFill(Color.ALICEBLUE);
		    btn.setMinSize(160, 14);
		    HBox hbBtn = new HBox(10);
		    hbBtn.setAlignment(Pos.BOTTOM_CENTER);
		    hbBtn.getChildren().add(btn);//将按钮控件作为子节点
		    grid5.add(hbBtn,2,3);//将HBox pane放到grid中的第1列，第4行
		    
		    btn.setOnAction(new EventHandler<ActionEvent>() {//注册事件handler
		    	@Override
		    	public void handle(ActionEvent e) {
		  
		    		}
		    	});
		    
		    HBox root1 = new HBox(grid1,grid2);
		    HBox root2 = new HBox(grid3,grid4,grid5);
		    VBox root = new VBox(root1,root2);
		    primaryStage.setScene(new Scene(root));
		    primaryStage.setWidth(WIDTH);
		    primaryStage.setHeight(HEIGHT);
		    primaryStage.show();
		    }	 
	   public static void main(String[] args) {
	       launch(args);
	   }
	}
