package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.QueryResultSupport;
import model.beans.Purchaser;
import model.beans.User;

public class UserDAO extends BaseDAO implements CRUDDaoInterface<User, String> {

	public UserDAO() {
		super();
		this.tableName = "user";
	}
	
	@Override
	public boolean add(User user) {
		boolean result = false;
		String sqlQuery = "INSERT INTO " + this.tableName;
			   sqlQuery+="(firstName,lastName,username,password,email,type,status)";
			   sqlQuery+=" VALUES (?,?,?,?,?,?,'active')";

		if(this.lastQueryResult == null)
			lastQueryResult = new QueryResultSupport();
		
		if(user!=null && this.ds!=null){
			Connection conn = null;
			try{
				conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getFirstName());
				ps.setString(2, user.getLastName());
				ps.setString(3, user.getUsername());
				ps.setString(4, user.getPassword());
				ps.setString(5, user.getEmail());
				ps.setString(6, user.getType());
				
				
				int affectedRows = ps.executeUpdate();
				if(affectedRows > 0){
					result = true;
					this.lastQueryResult.setSuccess(result);
					ResultSet rs = ps.getGeneratedKeys();
					if (rs.next()) {
						int generatedId = rs.getInt(1);
						this.lastQueryResult.setGeneratedId(generatedId);
					}
				
			}
				if(!result)
					this.lastQueryResult.setErrorMsg(ps.getWarnings()
							.getMessage());
				ps.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
				this.lastQueryResult.setErrorMsg(e.getMessage());
				
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(Exception e2){
						e2.printStackTrace();
					}
				}
			}
		}
		return result;
	}

	@Override
	public User get(String identifier) {
		User result = null;
		Connection conn = null;
		
		String sqlQuery = "SELECT * FROM"+this.tableName;
			   sqlQuery += " WHERE username=?";

		try{
			conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setString(1, identifier);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				result=new User(rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("username"), rs.getString("password"), rs.getString("email"),rs.getString("type"),rs.getString("status"));
			
			ps.close();
			conn.close();
		}catch(Exception e){
			if(this.lastQueryResult==null)
				this.lastQueryResult = new QueryResultSupport();
			this.lastQueryResult.setErrorMsg(e.getMessage());
			
		}finally{
			if(conn!=null){
				try{
					conn.close();
				}catch(Exception e2){
					e2.printStackTrace();
				}
			}
		}
		return result;		   
	}

	@Override
	public boolean update(User user) {
		boolean result = false;
		String sqlQuery = "UPDATE " + this.tableName;
		sqlQuery += " SET username=?, firstName=?, lastName=?, password=?, email=?, type=?, status=?";
		sqlQuery += " WHERE username= " +  "'" + user.getUsername() + "'";
		if (this.lastQueryResult == null)
			lastQueryResult = new QueryResultSupport();
		Connection conn = null;
		try {
			conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sqlQuery,
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getFirstName());
			pstmt.setString(3, user.getLastName());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getType());
			pstmt.setString(7, user.getStatus());

			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0) {
				result = true;
				this.lastQueryResult.setSuccess(result);
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					int generatedId = rs.getInt(1);
					this.lastQueryResult.setGeneratedId(generatedId);
				}
			}
			if (!result)
				this.lastQueryResult.setErrorMsg("DB error");
			pstmt.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
			this.lastQueryResult.setErrorMsg(ex.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception ex1) {
					ex1.printStackTrace();
				}
			}
		}

		return result;
	}

	@Override
	public boolean delete(User user) {
		boolean result = false;
		String sqlQuery = "UPDATE " + this.tableName;
		sqlQuery += " SET status=? ";
		sqlQuery += " WHERE username=" + "'" + user.getUsername() + "'";
		System.out.println(sqlQuery);
		if (this.lastQueryResult == null)
			lastQueryResult = new QueryResultSupport();
		Connection conn = null;
		try {
			conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sqlQuery,
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getStatus());

			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0) {
				result = true;
				this.lastQueryResult.setSuccess(result);
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					int generatedId = rs.getInt(1);
					this.lastQueryResult.setGeneratedId(generatedId);
				}
			}
			if (!result)
				this.lastQueryResult.setErrorMsg("DB error");
			pstmt.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
			this.lastQueryResult.setErrorMsg(ex.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception ex1) {
					ex1.printStackTrace();
				}
			}
		}

		return result;
	}

	@Override
	public List<User> getList(String[] conditions) {
		return null;
	}

	@Override
	public List<User> getAll() {
		List<User> result = null;
		Connection conn = null;
		
		String sqlQuery = "SELECT * FROM " + this.tableName;
			
			try{
				conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery);
				while(rs.next()){
					if(result==null)
						result = new ArrayList<User>();
					
					User user = new User(rs.getString("firstName"), rs.getString("lastName"),
										rs.getString("username"),rs.getString("password"),rs.getString("email"),rs.getString("type"),rs.getString("status"));
					result.add(user);
				}

				stmt.close();
				conn.close();
			}catch(Exception e){
				if(this.lastQueryResult==null)
					this.lastQueryResult = new QueryResultSupport();
				this.lastQueryResult.setErrorMsg(e.getMessage());
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(Exception e2){
						e2.printStackTrace();
					}
				}
			}
		
		return result;
	}

}
