package profile;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import usr.User;
import usr.JDBCUtils;
import java.util.Date;

//The database is called users
public class ProfileDAO {
	public boolean insert(Profile p){
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
//			id should be automatically added
			String sql = "use user;";
			stmt.executeQuery(sql);
			
			String birthday = null;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			birthday = sdf.format(p.getBirthday());
			String gender =Integer.toString(p.getGender());
			
			sql = "insert into profiles(id, username, country,province,"
					+ "city,image,job,company,signature,birthday,gender) values("
			   + p.getId() + ",'" + p.getUsername() + "','" 
			   + p.getCountry() + "','" + p.getProvince() + "','" 
			   + p.getCity() + "','" + p.getImage() + "','" 
			   + p.getJob() + "','" + p.getCompany() + "','" 
			   + p.getSignature() + "','" + birthday + "','" 
			   + gender + "');"; 

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
	
	public ArrayList<Profile> findAll(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Profile> list = new ArrayList<Profile>();
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			String sql = "use user;";
			stmt.executeQuery(sql);
			sql = "select * from profiles;";
			rs = stmt.executeQuery(sql);
						
			while(rs.next()){
				Date d = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("birthday"));
				Profile p = new Profile();
				p.setBirthday(d);
				p.setCity(rs.getString("city"));
				p.setCompany(rs.getString("company"));
				p.setCountry(rs.getString("country"));
				p.setGender(Integer.parseInt(rs.getString("gender")));
				p.setId(rs.getInt("id"));
				p.setImage(rs.getString("image"));
				p.setJob(rs.getString("job"));
				p.setProvince(rs.getString("province"));
				p.setSignature(rs.getString("signature"));
				p.setUsername(rs.getString("username"));
				list.add(p);
			}
			return list;
		}catch (Exception e){
			e.printStackTrace();
		} finally {
			JDBCUtils.release(stmt, conn, rs);
		}
		return null;
	}
	
	public Profile find(int id){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			String sql = "use user;";
			stmt.executeQuery(sql);
			sql = "select * from profiles where id =" + id;
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				Date d = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("birthday"));
				Profile p = new Profile();
				p.setBirthday(d);
				p.setCity(rs.getString("city"));
				p.setCompany(rs.getString("company"));
				p.setCountry(rs.getString("country"));
				p.setGender(Integer.parseInt(rs.getString("gender")));
				p.setId(rs.getInt("id"));
				p.setImage(rs.getString("image"));
				p.setJob(rs.getString("job"));
				p.setProvince(rs.getString("province"));
				p.setSignature(rs.getString("signature"));
				p.setUsername(rs.getString("username"));
				return p;
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
			sql = "delete from profiles where id =" + id + ";";
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
	
	public boolean update(Profile p){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			String sql = "use user;";
			stmt.executeQuery(sql);
			String birthday = null;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			birthday = sdf.format(p.getBirthday());
			
			sql = "update profiles set username='" + p.getUsername() + "', country='" 
			   + p.getCountry() + "', province='" + p.getProvince() + "',city='" 
			   + p.getCity() + "', image='" + p.getImage() + "', job='" 
			   + p.getJob() + "', company='" + p.getCompany() + "', signature='" 
			   + p.getSignature() + "', birthday='" + birthday + "', gender = '" 
			   + Integer.toString(p.getGender()) + "' where id =" + p.getId() + ";";
			System.out.println(sql);
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
}
