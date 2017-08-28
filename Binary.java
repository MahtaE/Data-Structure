package NumSystem;
import java.io.*;
import java.util.Scanner;

/**
 * class that transform a 32 bit binary number to decimal and Hexadecimal.
 * @author MahtaEllis
 */
public class Binary {
	
	/**
	 * The number of binary bits to represent integers
	**/
	public static final int NUMBER_OF_BITS = 32;
	
	private PrintWriter pw;
	private int exp = 0;
	private int dec = 0;
	private String binaryNumber;
	    
	/**
	 * Binary constructor: initializes the PrintWriter and binaryNumber.
	 * @param pw PrintWriter files
	 */
    public Binary (PrintWriter pw) {  
	    this.pw = pw;   
	    binaryNumber = "";
    }
    
	/**
	 * Method that transforms a binary to decimal. 
	 *<p>
	 * Gets the input from the console, converts and stores as a decimal value,
	 * and outputs to the console and a file using PrintWriter
	 * @see java.io.PrintWriter
	**/
	  public void binToDec()  {
        getBinaryInput();
        convertToDecimal();
        printDecimalOutput();
     }
	  
	/**
	 * Method that transforms a binary to hexadecimal. 
	 * <p>
     * The convert number will output to a file using PrintWriter
     * @see java.io.PrintWriter
	**/
	private void getBinaryInput() {
        dec = 0;
        Scanner keyboard = new Scanner (System.in);
        System.out.println("Please Enter a Binary Number:");
        pw.println("Binary Number:");
        binaryNumber = keyboard.nextLine();
        pw.println(binaryNumber);
	}

	/**
	 * Converts a binary to decimal
	 * Post-Condition: dec (instance variable) is set to the decimal value
	**/
    private void convertToDecimal() {
    
        int intValue = 0;
        binaryNumber = binaryNumber.replace(" ", "").trim();
        int length = binaryNumber.length();
        int exp = binaryNumber.length();
        
        for (int i = 0; i < length; i++) {
        	intValue = Character.getNumericValue(binaryNumber.charAt(i));
            dec += ((intValue)*Math.pow(2, --exp)); 
        }
    }
	    
	/**
	 * Prints to the console and outputs to a file w/ PrintWriter the Decimal 
	 * Output of the binary number with labels.
	 * @see java.io.PrintWriter
	**/
    private void printDecimalOutput() {

        System.out.println("Decimal Number:");
        System.out.println(dec+"\n");
        pw.println("Decimal Number:");
        pw.println(dec+"\n");
    }
    /**
     * Method take String and add zeros until the number of specified bits (32)
     * @see Binary.NUMBER_OF_BITS
     * @param binaryNumber String containing binary value 
     * @return result String with any extra zeroes
    */ 
    private String padWithZero(String binaryNumber) {
		String result = "";
		int numZeros = NUMBER_OF_BITS - binaryNumber.length();
		for(int i = 0; i < numZeros; i++) {
			result += "0";
		}
		result = result + binaryNumber;
		return result;
	}
       
    /**
     * Method that transforms a binary to hexadecimal
     * <p>
     * Prompts User to enter a binary number and sets binaryNumber,
     * and replaces " " and pads with zeros.
     * <p>
     * Checks for every case "0000" - "1111" and set to the appropriate
     * hexadecimal value. Finally, we output the hexadecimal value w/ a label
    */           
	public void binToHex() {

        System.out.println("Please enter a binary number");
        Scanner keyboard = new Scanner(System.in);
        binaryNumber = keyboard.nextLine();
        pw.println("Binary Number: \n" + binaryNumber);
        binaryNumber = binaryNumber.replace(" ", "").trim();
        binaryNumber = padWithZero(binaryNumber);
        StringBuilder hex = new StringBuilder("00000000");
        int j = 0;  
        int intValue = 0;
        for (int i = 0; i < binaryNumber.length(); i += 4) {
            intValue = Character.getNumericValue(binaryNumber.charAt(i));
            dec += ((intValue)*Math.pow(2, --exp)); 
    		if (binaryNumber.substring(i, i+4).equals("0000")) {
    			hex.setCharAt(j, '0');
    		} else if (binaryNumber.substring(i, i+4).equals("0001")) {
    			hex.setCharAt(j, '1');
    		}  else if (binaryNumber.substring(i, i+4).equals("0010")) {
    			hex.setCharAt(j, '2');
    		}  else if (binaryNumber.substring(i, i+4).equals("0011")) {
    			hex.setCharAt(j, '3');
    		}else if (binaryNumber.substring(i, i+4).equals("0100")) {
    			hex.setCharAt(j, '4');
    		} else if (binaryNumber.substring(i, i+4).equals("0101")) {
    			hex.setCharAt(j, '5');
    		} else if (binaryNumber.substring(i, i+4).equals("0110")) {
    			hex.setCharAt(j, '6');
    		} else if (binaryNumber.substring(i, i+4).equals("0111")) {
    			hex.setCharAt(j, '7');
    		} else if (binaryNumber.substring(i, i+4).equals("1000")) {
    			hex.setCharAt(j, '8');
    		} else if (binaryNumber.substring(i, i+4).equals("1001")) {
    			hex.setCharAt(j, '9');
    		} else if (binaryNumber.substring(i, i+4).equals("1010")) {
    			hex.setCharAt(j, 'A');
    		} else if (binaryNumber.substring(i, i+4).equals("1011")) {
    			hex.setCharAt(j, 'B');
    		} else if (binaryNumber.substring(i, i+4).equals("1100")) {
    			hex.setCharAt(j, 'C');
    		} else if (binaryNumber.substring(i, i+4).equals("1101")) {
    			hex.setCharAt(j, 'D');
    		} else if (binaryNumber.substring(i, i+4).equals("1110")) {
    			hex.setCharAt(j, 'E');
    		} else if (binaryNumber.substring(i, i+4).equals("1111")) {
    			hex.setCharAt(j, 'F');
    		}
    		j = j + 1;
        }  
		System.out.print("Hexadecimal Number:  " + hex + "\n");
        pw.println("Hexadecimal Number: \n" + hex + "\n");
    }
}
  

    