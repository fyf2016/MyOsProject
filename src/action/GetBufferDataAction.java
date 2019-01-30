package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SetParamDao;
import dao.SetParamDaoImpl;
import entity.BufferData;
import entity.Param;
import net.sf.json.JSONArray;
import thread.StartThread;

/**
 * Servlet implementation class GetBuffer1DataAction
 */
@WebServlet("/GetBuffer1DataAction")
public class GetBufferDataAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 req.setCharacterEncoding("utf-8");
	     res.setContentType("application/json;charset=utf-8");
	     SetParamDao setParamDao = new SetParamDaoImpl();  
	     ArrayList<BufferData> Buffer1DataList = setParamDao.queryBufferData(1);
	     ArrayList<BufferData> Buffer2DataList = setParamDao.queryBufferData(2);
	     ArrayList<BufferData> Buffer3DataList = setParamDao.queryBufferData(3);
	     String type = req.getParameter("type");
	     PrintWriter pw = res.getWriter();
	     Param params = setParamDao.selectParamsById(1);
	     String start = req.getParameter("start");
	     if("true".equals(start)) {
	    	 StartThread.start(params);
	     }
	     
	     
	     if("1".equals(type)) {
	    	 	JSONArray jsonArray = JSONArray.fromObject(Buffer1DataList);
				pw.println(jsonArray);
			
		 }else if("2".equals(type)){
				JSONArray jsonArray = JSONArray.fromObject(Buffer2DataList);
				pw.println(jsonArray);
			
		 }else if("3".equals(type)){
				JSONArray jsonArray = JSONArray.fromObject(Buffer3DataList);
				pw.println(jsonArray);
		 }
	 	 
	 	 
	}

}
