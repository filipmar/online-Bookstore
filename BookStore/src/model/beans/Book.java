package model.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Year;
import java.util.ArrayList;

import model.dao.BookDAO;

public class Book implements Serializable {
	
	private static final long serialVersionUID = 55951123064919897L;
	
	
	private BookDAO daoObject = null;
	
	private int id;
	private String title;
	private String authors;
	private String publisher;
	private Integer publicationYear;
	private String description;
	private String genre;
	private Integer numberInStock;
	private Double price;
	private String pictureURL;
	private String status;
	
	public Book(){
		
	}
	
	
	public Book(int id, String title, String authors,
			String publisher, Integer publicationYear, String description,
			String genre, Integer numberInStock, Double price, String pictureURL,String status) {
		super();
		this.id = id;
		this.daoObject = null;
		this.title = title;
		this.authors = authors;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
		this.description = description;
		this.genre = genre;
		this.numberInStock = numberInStock;
		this.price = price;
		this.pictureURL = pictureURL;
		this.status = status;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthors() {
		return authors;
	}


	public void setAuthors(String authors) {
		this.authors = authors;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public Integer getPublicationYear() {
		return publicationYear;
	}


	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public Integer getNumberInStock() {
		return numberInStock;
	}


	public void setNumberInStock(Integer numberInStock) {
		this.numberInStock = numberInStock;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getPictureURL() {
		return pictureURL;
	}


	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public BookDAO getDaoObject(){
		if(daoObject == null){
			return daoObject = new BookDAO();
		}
		return daoObject;
	}

	public void setDaoObject(BookDAO daoObject) {
		this.daoObject = daoObject;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
