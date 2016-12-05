package presentation.view;


import javafx.stage.Stage;

public interface UserViewControllerService {
	public int getUserId();
	public int getUserPassword();
	public void setView(UserView view);
	public boolean successLogin(int userId,String password);
	public void backtoMain(Stage primaryStage);
	public void jumptoSearchHotelMainFrame(Stage primaryStage);
	public void jumptoRegisterFrame(Stage primaryStage);
	public void jumptoUserMainFrame(Stage primaryStage);
	public String[] getHotelName();
	public String[] getRelatedHotelStarLevel();
	public String[] getRelatedHotelPrice();
	public String[] getRelatedHotelMark();
	public void jumptoCheckOrder(Stage primaryStage);
	public void jumptoMaintainPersonalInfo(Stage primaryStage);

}