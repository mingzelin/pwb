package forum;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import usr.JDBCUtils;

public class TopicDAO {
	public boolean insert(Topic topic){
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			String sql= "use user";
			stmt.executeQuery(sql);
			
			Date cdate = (Date) topic.getCreateDate();
			Object date = new Timestamp(new Date().getTime());
			
			sql = "insert into topic(NO ,ID, username, "
					+ "title, viewcount, content, createDate)"
				+ "values("
				+ topic.getNO() + ","
				+ topic.getId() + ",'"
				+ topic.getUsername() + "','"
				+ topic.getTitle() + "',"
				+ topic.getViewCount() + ",'"
				+ topic.getContent() + "','" 
				+ date +"');";
			
			System.out.println(sql);
			
			int num = stmt.executeUpdate(sql);
			if(num > 0){return true;}
			return false;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(stmt, conn, rs);
		}
		return false;
	}
	
	public ArrayList<Topic> findByName(String username){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Topic> list = new ArrayList<Topic>();
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			
			String sql = "use user;";
			stmt.executeQuery(sql);
			sql = "select * from topic where username = " + username;
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Topic t = new Topic();
				t.setNO(rs.getInt("NO"));
				t.setId(rs.getInt("ID"));
				t.setUsername(rs.getString("username"));
				t.setTitle(rs.getString("title"));
				t.setViewCount(rs.getInt("viewCount"));
				t.setContent(rs.getString("content"));
				t.setCreateDate(rs.getDate("createDate"));
				list.add(t);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(stmt, conn, rs);
		}
		return null;
	}
	public ArrayList<Topic> findByNO(int NO){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Topic> list = new ArrayList<Topic>();
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			
			String sql = "use user;";
			stmt.executeQuery(sql);
			sql = "select * from topic where NO = " + NO;
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Topic t = new Topic();
				t.setNO(rs.getInt("NO"));
				t.setId(rs.getInt("ID"));
				t.setUsername(rs.getString("username"));
				t.setTitle(rs.getString("title"));
				t.setViewCount(rs.getInt("viewCount"));
				t.setContent(rs.getString("content"));
				t.setCreateDate(rs.getDate("createDate"));
				list.add(t);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(stmt, conn, rs);
		}
		return null;
	}
	
	public ArrayList<Topic> findById(int id){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Topic> list = new ArrayList<Topic>();
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			
			String sql = "use user;";
			stmt.executeQuery(sql);
			sql = "select * from topic where id = " + id;
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Topic t = new Topic();
				t.setNO(rs.getInt("NO"));
				t.setId(rs.getInt("ID"));
				t.setUsername(rs.getString("username"));
				t.setTitle(rs.getString("title"));
				t.setViewCount(rs.getInt("viewCount"));
				t.setContent(rs.getString("content"));
				t.setCreateDate(rs.getDate("createDate"));
				list.add(t);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(stmt, conn, rs);
		}
		return null;
	}
	
	
	public ArrayList<Topic> findByTitle(String title){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Topic> list = new ArrayList<Topic>();
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			
			String sql = "use user;";
			stmt.executeQuery(sql);
			sql = "select * from topic where title = " + title;
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Topic t = new Topic();
				t.setNO(rs.getInt("NO"));
				t.setId(rs.getInt("ID"));
				t.setUsername(rs.getString("username"));
				t.setTitle(rs.getString("title"));
				t.setViewCount(rs.getInt("viewCount"));
				t.setContent(rs.getString("content"));
				t.setCreateDate(rs.getDate("createDate"));
				list.add(t);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(stmt, conn, rs);
		}
		return null;
	}
	
	public boolean delete(int id){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			String sql = "use user;";
			stmt.executeQuery(sql);
			sql = "delete from topic where id = " + id;
			int num = stmt.executeUpdate(sql);
			if(num > 0){return true;}
			return false;
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(stmt, conn, rs);
		}
		return false;
	}
	
	public boolean deleteS(int NO){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			String sql = "use user;";
			stmt.executeQuery(sql);
			sql = "delete from topic where NO = " + NO;
			int num = stmt.executeUpdate(sql);
			if(num > 0){return true;}
			return false;
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(stmt, conn, rs);
		}
		return false;
	}
	
	public boolean delete(String title){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			String sql = "use user;";
			stmt.executeQuery(sql);
			sql = "delete from topic where title = " + title;
			int num = stmt.executeUpdate(sql);
			if(num > 0){return true;}
			return false;
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(stmt, conn, rs);
		}
		return false;
	}
	
	public boolean update(Topic t){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Object date = new Timestamp(t.getCreateDate().getTime());
			
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			String sql = "use user";
			stmt.executeQuery(sql);
			
			sql = "update topic set username ='" + t.getUsername()
				+ "',content ='" + t.getContent() + "', title = '"
				+ t.getTitle() + "', viewcount =" + t.getViewCount()
				+ ", createDate = '" + date + "' where id = " + t.getId();
			///
			int num = stmt.executeUpdate(sql);
			if(num > 0){return true;}
			return false;
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(stmt, conn, rs);
		}
		return false;
	}

	public ArrayList<Topic> refreshTen(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Topic> list = new ArrayList<Topic>();
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			
			String sql = "use user;";
			stmt.executeQuery(sql);
			sql = "select * from topic order by NO desc limit 15;";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Topic t = new Topic();
				t.setNO(rs.getInt("NO"));
				t.setId(rs.getInt("ID"));
				t.setUsername(rs.getString("username"));
				t.setTitle(rs.getString("title"));
				t.setViewCount(rs.getInt("viewCount"));
				t.setContent(rs.getString("content"));
				t.setCreateDate(rs.getDate("createDate"));
				list.add(t);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(stmt, conn, rs);
		}
		return null;
	}
}
