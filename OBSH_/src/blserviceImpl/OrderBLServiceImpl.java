package blserviceImpl;

import java.util.ArrayList;

import blservice.OrderBLService;
import vo.OrderVo;
import vo.PromotionVo;

public class OrderBLServiceImpl implements OrderBLService{

	@Override
	public boolean Cancellation(OrderVo ordervo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String CancelTime(OrderVo ordervo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean CancelKillCredit(OrderVo ordervo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Assess(int score, String comment, OrderVo ordervo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Add(OrderVo ordervo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean CreditCheck(OrderVo ordervo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PromotionVo CalPromotion(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVo CalPrice(PromotionVo vo1, OrderVo vo2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Solve(OrderVo vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ComplainDeal(OrderVo vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderVo ViewByID(int orderid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVo> Views(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVo> ViewByCustom(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVo> ViewByDaily(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVo> ViewByState(int state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVo> TimeSort(ArrayList<OrderVo> orderlist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int CreateID() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}