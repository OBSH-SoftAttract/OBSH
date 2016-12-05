package blserviceImpl;

import java.rmi.RemoteException;
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
	public int judge(int id) throws RemoteException{
		if(id<1000)return 1;
		return 0;
	}

	@Override
	public boolean createNewItem(PromotionVo vo) throws RemoteException{
		return promotiondao.addPromotionPo(new PromotionPo(vo));
	}

	@Override
	public boolean Del(PromotionVo vo) throws RemoteException{
		return promotiondao.deletePromotionPo(vo.getItemName());
	}

	@Override
	public List<PromotionPo> getPromotions() throws RemoteException{		
		return promotiondao.getLineItem();
	}

}
