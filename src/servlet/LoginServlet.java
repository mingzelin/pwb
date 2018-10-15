package servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import usr.UsersDAO;
import usr.JDBCUtils;
import usr.UserDB;
import usr.User;
import usr.UsersDAO;

public class LoginServlet extends HttpServlet{	
	@Override  
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	@Override  
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{	
		
		String username = request.getParameter("loginUsrname");	
		String password = request.getParameter("loginPwd");
		
		UsersDAO ud = new UsersDAO();
		if(ud.loginCheck(username, password)){
			User user = new User();
			user.setPassword(password);
			user.setUsername(username);
	//		temp not setting email and id
			request.getSession().setAttribute("user", user);
			Cookie cookie = new Cookie("autologin", username + "-" + password);
			cookie.setMaxAge(60*60*24);
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);
			response.getWriter().write("true");
//			response.sendRedirect(request.getContextPath() + "/jsp/home.jsp");
			} else {
			response.getWriter().write("false");
		}	
	}
	
}
