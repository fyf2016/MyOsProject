package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SetParamDao;
import dao.SetParamDaoImpl;
import entity.Result;
import net.sf.json.JSONArray;
import task.Common;

/**
 * Servlet implementation class PauseAction
 */
@WebServlet("/PauseAction")
public class PauseAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
	    res.setContentType("application/json;charset=utf-8");
	    String pause = req.getParameter("pause");
	    HttpSession session = req.getSession();
	    PrintWriter pw = res.getWriter();
	     
	    if("true".equals(pause)) {
	    	Common.pause = true;
	    }else if("false".equals(pause)){
	    	Common.pause = false;
	    }else if("end".equals(pause)) {
	    	Common.endTime = System.currentTimeMillis();
	    	long timeCost = Common.endTime-Common.startTime;
	    	Result result = new Result();
	    	
	    	result.setRuntime(String.valueOf(timeCost));
	    	result.setBufferDataNum(Common.buffer1.size()+Common.buffer2.size()+Common.buffer3.size());
	    	result.setPutInBufferNum(Common.putInBufferNum);
	    	result.setGetOutBufferNum(Common.getOutBufferNum);
	    	result.setAvgBufferNum((Common.buffer1.size()+Common.buffer2.size()+Common.buffer3.size())/3);	
	    	SetParamDao setParamDao = new SetParamDaoImpl();
	    	setParamDao.setResult(result);
	    	Common.flag = false;
	    	JSONArray resultData = JSONArray.fromObject(result);
	    	pw.println(resultData);
	    	
	    }
	    
	}
  

}
