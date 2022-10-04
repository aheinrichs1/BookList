package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.ListDetails;
import model.ListItem;
import model.Reader;

/**
 * @author alexh - aheinrichs
 * CIS175 - Fall 2022
 * Oct 2, 2022
 */
public class ListDetailsTester {

	public static void main(String[] args) {

		Reader cameron = new Reader("Cameron");
		
		ReaderHelper sh = new ReaderHelper();
		
		sh.insertReader(cameron);
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListItem beHereNow = new ListItem("Be Here Now", "Ram Dass", "Spirituality");
		ListItem theOdyssey = new ListItem("The Odyssey", "Homer", "Epic");
		
		List<ListItem> cameronsItems = new ArrayList<ListItem>();
		cameronsItems.add(beHereNow);
		cameronsItems.add(theOdyssey);
		
		ListDetails cameronList = new ListDetails("Cameron's List", LocalDate.now(), cameron);
		cameronList.setListOfItems(cameronsItems);
		
		ldh.insertNewListDetails(cameronList);
		
		List<ListDetails> allLists = ldh.getLists();
		for(ListDetails a : allLists) {
			System.out.println(a.toString());
		}
		
	}

}