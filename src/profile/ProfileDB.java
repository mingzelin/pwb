package profile;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import usr.JDBCUtils;
import usr.UserDB;
import usr.JDBCUtils;
import usr.UsersDAO;

public class ProfileDB {
	UserDB udb = new UserDB();
	Connection conn = null;
	Statement stmt = null;
	public void createDB(String database){
		udb.createDB(database);
	}
	
//      Almost the same as the one from UserDB except can have null arguments	
//		set is the set of items that the table have and should not include id
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
				sql+=", " + str + " varchar(255)";
			}
			sql+=");";
			stmt.executeUpdate(sql);
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(stmt, conn);
		}
	}
//		set is the set of items that the table have and should not include id
	public boolean addData(String database, String table, ArrayList<String> lst, ArrayList<String> lst1){
		boolean i = udb.addData(database, table, lst, lst1);
		return i;
	}
}
