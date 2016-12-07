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
	public boolean succeedtoFindUser(String userId);
	public void modifyUserInfo(String name, String phone, String credit);
	public String getUserName(String userId);
	public String getUserPhone(String userId);
	public String getUserCredit(String userId);
	public boolean checkHotelWorker(String hotelname);
	public String setHotelId(String hotelname);
	public void saveHotelWorkerInfo(String hotelname, String hotelworkerpassword);
	public boolean checkpasswordequal(String hotelworkerpassword, String hotelworkerpasswordconfirm);
}


