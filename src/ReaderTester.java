import java.util.List;

import controller.ReaderHelper;
import model.Reader;

public class ReaderTester {
	
	public static void main(String[] args) {
		
		ReaderHelper sh = new ReaderHelper();
		/*
		 * Reader bill = new Reader("Bill"); 
		 * 
		 * 
		 * sh.insertReader(bill);
		 * 
		 * Reader jim = new Reader("Jim"); 
		 * sh.insertReader(jim);
		 */
		
		List<Reader> allReaders = sh.showAllReaders();
		for(Reader a: allReaders) {
			System.out.println(a.toString());
		}
	}
}
