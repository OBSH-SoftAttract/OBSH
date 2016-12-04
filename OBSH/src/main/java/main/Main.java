package main;
import client_rmi.client_run;
import javafx.application.Application;
import javafx.stage.Stage;
import presentation.controller.UserViewControllerImpl;
import presentation.view.UserView;
import presentation.view.UserViewControllerService;

public class Main extends Application{
	public static void main(String[]args){
		client_run run=new client_run();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		int userid = 151250004;
		UserViewControllerService controller = new UserViewControllerImpl(userid);
		UserView view = new UserView(controller);
		primaryStage = view.Main();
		controller.setView(view);
	}
}

