package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.QueryResultSupport;
import model.beans.Book;
import model.beans.Purchaser;

public class PurchaserDAO extends BaseDAO implements CRUDDaoInterface<Purchaser, Integer> {

	public PurchaserDAO() {
		// TODO Auto-generated constructor stub
		super();
		this.tableName = "purchaser";
	}
	
	@Override
	public boolean add(Purchaser purchaser) {
		// TODO Auto-generated method stub
		boolean result = false;
		String sqlQuery = "INSERT INTO " + this.tableName;
		sqlQuery += " (firstName, lastName, adress, zipCode, city, phoneNumber, email)";
		sqlQuery += " VALUES (?,?,?,?,?,?,?)";
		if (this.lastQueryResult == null)
			lastQueryResult = new QueryResultSupport();
		if(purchaser != null && this.ds != null){
			Connection conn = null;
			try{
				conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, purchaser.getFirstName());
				pstmt.setString(2, purchaser.getLastName());
				pstmt.setString(3, purchaser.getAdress());
				pstmt.setInt(4, purchaser.getZipCode());
				pstmt.setString(5, purchaser.getCity());
				pstmt.setInt(6, purchaser.getPhoneNumber());
				pstmt.setString(7, purchaser.getEmail());
				
				int affectedRows = pstmt.executeUpdate();
				if (affectedRows > 0){
					result = true;
					this.lastQueryResult.setSuccess(result);
					ResultSet rs = pstmt.getGeneratedKeys();
					if(rs.next()){
						int generatedId = rs.getInt(1);
						this.lastQueryResult.setGeneratedId(generatedId);
					}
				}
				if (!result)
					this.lastQueryResult.setErrorMsg(pstmt.getWarnings()
							.getMessage());
				pstmt.close();
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				this.lastQueryResult.setErrorMsg(ex.getMessage());
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception ex1) {
					ex1.printStackTrace();
				}
			}
		
		}
		
		}
	return result;
	}

	@Override
	public Purchaser get(Integer identifier) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public boolean update(Purchaser bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Purchaser bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Purchaser> getList(String[] conditions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchaser> getAll() {
		List<Purchaser> result = null;
		Connection conn = null;
		
		String sqlQuery = "SELECT * FROM " + this.tableName;
			
			try{
				conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery);
				while(rs.next()){
					if(result==null)
						result = new ArrayList<Purchaser>();
					
					Purchaser purchaser = new Purchaser(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
										rs.getString("adress"),rs.getInt("zipCode"),rs.getString("city"),rs.getInt("phoneNumber"),rs.getString("email"));
					result.add(purchaser);
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
