package NumSystem;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Computer lab: Number System
 * Converting numbers: decimal, binary or hexadecimal to each other.
 * @author Mahta Ellis 
 *@version 1 - Feb9, 2017
 */ 

public class Driver {
	public static void main(String[] args) throws IOException {
	    int choice;
	    
         PrintWriter pw = new PrintWriter (new FileWriter("csis.txt"));
         Decimal dec = new Decimal (pw);
         Binary bin = new Binary(pw);
         Hexadecimal hex = new Hexadecimal(pw);
         menu menu = new menu(pw);
         
         do {
			menu.display();
			choice = menu.getSelection();
			switch (choice) {
			     case 1 : dec.decToBin(); break;
			     case 2 : dec.decToHex(); break;
			     case 3 : bin.binToDec(); break;
			     case 4 : bin.binToHex(); break;
			     case 5 : hex.hexToDec(); break;
			     case 6 : hex.hexToBin(); break;
			}
		} while (choice != 7);
		pw.close();
	}

}
