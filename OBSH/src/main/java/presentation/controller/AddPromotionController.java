package presentation.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import presentation.view.AddPromotion;

/**
 * @author bxh
 *
 */
public class AddPromotionController {
	
	private AddPromotion addPromotion;
	
	@FXML
	private TextField name;
	
	@FXML
	private TextField start;
	
	@FXML
	private TextField end;
	
	@FXML
	private TextField info;
	
	@FXML
	private TextField count;
	
	/**
	 * 添加策略的方法
	 */
	@FXML
	private void setPromotion() {
		String itemName = name.getText();      //策略名称
		String startTime = start.getText();    //javafx里有datepicker 先用string代替 同理下面的都需要转化
		String endTime = end.getText();        //策略结束时间
		String promotionInfo = info.getText(); //策略信息
		String discount = count.getText();     //折扣
		
		
	}
	
	@FXML
	private void CloseStage(){
		addPromotion.getPrimaryStage().close();
	}
	
	@FXML
	private void close(){
		addPromotion.getPrimaryStage().close();
	}

	@FXML
	private void minimizeStage() {
		addPromotion.getPrimaryStage().setIconified(true); 
	}
	
	public void setAddPromotion(AddPromotion addPromotion) {
		// TODO Auto-generated method stub
		this.addPromotion = addPromotion;
		
	}


}