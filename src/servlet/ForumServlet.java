package servlet;
import java.io.IOException;  
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import profile.ProfileDAO;
import profile.ProfileDB;

public class ForumServlet extends HttpServlet {
	@Override  
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException{
		doPost(request, response);
	}
	@Override  
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{		
		String twitter = request.getParameter("twitter");
		ProfileDB db = new ProfileDB();
		db.createDB("profile");
		ArrayList<String> lst = new ArrayList<String>();
		String us = "username";
		String co = "country";
		String pr = "province";
		String ci = "city";
		String im = "image";
		String jo = "job";
		String com = "company";
		String si = "signature";
		String bi = "birthday";
		String ge = "gender";
		lst.add(us);
		lst.add(co);
		lst.add(pr);
		lst.add(ci);
		lst.add(im);
		lst.add(jo);
		lst.add(com);
		lst.add(si);
		lst.add(bi);
		lst.add(ge);
		db.createTable("profile", "profiles", lst);
		
		
		
		
		
		response.getWriter().write("Back-end received message:"+ twitter);
		
	}
}
