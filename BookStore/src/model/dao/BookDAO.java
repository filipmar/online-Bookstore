package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;

import utils.QueryResultSupport;
import model.beans.Book;

public class BookDAO extends BaseDAO implements CRUDDaoInterface<Book, Integer>{

	private int noOfRecords;
	
	public BookDAO() {
		super();
		this.tableName = "book";
	}
	
	
	@Override
	public boolean add(Book book) {
		boolean result = false;
		String sqlQuery = "INSERT INTO " + this.tableName;
		sqlQuery += " (title, authors, publisher, publicationYear, description, genre, numberInStock,price,pictureURL,status) ";
		sqlQuery += " VALUES (?,?,?,?,?,?,?,?,?,'active')";
		if (this.lastQueryResult == null)
			lastQueryResult = new QueryResultSupport();
		if (book != null && this.ds != null) {
			Connection conn = null;
			try {
				conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery,
						Statement.RETURN_GENERATED_KEYS);
				if (book.getTitle() == null)
					pstmt.setNull(1, Types.NULL);
				else
					pstmt.setString(1, book.getTitle());
				pstmt.setString(2, book.getAuthors());
				if (book.getPublisher() == null)
					pstmt.setNull(3, Types.NULL);
				else
					pstmt.setString(3, book.getPublisher());
				if (book.getPublicationYear() == null)
					pstmt.setNull(4, Types.NULL);
				else
					pstmt.setInt(4, book.getPublicationYear());
				if (book.getDescription() == null)
					pstmt.setNull(5, Types.NULL);
				else
					pstmt.setString(5, book.getDescription());

				if (book.getGenre() == null)
					pstmt.setNull(6, Types.NULL);
				else
					pstmt.setString(6, book.getGenre());

				if (book.getNumberInStock() == null)
					pstmt.setNull(7, Types.NULL);
				else
					pstmt.setInt(7, book.getNumberInStock());

				if (book.getPrice()== null)
					pstmt.setNull(8, Types.NULL);
				else
					pstmt.setDouble(8, book.getPrice());

				if (book.getPictureURL() == null)
					pstmt.setNull(9, Types.NULL);
				else
					pstmt.setString(9, book.getPictureURL());
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
					this.lastQueryResult.setErrorMsg(pstmt.getWarnings()
							.getMessage());
				pstmt.close();
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
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
		}
		return result;
	}

