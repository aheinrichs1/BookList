package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author alexh - aheinrichs
 * CIS175 - Fall 2022
 * Sep 6, 2022
 */

@Entity
@Table(name="books")
public class ListItem {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="TITLE")
	private String title;
	@Column(name="AUTHOR")
	private String author;
	@Column(name="CATEGORY")
	private String category;
	
	//Default, no arg constructor
	public ListItem() {
		super();
	}
	
	//2 arg constructor
	public ListItem(String title, String author, String category) {
	this.title = title;
	this.author = author;
	this.category = category;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ListItem [id=" + id + ", title=" + title + ", author=" + author + ", category=" + category + "]";
	}
	
	
	
}
