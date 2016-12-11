package presentation.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class OrderView {
	//跳至查看订单信息主界面
		private ToggleButton tb1 = new ToggleButton("未执行正常订单");
		private ToggleButton tb2 = new ToggleButton("已执行正常订单");
		private ToggleButton tb3 = new ToggleButton("撤销订单");
		private ToggleButton tb4 = new ToggleButton("异常订单");
		
		public BorderPane jumptoCheckOrder(){	
			BorderPane border = new BorderPane();
			VBox vb = new VBox();
			final ToggleGroup tgroup = new ToggleGroup();
			tb1.setToggleGroup(tgroup);
			tb2.setToggleGroup(tgroup);
			tb3.setToggleGroup(tgroup);
			tb4.setToggleGroup(tgroup);
			vb.getChildren().addAll(tb1,tb2,tb3,tb4);
			vb.setSpacing(100);
			vb.setPadding(new Insets(100,10,0,0));
			
		    OrderList orderlist = new OrderList();
		    HBox orderhb = orderlist.addOrderList();
			border.setLeft(vb);
			border.setCenter(orderhb);

			border.getStyleClass().add("ordervb");
	        tb1.setId("ToggleButton");
	        tb2.setId("ToggleButton");
	        tb3.setId("ToggleButton");
	        tb4.setId("ToggleButton");
	        
	        tb1.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					tb1.setId("SelectedButton");
		    		tb2.setId("ToggleButton");
			        tb3.setId("ToggleButton");
			        tb4.setId("ToggleButton");
				}	        
	        });
	        tb2.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					tb1.setId("ToggleButton");
		    		tb2.setId("SelectedButton");
			        tb3.setId("ToggleButton");
			        tb4.setId("ToggleButton");
				}
	        });
	        tb3.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					tb1.setId("ToggleButton");
			        tb2.setId("ToggleButton");
		    		tb3.setId("SelectedButton");
			        tb4.setId("ToggleButton");
				}
	        });
	        tb4.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					tb1.setId("ToggleButton");
			        tb2.setId("ToggleButton");
			        tb3.setId("ToggleButton");
		    		tb4.setId("SelectedButton");
				}
	        });			  
	        border.setMaxSize(800, 550);
	        border.setPadding(new Insets(0,0,0,0));
	        return border;
		}
	}