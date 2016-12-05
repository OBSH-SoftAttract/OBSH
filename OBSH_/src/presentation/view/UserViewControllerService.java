package presentation.view;

import java.util.List;
import po.HotelPo;

public interface UserViewControllerService {
	public int getUserId();
	public int getUserPassword();
	public void setView(UserView view);
	public boolean successLogin(int userId,String password);
	public String[] getHotelName();
	public String[] getRelatedHotelStarLevel();
	public String[] getRelatedHotelPrice();
	public String[] getRelatedHotelMark();
	public void SortbyPopularity();
	public List<HotelPo> Views(String address, String commercial);
	public void registeruser(String username, String password, String conpassword, String phonenum);
}