	@Override
	public Book get(Integer identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Book book) {
		boolean result = false;
		String sqlQuery = "UPDATE " + this.tableName;
		sqlQuery += " SET title=?, authors=?, publisher=?, publicationYear=?, description=?, genre=?, numberInStock=?, price=?, status=?, pictureURL=? ";
		sqlQuery += " WHERE id=" + book.getId();
		if (this.lastQueryResult == null)
			lastQueryResult = new QueryResultSupport();
		Connection conn = null;
		try {
			conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sqlQuery,
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthors());
			pstmt.setString(3, book.getPublisher());
			pstmt.setInt(4, book.getPublicationYear());
			pstmt.setString(5, book.getDescription());
			pstmt.setString(6, book.getGenre());
			pstmt.setInt(7, book.getNumberInStock());
			pstmt.setDouble(8, book.getPrice());
			pstmt.setString(9, "active");
			if(book.getPictureURL().isEmpty())
				pstmt.setString(10, null);
			else
				pstmt.setString(10, book.getPictureURL());
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
	
	public boolean updateNumberInStock(Book book) {
		boolean result = false;
		String sqlQuery = "UPDATE " + this.tableName;
		sqlQuery += " SET numberInStock=?";
		sqlQuery += " WHERE id=" + book.getId() + " and numberInStock > 0";
		if (this.lastQueryResult == null)
			lastQueryResult = new QueryResultSupport();
		Connection conn = null;
		try {
			conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sqlQuery,
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, book.getNumberInStock());

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
	public boolean delete(Book book) {
		boolean result = false;
		String sqlQuery = "UPDATE " + this.tableName;
		sqlQuery += " SET status=? ";
		sqlQuery += " WHERE id=" + book.getId();
		if (this.lastQueryResult == null)
			lastQueryResult = new QueryResultSupport();
		Connection conn = null;
		try {
			conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sqlQuery,
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, book.getStatus());

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
	public List<Book> getList(String[] conditions) {
		List<Book> result = null;
		Connection conn = null;
		
		String sqlQuery = "SELECT * FROM " + this.tableName;
		if(conditions!=null && conditions.length>0){
			sqlQuery += " WHERE ";
			int counter=0;
			for(String cond:conditions){
				if(counter>0) sqlQuery+=" AND ";
				sqlQuery+=cond;
				counter++;
			}
			
			try{
				conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery);
				while(rs.next()){
					if(result==null)
						result = new ArrayList<Book>();
					
					Book oneBook = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("authors"), 
							rs.getString("publisher"), rs.getInt("publicationYear"), rs.getString("description"), 
							rs.getString("genre"), rs.getInt("numberInStock"), rs.getDouble("price"), rs.getString("pictureURL"),rs.getString("status"));
					result.add(oneBook);
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
		}
		return result;
	}

	@Override
	public List<Book> getAll() {
		List<Book> result = null;
		Connection conn = null;
		
		String sqlQuery = "SELECT * FROM " + this.tableName +  " ORDER BY book.publicationYear DESC";
			
			try{
				conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery);
				while(rs.next()){
					if(result==null)
						result = new ArrayList<Book>();
					
					Book oneBook = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("authors"), 
							rs.getString("publisher"), rs.getInt("publicationYear"), rs.getString("description"), 
							rs.getString("genre"), rs.getInt("numberInStock"), rs.getDouble("price"), rs.getString("pictureURL"),rs.getString("status"));
					result.add(oneBook);
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
	
	
	public List<Book> getAll(int offset,int noOfRecords) {
		List<Book> result = null;
		Connection conn = null;
		
		String sqlQuery = "SELECT SQL_CALC_FOUND_ROWS * FROM  book WHERE status = 'active' ORDER BY book.publicationYear DESC" + " limit " + offset + ", " + noOfRecords;
			
			try{
				conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery);
				while(rs.next()){
					if(result==null)
						result = new ArrayList<Book>();
					
					Book oneBook = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("authors"), 
							rs.getString("publisher"), rs.getInt("publicationYear"), rs.getString("description"), 
							rs.getString("genre"), rs.getInt("numberInStock"), rs.getDouble("price"), rs.getString("pictureURL"),rs.getString("status"));
					result.add(oneBook);
				}
				rs.close();
				rs = stmt.executeQuery("SELECT FOUND_ROWS()");
				
				if(rs.next()){
					this.noOfRecords = rs.getInt(1);
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
	
	public List<Book> getAll(int offset,int noOfRecords,String genre) {
		List<Book> result = null;
		Connection conn = null;
		
		String sqlQuery = "SELECT SQL_CALC_FOUND_ROWS * FROM  book" + " WHERE status = 'active' and genre = " + "'" + genre + "'" + " ORDER BY book.publicationYear DESC" + " limit " + offset + ", " + noOfRecords;
			
			try{
				conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery);
				while(rs.next()){
					if(result==null)
						result = new ArrayList<Book>();
					
					Book oneBook = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("authors"), 
							rs.getString("publisher"), rs.getInt("publicationYear"), rs.getString("description"), 
							rs.getString("genre"), rs.getInt("numberInStock"), rs.getDouble("price"), rs.getString("pictureURL"),rs.getString("status"));
					result.add(oneBook);
					System.out.println(oneBook.getTitle());
				}
				rs.close();
				rs = stmt.executeQuery("SELECT FOUND_ROWS()");
				
				if(rs.next()){
					this.noOfRecords = rs.getInt(1);
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
	
	public Book getBookByID(Integer id){
		BookDAO bookDao = new BookDAO();
		List<Book> books = bookDao.getAll();
		for (Book book : books) {
			if(book.getId() == id){
				return book;
			}
			
		}
		return null;
	}
	
    public int getNoOfRecords() {
        return noOfRecords;
    }
	
}
	


