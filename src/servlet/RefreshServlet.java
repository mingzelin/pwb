package servlet;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import forum.Topic;
import forum.TopicDAO;


public class RefreshServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		doGet(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		String req = request.getParameter("req");
		TopicDAO dao = new TopicDAO();	
		int count;
		ArrayList<Topic> lst;
		System.out.print(req);
//		if(req.equals("refresh")){
//			lst = dao.refreshTen();
//			count = lst.size();
//			Iterator<Topic> ite = lst.iterator();
//			while(ite.hasNext()){
//				
//			}
//			request.setAttribute("test", "this is a test");
//		}
	}
	
	
}
