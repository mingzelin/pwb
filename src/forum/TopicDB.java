


package forum;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.sql.Timestamp;
import usr.JDBCUtils;
import java.util.Date;
public class TopicDB {
	Connection conn = null;
	Statement stmt = null;
	
	public void createDB(){
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			String sql = "create database if not exists user";
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(stmt, conn);
		}
	}
	
	public void createTable(){
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			String sql = "use user;";
			stmt.executeQuery(sql);
			sql = "create table if not exists topic";
			sql+="(";
			sql+="NO int(6) not null auto_increment,";
			sql+="ID int(6),";
			sql+="username varchar(255),";
			sql+="content character varying(1000) not null,";
			sql+="title character varying(50) not null,";
			sql+="viewcount int(7),";
			sql+="createDate datetime,";
			sql+="primary key (NO));";
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(stmt, conn);
		}
	}
	
	public boolean addData(Topic topic){
		try{
			conn = JDBCUtils.getconnection();
			stmt = conn.createStatement();
			String sql = "use user;";
			stmt.executeQuery(sql);
			Object date = new Timestamp(new Date().getTime());
			
			sql = "insert into topic(ID, username, title, viewCount, content, createDate)"
				+ "values(" 
				+ topic.getId() + ",'"
				+ topic.getUsername() + "','"
				+ topic.getTitle() + "',"
				+ 0 + ",'"
				+ topic.getContent() + "','"
				+ date + "');";
			
			System.out.println(sql);
			
			int num = stmt.executeUpdate(sql);
			if(num > 0){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(stmt, conn);
		}
		return false;
	}
}

