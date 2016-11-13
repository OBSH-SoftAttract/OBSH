package bl.HotelRoombl;
import vo.HotelVo;
public interface HotelBLService {
	/**
	 * 
	 * @param hotelNo
	 * @return
	 */
	public int Addhotel (int hotelNo);
	/**
	 * 
	 * @return
	 */
	public void Updatehotel();
	/**
	 * 
	 * @param price
	 * @return
	 */
	public int Addprice(int price);
	/**
	 * 
	 * @param star
	 * @return
	 */
	public int Addstar(int star);
	/**
	 * 
	 * @param location
	 * @return
	 */
	public String Addlocation(String location);
	/**
	 * 
	 * @param summary
	 * @return
	 */
	public String Addsummary(String summary);
	/**
	 * 
	 * @param services
	 * @return
	 */
	public String Addservices(String services);
	/**
	 * 
	 * @param kind
	 * @return
	 */
	public String Addkind(String kind);
}

