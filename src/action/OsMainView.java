package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SetParamDao;
import dao.SetParamDaoImpl;
import entity.BufferData;
import entity.Param;
import thread.StartThread;

/**
 * Servlet implementation class OsMainView
 */
@WebServlet("/OsMainView")
public class OsMainView extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 req.setCharacterEncoding("utf-8");
	     res.setContentType("application/json;charset=utf-8");
	     HttpSession session = req.getSession();
	     Param setParam = new Param();
	    
	     setParam.setBufferSize1(Integer.valueOf(req.getParameter("buffer1Size")));
	     setParam.setBufferSize2(Integer.valueOf(req.getParameter("buffer2Size")));
	     setParam.setBufferSize3(Integer.valueOf(req.getParameter("buffer3Size")));
	     setParam.setPutBuffer1Num(Integer.valueOf(req.getParameter("PutNum")));
	     setParam.setMoveBuffer2Num(Integer.valueOf(req.getParameter("Move2Num")));
	     setParam.setMoveBuffer3Num(Integer.valueOf(req.getParameter("Move3Num")));
	     setParam.setGetBuffer2Num(Integer.valueOf(req.getParameter("Get2Num")));
	     setParam.setGetBuffer3Num(Integer.valueOf(req.getParameter("Get3Num")));
	     setParam.setPutSpeed(Integer.valueOf(req.getParameter("putSpeed")));
	     setParam.setMoveSpeed(Integer.valueOf(req.getParameter("moveSpeed")));
	     setParam.setGetSpeed(Integer.valueOf(req.getParameter("getSpeed")));
	     
	     //System.out.println("Buffer1Size为"+Integer.valueOf(req.getParameter("buffer1Size")));
	     SetParamDao setParamDao = new SetParamDaoImpl();
	     setParamDao.setParam(setParam);
	     
	     
	     Param params = setParamDao.selectParamsById(1);
	
	     session.setAttribute("param", params);
	     ArrayList<BufferData> Buffer1DataList = setParamDao.queryBufferData(1);
	     
	     session.setAttribute("buffer1List", Buffer1DataList);
	     
	     
	     
	     res.sendRedirect("/MyOsProject/index.jsp");
	}
    
}
