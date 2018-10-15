package servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usr.User;
import usr.JDBCUtils;
import usr.UserDB;
import usr.UsersDAO;
import profile.Profile;
import profile.ProfileDAO;
import profile.ProfileDB;

public class RegisterBridge extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException{
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{		
		try{
		UserDB db = new UserDB();
		db.createDB("user");
		//from here is table users
		ArrayList<String> lst = new ArrayList<String>();
		String u = "username";
		String p  = "password";
		String e = "email";
		lst.add(u);
		lst.add(p);
		lst.add(e);
		db.createTable("user", "users", lst);
		
		ArrayList<String> lst1 = new ArrayList<String>();
		String u1 = request.getParameter("usrname");
		String p1 = request.getParameter("pwd");
		String e1 = request.getParameter("email");
		lst1.add(u1);
		lst1.add(p1);
		lst1.add(e1);
		db.addData("user", "users", lst, lst1);
		//from here is table profiles
		ProfileDB pdb = new ProfileDB();
		ArrayList<String> lst2 = new ArrayList<String>();
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
		lst2.add(us);
		lst2.add(co);
		lst2.add(pr);
		lst2.add(ci);
		lst2.add(im);
		lst2.add(jo);
		lst2.add(com);
		lst2.add(si);
		lst2.add(bi);
		lst2.add(ge);
		pdb.createTable("user", "profiles", lst2);
		//from here it auto generate a profile for a user when registered
		ArrayList<String> lst3 = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date b = sdf.parse("05/10/1997");
		String birthday = sdf.format(b);
		String gender = Integer.toString(1);
		String p11 = u1;
		String p2 =	null;
		String p3 = null;
		String p4 = null;
		String p5 = null;
		String p6 = null;
		String p7 = null;
		String p8 = null;
		String p9 = null;//birthday;
		String p10 = null;//gender;
		lst3.add(p11);
		lst3.add(p2);
		lst3.add(p3);
		lst3.add(p4);
		lst3.add(p5);
		lst3.add(p6);
		lst3.add(p7);
		lst3.add(p8);
		lst3.add(p9);
		lst3.add(p10);
		pdb.addData("user", "profiles",lst2, lst3);
		}catch(Exception e){
		e.printStackTrace();
		}
		//make be make a class for auto generating a full null object
		
	}
}
