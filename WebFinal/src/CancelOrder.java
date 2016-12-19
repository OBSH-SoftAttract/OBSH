package presentation.view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.controller.CancelOrderController;

public class CancelOrder extends Application {

    private Stage primaryStage;
	private double xOffset = 0;
	private double yOffset = 0;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.TRANSPARENT); 
        
	    try{
	    	FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("CancelOrder.fxml"));
	        BorderPane frame = (BorderPane) loader.load();
	        enableDragging(frame);
	        
	        Scene scene = new Scene(frame);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        CancelOrderController controller = loader.getController();
	        controller.setCancelOrder(this);
	    }catch(Exception e){
	       	e.printStackTrace();
	    }
	}

	/**
	 * 实现窗口可拖拽
	 * @param root
	 */
	private void enableDragging(BorderPane root) {

		root.setOnMousePressed(new EventHandler<MouseEvent>() {  
            @Override  
            public void handle(MouseEvent event) {  
                xOffset = event.getSceneX();  
                yOffset = event.getSceneY();  
            }  
        });  
		root.setOnMouseDragged(new EventHandler<MouseEvent>() {  
            @Override  
            public void handle(MouseEvent event) {  
                primaryStage.setX(event.getScreenX() - xOffset);  
                primaryStage.setY(event.getScreenY() - yOffset);  
            }  
        }); 
	}
	
    /**
     * Returns roomMessage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
	public static void main(String[] args) {
		launch(args);
	}

}