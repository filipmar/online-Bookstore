package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.QueryResultSupport;
import model.beans.Book;
import model.beans.Order;
import model.beans.Purchaser;
import model.beans.User;

public class OrderDAO extends BaseDAO implements CRUDDaoInterface<Order, Integer>{

	public OrderDAO(){
		super();
		this.tableName = "cart";
	}
	
	public boolean add(Order order,Book book,Purchaser purchaser) {
		// TODO Auto-generated method stub
		boolean result = false;
		String sqlQuery = "INSERT INTO " + this.tableName;
		sqlQuery += " (id_book,id_purchaser,granted) ";
		sqlQuery += " VALUES(?,?,?)";
		if (this.lastQueryResult == null)
			lastQueryResult = new QueryResultSupport();
		if(book != null && purchaser != null && order != null && this.ds != null){
			Connection conn = null;
			try{
				conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
				pstmt.setInt(1, book.getId());
				pstmt.setInt(2, purchaser.getId());
				pstmt.setString(3, order.getGranted());
				
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
			}catch (Exception ex) {
				ex.printStackTrace();
				this.lastQueryResult.setErrorMsg(ex.getMessage());
		}
			finally {
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
	public Order get(Integer identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Order bean) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean updateStatus(Order order) {
		boolean result = false;
		String sqlQuery = "UPDATE cart ";
		sqlQuery += " SET granted=? ";
		sqlQuery += " WHERE id_cart = " + order.getId();
		if (this.lastQueryResult == null)
			lastQueryResult = new QueryResultSupport();
		if(order != null && this.ds != null){
			Connection conn = null;
			try{
				conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, order.getGranted());
				
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
			}catch (Exception ex) {
				ex.printStackTrace();
				this.lastQueryResult.setErrorMsg(ex.getMessage());
		}
			finally {
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
	public boolean delete(Order bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Order> getList(String[] conditions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAll() {
		List<Order> result = null;
		Connection conn = null;
		
		String sqlQuery = "SELECT * FROM " + this.tableName;
			
			try{
				conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery);
				PurchaserDAO purchaserDao = new PurchaserDAO();
				List<Purchaser> allPurchaser = purchaserDao.getAll();
				BookDAO bookDao = new BookDAO();
				List<Book> allBooks = bookDao.getAll();
				while(rs.next()){
					if(result==null)
						result = new ArrayList<Order>();
					
					int id_purchaser = rs.getInt("id_purchaser");
					int id_book = rs.getInt("id_book");
					int id_order = rs.getInt("id_cart");
					for (Purchaser purchaser : allPurchaser) {	
						for (Book book : allBooks) {
							if(purchaser.getId() == id_purchaser && book.getId() == id_book){
								Order order = new Order(id_order,purchaser,book,rs.getString("granted"));
								result.add(order);
						}
						}
					}
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
	

	@Override
	public boolean add(Order bean) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<Book> orderedBooks(Purchaser purchaser){ 
		List<Book> orderedBooks = null;
		Connection conn = null;
		
		String sqlQuery = "Select title from purchaser A, cart B, book C "
				+ "WHERE A.id = B.id_purchaser and B.id_book = C.id and A.id = " + purchaser.getId();
			
			try{
				conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery);
				while(rs.next()){
					if(orderedBooks==null)
						orderedBooks = new ArrayList<Book>();
				stmt.close();
				conn.close();
				}
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
		return orderedBooks;
	}
	
}

