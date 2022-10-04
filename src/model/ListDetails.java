package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author alexh - aheinrichs
 * CIS175 - Fall 2022
 * Oct 2, 2022
 */

@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate dateModified;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Reader reader;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ListItem> listOfItems;
	
	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ListDetails(int id, String listName, LocalDate dateModified, Reader reader, List<ListItem> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		this.dateModified = dateModified;
		this.reader = reader;
		this.listOfItems = listOfItems;
	}
	public ListDetails(String listName, LocalDate dateModified, Reader reader, List<ListItem> listOfItems) {
		super();
		this.listName = listName;
		this.dateModified = dateModified;
		this.reader = reader;
		this.listOfItems = listOfItems;
	}
	public ListDetails(String listName, LocalDate dateModified, Reader reader) {
		super();
		this.listName = listName;
		this.dateModified = dateModified;
		this.reader = reader;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public LocalDate getDateModified() {
		return dateModified;
	}
	public void setDateModified(LocalDate dateModified) {
		this.dateModified = dateModified;
	}
	public Reader getReader() {
		return reader;
	}
	public void setReader(Reader reader) {
		this.reader = reader;
	}
	public List<ListItem> getListOfItems() {
		return listOfItems;
	}
	public void setListOfItems(List<ListItem> listOfItems) {
		this.listOfItems = listOfItems;
	}
	
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", dateModified=" + dateModified + ", reader=" + reader
				+ ", listOfItems=" + listOfItems + "]";
	}
	
}
