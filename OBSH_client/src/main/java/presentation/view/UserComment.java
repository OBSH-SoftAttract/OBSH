package presentation.view;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class UserComment {	
	String[]comment= {"user1:xxxx","user2:xxxx","user3:xxxx"};
	public VBox addUserComment(){
		VBox v = new VBox();
		int length = comment.length;
		for(int i=0;i<length;i++){
			v.getChildren().add(addText(comment[i]));
		}
		v.setSpacing(20);
		return v;
	}
	//对text的字体设定
	public Text addText(String s){
		Text text = new Text(s);
		text.setFont(Font.font("冬青黑体简体中文",15));
		return text;
	}

}
