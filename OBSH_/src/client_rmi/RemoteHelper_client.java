package client_rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import blservice.CreditBLService;
import blservice.HotelBLService;
import blservice.HotelroomBLService;
import blservice.MemberBLService;
import blservice.OrderBLService;
import blservice.PromotionBLService;
import blservice.UserBLService;

public class RemoteHelper_client {
    private RemoteHelper_client remotehelper;
    private Remote remote;
	public void linkToServer() {
		try {
			remotehelper.setRemote(Naming.lookup("rmi://localhost:8888/DataRemoteObject"));
			System.out.println("the client has linked");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	private void setRemote(Remote remote){
		this.remote = remote;
	}
	
	public UserBLService getUserBLService(){
		return (UserBLService)remote;
	}
	public PromotionBLService getPromotionBLService(){
		return (PromotionBLService)remote;
	}
	public CreditBLService getCreditBLService(){
		return (CreditBLService)remote;
	}
	public HotelBLService getHotelBLService(){
		return (HotelBLService)remote;
	}
	public OrderBLService getOrderBLService(){
		return (OrderBLService)remote;
	}
	public MemberBLService getMemberBLService(){
		return (MemberBLService)remote;
	}
	public HotelroomBLService getHotelroomBLService(){
		return (HotelroomBLService)remote;
	}
}
