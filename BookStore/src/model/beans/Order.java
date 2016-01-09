package model.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
	
	private static final long serialVersionUID = 5511264919897L;
	
	private int id;
	private Purchaser purchaser;
	private Book book;
	
	private String status;
	
	public Order(){
		
	}
	
	public Order(Purchaser purchaser,String granted) {
		super();
		this.purchaser = purchaser;
		this.status = granted;
	}

	
	public Order(Purchaser purchaser,Book book,String granted) {
		super();
		this.purchaser = purchaser;
		this.book = book;
		this.status = granted;
	}
	
	public Order(int id,Purchaser purchaser,Book book,String granted) {
		super();
		this.purchaser = purchaser;
		this.book = book;
		this.status = granted;
		this.id = id;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Purchaser getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(Purchaser purchaser) {
		this.purchaser = purchaser;
	}

	public String isGranted() {
		return status;
	}

	public void setGranted(String granted) {
		this.status = granted;
	}

	public String getGranted() {
		return status;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book id_book) {
		this.book = id_book;
	}
	
}
