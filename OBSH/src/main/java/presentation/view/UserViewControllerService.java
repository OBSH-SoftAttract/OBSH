package presentation.view;

public interface UserViewControllerService {
	public int getUserId();
	public int getUserPassword();
	public void setView(UserView view);
	public boolean successLogin(int userId,String password);
	public void backtoMain();
	public void jumptoSearchHotelMainFrame();
	public String[] getProvince();
	public String[] getRelatedCity(int p);
	public String[] getRelatedDistrict(int c);
	public String[] getRelatedCommercial(int d);
	public void jumptoRegisterFrame();
	public void jumptoUserMainFrame();
	public String[] getHotelName();
	public String[] getRelatedHotelStarLevel();
	public String[] getRelatedHotelPrice();
	public String[] getRelatedHotelMark();
}


