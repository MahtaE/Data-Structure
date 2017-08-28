package NumSystem;
import java.io.*;
import java.util.*;
/**
* Menu class: Lets the user choose an option to convert from:
* <p>
* Decimal to Binary      and      Decimal to Hexadecimal
* <p>
* Binary to Decimal      and      Binary to Hexadecimal
* <p>
* Hexadecimal to Binary  and      Hexadecimal to Decimal
* 
* @author Mahta Ellis Palomar College CSCI 210
* @version 1.1 ( Feb9, 2017)
*/
public class menu {
	
	private PrintWriter pw;
	
	/**
	* Menu Constructor: Creates a new menu, with a given PrintWriter
	* @param pw PrintWriter file
	*/
	public menu (PrintWriter pw) {
	     this.pw = pw;                        
	}
	
	/**
	* Displays user options to the console.
	* <p>
	* First, a prompt is given to enter a number.
	*/ 
	public void display() {                      
	
		 System.out.println("Enter a number between (1 to 7):");
		 System.out.println("\n1.Convert Decimal to Binary");
		 System.out.println("\n2.Convert Decimal to Hexdecimal");
		 System.out.println("\n3.Convert Binary to Decimal");
		 System.out.println("\n4.Convert Binary to Hexdecimal");
		 System.out.println("\n5.Convert Hexadecimal to Decimal");
		 System.out.println("\n6.Convert Hexdecimal to Binary");
		 System.out.println("\n7.Exit Conversion Program");
	}
	      
	/**
	* Extracts the user inserted option.
	* <p> 
	* If the user enters an invalid choice, input is prompted again.
	* @return the selection the user inserted
	* get input of user
	*/ 
	public int getSelection() {                
	
	       Scanner scan = new Scanner (System.in);
	       int choice = scan.nextInt();
	       while( choice > 7){
		    System.out.println("Wrong input");
			System.out.println("Enter a number between (1 to 7):");
		    choice = scan.nextInt();
	       }
	       if(choice == 7) {
	           System.out.println("\nPROGRAM COMPLETE");
	 	   }
	       return choice;    
	}
	  
}
	
