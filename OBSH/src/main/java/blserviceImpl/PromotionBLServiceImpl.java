package blserviceImpl;

import java.util.List;

import blservice.PromotionBLService;
import data.dao.PromotionDao;
import data.dao.impl.PromotionDaoImpl;
import po.PromotionPo;
import vo.PromotionVo;

public class PromotionBLServiceImpl implements PromotionBLService{

	
	private PromotionDao promotiondao;
	
	public PromotionBLServiceImpl(){
		promotiondao=PromotionDaoImpl.getInstance();
	}
	@Override
	public int judge(int id) {
		
		return 0;
	}

	@Override
	public PromotionVo createNewItem(PromotionVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Del(PromotionVo vo) {
		return promotiondao.deletePromotionPo(vo.getItemName());
	}

	@Override
	public boolean update(PromotionVo vo) {
		
		return false;
	}

	@Override
	public List<PromotionPo> getLineItem(String itemName) {
		
		return null;
	}

}
