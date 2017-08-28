package NumSystem;
import java.io.*;
import java.util.*;

/**
 * Hexadecimal Class: Contains methods to convert Hexadecimal 
 * to Binary or Decimal. 
 * <p>
 * Calculated value are outputted to the console and PrintWriter 
 * is used to output values to a file.
 * @see java.io.PrintWriter
 * Mahta Ellis 
 */
public class Hexadecimal {      
	
	private PrintWriter pw;
    String hex_num;
    String bin = "";
    int intValue=0;
    int hex;
    double intPreFinal=0;
    double intFinal;
	               
    /**
     * Constructor for object of class Hexadecimal
     * @param pw PrintWriter files.
     */              
	public Hexadecimal (PrintWriter pw) {
		    this.pw = pw;
	}
	
	/**
     * Method that transforms a hexadecimal to decimal
	 * <p>
	 * Gets the input from the console, converts and stores as a hexadecimal value,
	 * and outputs to the console and a file using PrintWriter
	 * 
	 * @see java.io.PrintWriter
     */              
	public void hexToDec() {  
	    getHexInput();
	    convertToDecimal();
	    printDecimalOutput();
	}
	
	/**
     * Prompts the user to enter a hexadecimal value and stores it in hex_num. 
     * The convert number will output to a file using PrintWriter
     * @see java.io.PrintWriter
     */
    private void getHexInput() {      
        Scanner keyboard = new Scanner (System.in);
        System.out.println("Enter a Hexadecimal Number:");
        hex_num = keyboard.nextLine();
        pw.println("Hexadecimal Number: ");
        pw.println(hex_num);
        hex_num.toUpperCase();
    }
    
    /**
     * Method that transforms a hexadecimal to binary
	 *<p>
	 * Gets the input from the console, converts and stores as a binary value,
	 * and outputs to the console and a file using PrintWriter
	 * @see java.io.PrintWriter
     */                                   
    public void hexToBin() {
	    getHexInput();
	    convertToBin();
	    printBinaryOutput();
    }
    
	/**
	 * Converts decimal value to binary, and stores result.
	 * <p>
	 *  Adds extra 0 to the String of binary number until the length of the string become 32
	**/
    public void convertToBin() {        
        int Binary = 0;
        intPreFinal = 0;
        bin = ""; 
        int intStringLength = hex_num.length();
        int exp = intStringLength;

       for (int i = 0; i < intStringLength; i++) {
          hex = Integer.parseInt(""+hex_num.charAt(i),16);
          intValue = Character.getNumericValue(hex_num.charAt(i));
          intPreFinal = intPreFinal + ((intValue)*Math.pow(16, --exp));
       }
       intFinal = intPreFinal;
       int intTest = (int)intPreFinal;
       double grand = intTest;
       int j = 0; 
    
       for(int i = 0;intTest >= Math.pow(2,i);i++) {
    	   j = i;
       }
       for(;j >= 0;j--){
    	   Binary = 0;
	        if (grand >= Math.pow(2,j))
	            Binary = 1;
	        grand = grand - Math.pow(2,j) * Binary;
	        bin += Integer.toString(Binary);
	   }
       while (bin.length()< 32) {
            bin = "0" + bin;
	   }
	}
    
    /**
     * Prints the hexadecimal value as a binary number and outputs 
     * to a file using PrintWriter.
     * <p>
     * StringBuilder is used to build the String containing the binary number
     * 
     * @see java.lang.StringBuilder
     * @see java.io.PrintWriter
     */
    public void printBinaryOutput() {
		  System.out.println("Binary Number:");
		  pw.println("Binary Number:");
		
	      StringBuilder sb = new StringBuilder();
	      sb.append(bin);
	      int intLen = sb.length();
	
	      for (int i = 0; i < intLen/4; i++) {
	          sb.insert(i*5, " ");
		  }
		  sb.delete(0,1);
		  System.out.println(sb+"\n");
		  pw.println(sb+"\n");
    }
    
    /**
     * Converts the hexadecimal value to decimal.
     */
    private void convertToDecimal() {
       int exp = hex_num.length();
       intPreFinal = 0;
  
	    for (int i = 0; i < hex_num.length(); i++) {
	         
           intValue = Character.getNumericValue(hex_num.charAt(i));
           intPreFinal += ((intValue)*Math.pow(16, --exp));
	    }
    }

    /**
      * Displays the hexadecimal value as a Decimal and outputs
      * the value to a file using PrintWriter.
      * @see java.io.PrintWriter
     */
     private void printDecimalOutput() {           

         int intFinal = (int)intPreFinal;
         System.out.println("Decimal Number:");
         pw.println("Decimal Number:");
         System.out.println(intFinal+"\n");
         pw.println(intFinal+"\n");
     }   

}
