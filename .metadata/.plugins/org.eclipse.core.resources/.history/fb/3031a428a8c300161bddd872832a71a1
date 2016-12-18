package presentation.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Comment {
	
	UserViewControllerService controller;
	public Comment( UserViewControllerService controller) {
		this.controller = controller;
	}
	
	public void showstage(){
		Text text = new Text("请输入您的评价：");
		TextArea t = new TextArea();
		t.setMaxSize(300, 200);
		Button button = new Button("确定");
		VBox vb = new VBox();
		vb.setSpacing(20);
		vb.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(text,t,button);
		vb.setMaxSize(400, 300);
		Scene scene = new Scene(vb);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		button.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				stage.close();
				
			}
		});
	}
}
