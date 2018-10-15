package usr;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class UserDB {
	Connection conn = null;
	Statement stmt = null;
	
	public void createDB(String database){
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			String sql = "create database if not exists " + database;
			stmt.executeUpdate(sql);
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			JDBCUtils.release(stmt, conn);
		}
	}
//	set is the set of items that the table have and should not include id
	public void createTable(String database, String table, ArrayList<String> lst){
		try{	
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			
			String sql="use " + database + ";";
			stmt.executeQuery(sql);
			sql = "create table if not exists " + table;
			sql+="(";
			sql+="ID int(6) primary key auto_increment";
			Iterator<String> it = lst.iterator();
			while(it.hasNext()){
				String str = it.next();
				sql+=", " + str + " varchar(255) not null";
			}
			sql+=");";
			stmt.executeUpdate(sql);
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(stmt, conn);
		}
	}
	
//	set is the set of items that the table have and should not include id
	public boolean addData(String database, String table, ArrayList<String> lst, ArrayList<String> lst1){
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			
			Iterator<String> it = lst.iterator();
			String sql = "use " + database;
			stmt.executeQuery(sql);
			sql = "insert into " + table + " (";
			int count = 0;
			String str = it.next();
			sql+= str;
			count ++;
			while(it.hasNext()){
				str = it.next();
				sql+= ", " + str;
				count ++;
			}
			sql+=") values(?";
			for(int i = count - 1; i > 0; i--){
				sql += ", ?";
			}
			sql +=");";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			int n = 1;
			for(String string: lst1){
				ps.setString(n, string);
				n++;
			}
			int num = ps.executeUpdate();
			if(num > 0){return true;}
			return false;
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			JDBCUtils.release(stmt, conn);
		}
		return false;
	}
}
	