package usr;
import usr.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

//This is a test class for UsersDAO and UserDB
public class test{	
	public static void main(String[] args){
//		UserDB db = new UserDB();
//		db.createDB("user");
//		ArrayList<String> lst = new ArrayList<String>();
//		String u = "username";
//		String p  = "password";
//		String e = "email";
//		lst.add(u);
//		lst.add(p);
//		lst.add(e);
//		db.createTable("user", "users", lst);
//		
//		ArrayList<String> lst1 = new ArrayList<String>();
//		String u1u = "Zhang";
//		String u1p =	 "12345";
//		String u1e = "123@qq.com";
//		lst1.add(u1u);
//		lst1.add(u1p);
//		lst1.add(u1e);
//		if(db.addData("user", "users",lst, lst1)){
//			System.out.println("Successfully added");
//		}
//		
//		UsersDAO ud = new UsersDAO();
//		User user = new User();
//		user.setEmail("123@qq.com");
//		user.setId(31);
//		user.setPassword("123567");
//		user.setUsername("God");
//		
//		System.out.println(ud.update(user));
		UsersDAO ud = new UsersDAO();
		
		String u1 = "wang";
		String p1 = "123456";
		System.out.println(ud.loginCheck(u1, p1));
		
		String u2 = " ";
		String p2 = " ";
		System.out.println(ud.loginCheck(u2, p2));
		
		String u3 = "wang";
		String p3 = " ";
		System.out.println(ud.loginCheck(u3, p3));
		
		String u4 = "mingze";
		String p4 = "1234";
		System.out.println(ud.loginCheck(u4, p4));
		
		String u5 = "mingze";
		String p5 = "123456";
		System.out.println(ud.loginCheck(u5, p5));
	}
}

