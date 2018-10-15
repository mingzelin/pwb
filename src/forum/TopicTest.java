package forum;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

//import java.text.DateFormat;

public class TopicTest {
	public static void main(String[] args) throws ParseException{
		TopicDB db = new TopicDB();
		db.createDB();
		db.createTable();
		Topic t = new Topic();	
		t.setCreateDate(new Date());
		t.setContent("This is the content of my 1st journal!");
		t.setId(1);
		t.setTitle("journal");
		t.setUsername("mingze");
		t.setViewCount(0);
		db.addData(t);
		
		Topic s = new Topic();
		s.setCreateDate(new Date());
		s.setContent("This is the content of my 2nd journal!");
		s.setId(1);
		s.setTitle("journal");
		s.setUsername("mingze");
		s.setViewCount(0);
		db.addData(s);
		
		TopicDAO dao = new TopicDAO();
//		ArrayList<Topic> lst = dao.findById(1);
//		for(Topic topic: lst){
//			System.out.print(topic.getContent() + "\n");
//		}
		
//		ArrayList<Topic> lst1 = dao.findByTitle("'journal'");
//		for(Topic topic: lst1){
//			System.out.print(topic.getContent() + "\n");
//		}
		
		
		Topic l = new Topic();
		l.setCreateDate(new Date());
		l.setContent("This is the content of my 3nd journal!");
		l.setId(1);
		l.setTitle("journal3");
		l.setUsername("mingze");
		l.setViewCount(0);
		dao.insert(l);
		
		
		Topic ss = new Topic();	
		ss.setCreateDate(new Date());
		ss.setContent("This is the content of my 1st journal!");
		ss.setId(1);
		ss.setTitle("journal");
		ss.setUsername("mingze!!!!");
		ss.setViewCount(0);
		dao.update(ss);
	}
}
