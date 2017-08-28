package NumSystem;
import java.io.*;
import java.util.*;

/**
 * Class that transform a Decimal to binary and Hexadecimal.
 * Mahta Ellis
 */
public class Decimal {  

	private PrintWriter pw;
    int decimalNumber;
    int dec_num_bin;
    int dec_num_hex;
    String bin,hex ="";
    StringBuilder conversion;
       
   	/**
  	  * Constructor for object of class Decimal
        * @param pw PrintWriter files
  	 */
	 public Decimal (PrintWriter pw) {             
	       this.pw = pw; 
	 }
	 
	/**
	 * Method that transforms a decimal to binary. 
	 *<p>
	 * Gets the input from the console, converts and stores as a binary value,
	 * and outputs to the console and a file using PrintWriter
	 * @see java.io.PrintWriter
	**/        
	 public void decToBin() {
	     getDecimalInput();
	     convertToBinary();
	     printBinaryOutput();
	 }
	 
	 /**
	  * Method that transforms a decimal to hexadecimal
	  * <p>
	  * Gets input from console as a decimal, converts and stores as hexadecimal value, 
	  * and outputs result to the console, as well as outputting to a file with PrintWriter
	  * @see java.io.PrintWriter
	 */      
	 public void decToHex(){
	     getDecimalInput();
	     convertToHexadecimal();
	     printHexadecimalOutput();
	 }
	 
	/**
	 * Gets input from the console and stores as decimal value
	 * The convert number will output to a file using PrintWriter
     * @see java.io.PrintWriter
	**/
	 private void getDecimalInput() {
	     bin = "";
	     hex = "";
	     Scanner scan = new Scanner (System.in);
	     System.out.println("Enter a Decimal Number:");
	     pw.println("Decimal Number:");
	     String dec = "";
	     dec = scan.nextLine();
	     pw.println(dec);   
	     decimalNumber = Integer.parseInt(dec);
	 }
   
	/**
	 * Converts decimal value to binary, and stores result
	**/
	 private void convertToBinary() {
	     while (decimalNumber>0) { 
	         dec_num_bin = decimalNumber%2;
	         decimalNumber = decimalNumber/2;
	         bin += dec_num_bin;
	     }
	     while (bin.length()< 32) {
	         bin += 0;
	     }
	 
	     while (bin.length()< 32) {
		     bin += 0;
		 }   
	}
   
	/**
	 * Print binary value of the decimal number to the console, 
	 * and to a file using PrintWriter
	 * @see java.io.PrintWriter
	**/
     private void printBinaryOutput() {

		System.out.println("Binary Number:");
		pw.println("Binary Number:");
		
		for (int i= 0; i< 32; i+=4)
		{
		    System.out.print((new StringBuilder (bin).reverse().toString()).substring(i,i+4)+' ');
		    pw.print((new StringBuilder (bin).reverse().toString()).substring(i,i+4)+' ');
		}
		System.out.println("\n");
		pw.println("\n");
   }
	
     /**
	  * Converts Decimal value to Hexadecimal
	 */   
      private void convertToHexadecimal() {
		  String convertHex; 
		  while (decimalNumber>0)
		  {  
		      dec_num_hex = decimalNumber%16;
		      decimalNumber = decimalNumber/16;
		      convertHex = Integer.toString(dec_num_hex);
		      switch (dec_num_hex){
		          case 10:convertHex="A"; break;
		          case 11:convertHex="B"; break;
		          case 12:convertHex="C"; break;
		          case 13:convertHex="D"; break;
		          case 14:convertHex="E"; break;
		          case 15:convertHex="F"; break;
		      }
		      hex = hex + convertHex;
		    }
  	  }
     
    /**
 	  * Prints the Decimal as a Hexadecimal value to the console, 
 	  * and outputs to a file using PrintWriter
 	  * <p>
 	  * Reverses the order of the string before printing out
 	  * @see java.io.PrintWriter
 	 */  
	private void printHexadecimalOutput()
	{
	    System.out.println("Hexadecimal Number:");
	    System.out.println(new StringBuilder(hex).reverse()+"\n");
	    pw.println("Hexadecimal Number:");
	    pw.println(new StringBuilder(hex).reverse()+"\n");
	}
   
}

