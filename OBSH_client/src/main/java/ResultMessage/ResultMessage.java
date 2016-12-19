package ResultMessage;

import java.io.Serializable;

public enum ResultMessage implements Serializable{
   WrongPassword,PASS,NotExist,NULL,
   FormatWrong,IDExsit,Success,
   UpdateSuccess,UpdateFail,
   OverTime,InTime,StateWrong,
   CreditMet,CreditWrong,
   Common,Company,Person,
}
