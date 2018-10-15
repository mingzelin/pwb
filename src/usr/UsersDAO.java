package usr;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import usr.User;
import usr.JDBCUtils;

//The database is called users
public class UsersDAO {
	public boolean insert(User user){
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
//			id should be automatically added
			String sql = "use user;";
			stmt.executeQuery(sql);
			sql = "insert into users(id, username, password, email) values("
			   + user.getId() + ",'" + user.getUsername() + "','" 
			   + user.getPassword() + "','" + user.getEmail() + "');";
			int num = stmt.executeUpdate(sql);
			if(num > 0) {return true;}
			return false;	
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			JDBCUtils.release(stmt, conn, rs); 
		}
		return false;
	}
	public ArrayList<User> findAll(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<User> list = new ArrayList<User>();
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			String sql = "use user;";
			stmt.executeQuery(sql);
			sql = "select * from users;";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				list.add(user);
			}
			return list;
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			JDBCUtils.release(stmt, conn, rs);
		}
		return null;
	}
	public User find(int id){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			String sql = "use user;";
			stmt.executeQuery(sql);
			sql = "select * from users where id =" + id;
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				return user;
			}
			return null;		
		}catch (Exception e){
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
			sql = "delete from users where id =" + id + ";";
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
	public boolean update(User user){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			String sql = "use user;";
			stmt.executeQuery(sql);
			sql = "update users set username ='" + user.getUsername() + "', password ='" 
					   + user.getPassword() + "', email='" + user.getEmail() + "' where id =" + user.getId() + ";";
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
//	login check in users
	public boolean loginCheck(String username, String password){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			String sql = "use user;";
			stmt.executeQuery(sql);
			sql = "select * from users where username = '" + username +"';";
			rs = stmt.executeQuery(sql); 
			if(rs == null){return false;}
			if(rs.next() && password.equals(rs.getString("password"))){
				return true;
			}
			return false;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(stmt, conn, rs);
		}
		return false;
	}
	
	
}
