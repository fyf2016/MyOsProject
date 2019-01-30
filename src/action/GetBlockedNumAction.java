package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import task.Common;

/**
 * Servlet implementation class GetBlockedNumAction
 */
@WebServlet("/GetBlockedNumAction")
public class GetBlockedNumAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 req.setCharacterEncoding("utf-8");
	     res.setContentType("application/json;charset=utf-8");
	     PrintWriter pw = res.getWriter();
	     pw.println(Common.BlockedThreadNum);
	     
	}

}
