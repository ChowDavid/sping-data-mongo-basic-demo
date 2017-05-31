package com.david.springData.mongo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")
public class Book implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 6597617299089538760L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bookId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="PUBLISH_DATE")
	private Date publishDate;
	
	@Column(name="PAGE_COUNT")
	private int pageCount;
	
	@Column(name="PRICE")
	private BigDecimal price;


	private Book() {
		super();
	}

	public Book(String title, Date publishDate, int pageCount, BigDecimal price) {
		super();
		this.title = title;
		this.publishDate = publishDate;
		this.pageCount = pageCount;
		this.price = price;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", publishDate=" + publishDate + ", pageCount="
				+ pageCount + ", price=" + price + "]";
	}

	

	
	
}
