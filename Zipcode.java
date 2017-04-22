//*********************************
//Jessica Gary 
//Java 1004 Fall 2016
//
// Zipcode class   
//
// This is a template for your Zipcode class
// You may add methods and instance variables to this
// class but your code must work with the provided test class ZipTest.java
//

//Your program should also be able to carry out the opposite conversion:
// Translate bars into their ZIP code, 
//reporting any errors in the input format or a mismatch of the digits.
// //If want to convert the barcode back -->put this in main 
        //String temp = code.getBarcode(); 
    	//System.out.println("The original zipcode was: " + code.makeZipCode(temp));

//Horstmann, Cay S. (2015-07-07). Big Java: Early Objects, 6th Edition (Page 418). Wiley. Kindle Edition. 
//*********************************


public class Zipcode{


    private String zipcode;
    private String barcode;
    private int check_digit_int; 
    private String check_digit; 

    public Zipcode () {} 			//default constructor 
    public Zipcode(int zip_number)	//constructor 
    {
    	zipcode = Integer.toString(zip_number); 
    	check_digit_int = this.checkDigit(zip_number); 	//get the checkdigit. 
    	check_digit = Integer.toString(check_digit_int); 
    	zipcode = zipcode + check_digit; 
    	//System.out.println("The zipcode with check digit is " + zipcode);
    	barcode = this.makeBarcode(zipcode); // pass on the zipcode+checkdigit. the whole shebang. 
    	
    	
    	
    }
    private int checkDigit(int zipcode)	//checkDigit is the number which makes the sum of all digits in a zipcode a multiple of 10. 
    {
    	int sum = 0; 
    	int num = zipcode;		//houses the remainder 
    	int temp = 0; 
    	 while (num>0)			//parsing through from back of # to front and add the number to sum as we go
    	 {
    		  temp = num%10; 		//get the remainder. i.e. obtain the last number of the "95126"
    		  sum+=temp; 		//add the last digit to sum 
    		  num /= 10; 		//now get rid of the last digit; 95126 --> 9512 (since num is an int, no decimals)	  
    		  
    	 }
    	 temp = sum%10; 		//calculate the number to add to the sum in order to get a multiple of 10. 23%10 = 3
    	 temp = 10 -temp; 			//10-3 = 7; 7+23 = 30, which is a multiple of 10!!!!! 
    	// System.out.println("the check digit is " + temp);
    	 return temp; 			//return the checkDigit.
    }
   
    private String makeBarcode(String barcode) //make barcode from zipcode (including checkDigit) 
    {
    	String bar = "|";
    	int int_bar = Integer.parseInt(barcode);
    	int temp = 0; 
    	int divider = 100000; 
    	for (int i= 0; i<6; i++)
    	{
    		temp = int_bar/divider;  
    		bar += digittoBarcode(temp); 
    		int_bar = int_bar - (temp*divider); 
    		divider/=10; 
    	}
    	bar += "|"; 
    	return bar; 
    }
    public int makeZipCode(String barcode)	 //if given a barcode, this method will convert it into zipcode (wihtout the checkDigit)
    {
    	String zip = ""; 
    	String sub = ""; 
    	for (int i = 1; i<26; i+=5)
    	{
    		sub = barcode.substring(i, i+5);
    		//System.out.println(" at " + i +" : " + sub);
    		//System.out.println(BartoZip(sub));
    		zip += BartoZip(sub); 
    	}
    	return Integer.parseInt(zip); 
    }
    private String digittoBarcode(int num) 	// this method takes the given integer and convert into postal barcode
    {		// could have used switch() here as easily as well. 
    	if (num == 1)
    	{
    		return ":::||"; 
    	}
    	if (num ==2)
    	{
    		return "::|:|"; 
    	}
    	if (num == 3) 
    	{
    		return "::||:";
    	}
    	if (num ==4) 
    	{
    		return ":|::|";
    	}
    	if (num ==5)
    	{
    		return ":|:|:";
    	}
    	if (num ==6) 
    	{
    		return ":||::";
    	}
    	if (num == 7)
    	{
    		return "|:::|";
    	}
    	if (num == 8) 
    	{
    		return "|::|:";
    	}
    	if (num ==9)
    	{
    		return "|:|::";
    		
    	}
    	return "||:::"; 		//for the case of num == 0; can't seem to put it as a condition to another if statement... 
    }
    private int BartoZip(String bar)	//convert barcode to zipcode 
    { 	//could have used switch() here to make it more readable. 
    	if (bar.equals(":::||"))
    	{
    		return 1; 
    	}
    	if (bar.equals("::|:|"))
    	{
    		return 2; 
    	}
    	if (bar.equals("::||:")) 
    	{
    		return 3;
    	}
    	if (bar.equals(":|::|")) 
    	{
    		return 4;
    	}
    	if (bar.equals(":|:|:"))
    	{
    		return 5;
    		
    	}
    	if (bar.equals(":||::")) 
    	{
    		return 6;
    	}
    	if (bar.equals("|:::|"))
    	{
    		return 7;
    	}
    	if (bar.equals("|::|:")) 
    	{
    		return 8;
    	}
    	if (bar.equals("|:|::"))
    	{
    		return 9;
    		
    	}
    	return 0; 
    	
    }




    public String getBarcode()	//Accessor method, retrieves the barcode to the corresponding zipcode. 
    {
	//leave this method as is
        return barcode;
    }

}


