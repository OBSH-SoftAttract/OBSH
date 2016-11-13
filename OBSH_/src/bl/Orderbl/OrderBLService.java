package bl.Orderbl;
import java.util.ArrayList;

import po.OrderPo;
import vo.OrderVo;
import vo.PromotionVo;

public interface OrderBLService{
	
	/**
	 * @param   ordervo
	 * @return	将订单状态改为已撤销
	 */
	public boolean Cancellation(OrderVo ordervo);
	
	/**
	 * @param   ordervo
	 * @return  返回订单开始到现在时间的时间差
	 */
	public String CancelTime (OrderVo ordervo);
	
	/**
	 * @param   ordervo
	 * @return  扣除用户的信用值
	 */
	public boolean CancelKillCredit(OrderVo ordervo);
	
	/**
	 * 
	 * @param score
	 * @param comment
	 * @param ordervo
	 * @return 提交订单评语
	 */
	public boolean Assess(int score,String comment,OrderVo ordervo);
	
	/**
	 * 
	 * @param ordervo
	 * @return 添加订单
	 */
	public boolean Add(OrderVo ordervo); 
	
	/**
	 * 
	 * @param ordervo
	 * @return 检查信用值是否满足下单要求
	 */
	public boolean CreditCheck(OrderVo ordervo) ;
	
	/**
	 * 
	 * @param userid
	 * @return 获得符合该用户的最优策略
	 */
	public PromotionVo CalPromotion(int userid);
	
	/**
	 * 
	 * @param vo1
	 * @param vo2
	 * @return 获得订单价格
	 */
	public OrderVo CalPrice(PromotionVo vo1,OrderVo vo2);
	
	/**
	 * 
	 * @param vo
	 * @return 	处理订单	
	 */
	public boolean Solve(OrderVo vo);
	
	/**
	 * 
	 * @param vo
	 * @return 处理用户申诉
	 */
	public boolean ComplainDeal(OrderVo vo);
	
	/**
	 * 
	 * @param orderid
	 * @return 获得对应ID的订单对象
	 */
	public OrderVo ViewByID (int orderid);
	
	/**
	 * 
	 * @param userid
	 * @return 获得对应用户的所有订单
	 */
	public ArrayList<OrderVo> Views(int userid);
	
	/**
	 * 
	 * @param id
	 * @return 获得对应客户的订单
	 */
	public ArrayList<OrderVo> ViewByCustom(int id);
	
	/**
	 * 
	 * @param date
	 * @return 获得对应日期的订单列表
	 */
	public ArrayList<OrderVo> ViewByDaily(String date);
	
	/**
	 * 
	 * @param state
	 * @return 获得
	 */
	public ArrayList<OrderVo> ViewByState(int state);
	
	/**
	 * 
	 * @param orderlist
	 * @return 获得按时间排序
	 */
	public ArrayList<OrderVo> TimeSort ( ArrayList<OrderVo> orderlist);
	
	/**
	 * 
	 * @return 获得一个新的订单号
	 */
	public int CreateID();
}