package blserviceImpl;

import java.sql.Date;
import blservice.CreditBLService;
import blservice.MemberBLService;
import data.dao.MemberDao;
import data.dao.impl.MemberDaoImpl;
import po.MemberPo;

public class MemberBLServiceImpl implements MemberBLService{

	private MemberDao memberdao;
	private CreditBLService creditbl;
	
	public MemberBLServiceImpl(){
		memberdao = MemberDaoImpl.getInstance();
		creditbl=new CreditBLServiceImpl();
	}
	
	@Override
	public void createByPersonal(int id, Date birthday) {
		// TODO Auto-generated method stub
		
		MemberPo memberPo = new MemberPo();
		memberPo.setUserId(id);
		memberPo.setBirthday(birthday);
		memberPo.setRank(getMemberRank(id));
		memberPo.setMemberInfo("Person");
		memberdao.addMemberPo(memberPo);
		
	}

	@Override
	public void createByBusiness(int id, String name) {
		// TODO Auto-generated method stub
		
		MemberPo memberPo = new MemberPo();
		memberPo.setUserId(id);
		memberPo.setCorpoatename(name);
		memberPo.setRank(getMemberRank(id));
		memberPo.setMemberInfo("Company");
		memberdao.addMemberPo(memberPo);
		
	}

	@Override
	public int getMemberRank(int id) {
		// TODO Auto-generated method stub

		int rank = 0;
		double credit = creditbl.getCredit(id).getCreditResult();
		if(credit>=1000){
			credit-=1000;
			while(credit>0){
				credit-=3000;
				credit++;
			}
			return rank;
		}
		else		
		  return rank;
	}

	@Override
	public boolean isMember(int id) {
		// TODO Auto-generated method stub
		return memberdao.isMember(id);
	}

}
