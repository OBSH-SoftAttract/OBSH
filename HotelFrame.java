package mainframe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HotelFrame {
	public  BorderPane hotelFrame(BorderPane mainFrame,String hotelname,String mark,String price,String orderState){
		BorderPane border = new BorderPane();
		GridPane gp = new GridPane();
		//获取选中酒店的简介和设施服务和星级
		String starlevel = "5";
		String introduction = "";
		String[]service = {"0","1","1","0"};
		HBox hb1 = new HBox();
		Text hotelnameT = new Text();
		hotelnameT.setText(hotelname);
		Text priceT = new Text();
		priceT.setText(price+"起");
		Text markT = new Text();
		markT.setText(mark+"/5分");
		hb1.getChildren().addAll(hotelnameT,markT,priceT);
		hb1.setSpacing(15);
		hb1.setAlignment(Pos.TOP_CENTER);
		gp.add(hb1, 0, 0);
		
		HBox hb2 = new HBox();		
		HBox starhb = new HBox();
		Button star1 = new Button();
		Button star2 = new Button();
		Button star3 = new Button();
		Button star4 = new Button();
		Button star5 = new Button();
		star1.setMaxSize(20, 20);
		star1.setMinSize(20, 20);
		star2.setMaxSize(20, 20);
		star2.setMinSize(20, 20);
		star3.setMaxSize(20, 20);
		star3.setMinSize(20, 20);
		star4.setMaxSize(20, 20);
		star4.setMinSize(20, 20);
		star5.setMaxSize(20, 20);
		star5.setMinSize(20, 20);
		starhb.getChildren().addAll(star1,star2,star3,star4,star5);
		if(starlevel.equals("1")){
			star1.setId("Yellowstar");
    		star2.setId("Whitestar");
    		star3.setId("Whitestar");
    		star4.setId("Whitestar");
    		star5.setId("Whitestar");
		}
		else if(starlevel.equals("2")){
			star1.setId("Yellowstar");
        	star2.setId("Yellowstar");
        	star3.setId("Whitestar");
    		star4.setId("Whitestar");
    		star5.setId("Whitestar");
		}
		else if(starlevel.equals("3")){
			star1.setId("Yellowstar");
        	star2.setId("Yellowstar");
        	star3.setId("Yellowstar");
    		star4.setId("Whitestar");
    		star5.setId("Whitestar");
		}
		else if(starlevel.equals("4")){
			star1.setId("Yellowstar");
        	star2.setId("Yellowstar");
        	star3.setId("Yellowstar");
    		star4.setId("Yellowstar");
    		star5.setId("Whitestar");
		}
		else if(starlevel.equals("5")){
			star1.setId("Yellowstar");
        	star2.setId("Yellowstar");
        	star3.setId("Yellowstar");
        	star4.setId("Yellowstar");
        	star5.setId("Yellowstar");
		}
		HBox servicehb = new HBox();
		Image wifi = new Image("/wifi.png");
		ImageView wifiview = new ImageView();
		wifiview.setImage(wifi);
		HBox wifihb = new HBox();
		wifihb.getChildren().add(wifiview);
		wifihb.setMaxSize(20, 20);
		Image plane = new Image("/plane.png");
		ImageView planeview = new ImageView();
		planeview.setImage(plane);
		HBox planehb = new HBox();
		planehb.getChildren().add(planeview);
		planehb.setMaxSize(20, 20);
		Image taxi = new Image("/taxi.png");
		ImageView taxiview = new ImageView();
		taxiview.setImage(taxi);
		HBox taxihb = new HBox();
		taxihb.getChildren().add(taxiview);
		taxihb.setMaxSize(25, 25);
		Image food = new Image("/food.png");
		ImageView foodview = new ImageView();
		foodview.setImage(food);
		HBox foodhb = new HBox();
		foodhb.getChildren().add(foodview);
		foodhb.setMaxSize(25, 25);
		if(service[0].equals("1")){
			servicehb.getChildren().add(wifihb);
		}
		if(service[1].equals("1")){
			servicehb.getChildren().add(planehb);
		}
		if(service[2].equals("1")){
			servicehb.getChildren().add(taxihb);
		}
		if(service[3].equals("1")){
			servicehb.getChildren().add(foodhb);
		}
		hb2.setSpacing(20);
		hb2.getChildren().addAll(starhb,servicehb);
		hb2.setAlignment(Pos.TOP_CENTER);
		gp.add(hb2, 0, 1);
		Text introductionT = new Text();
		introductionT.setText("简介:"+introduction);
		gp.add(introductionT, 0,3);
		gp.setVgap(10);
		gp.setAlignment(Pos.TOP_CENTER);
		
		Button tb1 = new Button("房型列表");
		tb1.setId("ChangeTb");
		//优惠套餐还有疑惑
		Button tb2 = new Button("优惠套餐");
		tb2.setId("Tb");
		Button tb3 = new Button("用户评价");
		tb3.setId("Tb");
		HBox hb = new HBox();
		hb.setSpacing(2);
		hb.getChildren().addAll(tb1,tb2,tb3);
		gp.add(hb, 0, 4);
		AddRoomList rl = new AddRoomList();
		VBox vb1 = rl.addRoomList(hotelname);
	    PrePrice pp = new PrePrice();
	    VBox vb2 = pp.addPrePrice(mainFrame,hotelname);
	    UserComment uc = new UserComment();
	    VBox vb3 = uc.addUserComment();
		border.setTop(gp);
		border.setCenter(vb1);
		tb1.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				tb1.setId("ChangeTb");
				tb2.setId("Tb");
				tb3.setId("Tb");
				border.setCenter(vb1);
			}
		});
		tb2.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				tb1.setId("Tb");
				tb2.setId("ChangeTb");
				tb3.setId("Tb");
				border.setCenter(vb2);
			}
		});
		tb3.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				tb1.setId("Tb");
				tb2.setId("Tb");
				tb3.setId("ChangeTb");
				border.setCenter(vb3);
			}
		});
		gp.setPadding(new Insets(30,0,0,0));
		gp.setMaxSize(600, 200);
		gp.setMinSize(600, 200);
		hotelnameT.getStyleClass().add("Hotelname");
		priceT.getStyleClass().add("Price");
		markT.getStyleClass().add("Mark");
		introductionT.setId("Introduction");
		return border;
		}
}
