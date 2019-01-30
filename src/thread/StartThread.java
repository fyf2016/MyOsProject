package thread;

import dao.SetParamDao;
import dao.SetParamDaoImpl;
import entity.Param;
import task.Common;
import task.GetBuffer;
import task.MoveBuffer;
import task.PutBuffer;

public class StartThread {
	public static void main(String[] args) {
		StartThread a = new StartThread();
		 SetParamDao setParamDao = new SetParamDaoImpl();
	     Param params = setParamDao.selectParamsById(1);
		 a.start(params);
	}
	public static void start(Param param){
		
		Common.setParams(param);
		
		for(int i=0;i<param.getPutBuffer1Num();i++) {
			Common common = new Common(param);
			new Thread(new PutBuffer(common)).start();
		}
	
		for(int i=0;i<param.getMoveBuffer2Num();i++) {
			Common common = new Common(param);
			common.setPlace(2);
			new Thread(new MoveBuffer(common)).start();
		}
		for(int i=0;i<param.getMoveBuffer3Num();i++) {
			Common common = new Common(param);
			common.setPlace(3);
			new Thread(new MoveBuffer(common)).start();
		}
		for(int i=0;i<param.getGetBuffer2Num();i++) {
			Common common = new Common(param);
			common.setPlace(2);
			new Thread(new GetBuffer(common)).start();
		}
		for(int i=0;i<param.getGetBuffer3Num();i++) {
			Common common = new Common(param);
			common.setPlace(3);
			new Thread(new GetBuffer(common)).start();
		}
	}

}
