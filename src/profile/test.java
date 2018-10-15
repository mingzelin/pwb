package profile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class test {
	public static void main(String[] args) throws ParseException{
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
		
//		ArrayList<String> lst1 = new ArrayList<String>();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		Date b = sdf.parse("05/10/1997");
//		String birthday = sdf.format(b);
//		String gender = Integer.toString(1);
//		String p1 = "mingze";
//		String p2 =	"China";
//		String p3 = "Jiangsu";
//		String p4 = "Nanjing";
//		String p5 = "/pwd/profileImage/mingze.jpg";
//		String p6 = "Software Engineer";
//		String p7 = "Siweituxin";
//		String p8 = "Stay hungry, stay foolish, and be yourself.";
//		String p9 = birthday;
//		String p10 = gender;
//		lst1.add(p1);
//		lst1.add(p2);
//		lst1.add(p3);
//		lst1.add(p4);
//		lst1.add(p5);
//		lst1.add(p6);
//		lst1.add(p7);
//		lst1.add(p8);
//		lst1.add(p9);
//		lst1.add(p10);
//		if(db.addData("profile", "profiles",lst, lst1)){
//			System.out.println("Successfully added");
//		}
		
		ArrayList<String> lst1 = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date b = sdf.parse("05/10/1997");
		String birthday = sdf.format(b);
		String gender = Integer.toString(1);
		ProfileDB p = new ProfileDB();
		ProfileDAO dao = new ProfileDAO();
		Profile pro = new Profile();
		pro.setId(3);
		pro.setUsername("mingze");
		pro.setCountry("China");
		pro.setProvince("Jiangsu");
		pro.setCity("Nanjing");
		pro.setImage("/pwd/profileImage/mingze.jpg");
		pro.setJob("Software Engineer");
		pro.setCompany("Helian");
		pro.setSignature("Stay hungry, stay foolish, and be yourself.");
		pro.setBirthday(b);
		pro.setGender(1);
//		dao.insert(pro);
//		ArrayList<Profile> plst = dao.findAll();
//		Iterator<Profile> it = plst.iterator();
//		System.out.println(it.next().getUsername());
		dao.delete(1);
//		System.out.println(profile.getCompany());
		dao.update(pro);
	}
}
