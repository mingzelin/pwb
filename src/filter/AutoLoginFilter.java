package filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import usr.User;
import usr.UsersDAO;

import javax.servlet.http.Cookie;

public class AutoLoginFilter implements Filter{ //implementation error
	public void init(FilterConfig filterconfig) throws ServletException{
		
	}
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		Cookie[] cookies = request.getCookies();
		String autologin = null;
		for(int i = 0; cookies!= null && i < cookies.length; i++){
			if(cookies[i].getName().equals("autologin"))
			{
				autologin = cookies[i].getValue();
				break;
			}
		}
		if(autologin!=null){
			String[] info = autologin.split("-");
			String username = info[0];
			String password = info[1];
			UsersDAO ud = new UsersDAO();
			if(ud.loginCheck(username, password)){
				User user = new User();
				user.setPassword(password);
				user.setUsername(username);
				request.getSession().setAttribute("user", user);
			}
		}
		chain.doFilter(request, response);
	}
	public void destroy(){
		
	}
}
