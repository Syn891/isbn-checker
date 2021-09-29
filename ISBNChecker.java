
public class ISBNChecker {
    
    public static int ISBN13Length = 13;
    public static int ISBN10Length = 10;


    public static boolean isValidISBN(String isbn) {
        
        String isbnMod = removeChars(isbn);
        boolean isValid = false;
        
        if (isbnMod.length() == ISBN13Length && 
           Character.getNumericValue(isbnMod.charAt(ISBN13Length-1)) == calculateCheckDigit(isbnMod) ) {
           
            return isValid = true;
            
        } else if (isbnMod.length() == ISBN10Length &&
                   isbnMod.charAt(ISBN10Length-1) == calculateTenCheckDigit(isbnMod) ) {
            
            return isValid = true;
        }
        
        return isValid;
        
    }
    
    public static int calculateCheckDigit(String isbn) {
        
        int result = 0;
        
        for (int i = 0; i < isbn.length()-1; i++) {
            
            if( i==0 || i % 2 == 0) {
                
                result = result + Character.getNumericValue(isbn.charAt(i));
                
            } else {
                
               result = result + (Character.getNumericValue(isbn.charAt(i))*3);

            }
        }
        
        result = result % 10;
        
        result = 10 - result;
        
        if (result > 9) {
            
            result = result % 10;
        }
        
        return result;
    }
    
     public static char calculateTenCheckDigit(String isbn) {
        
        int result = 0;
        char checkDigit;
        
        for (int i = 0; i < isbn.length()-1; i++) {

            result = result + (Character.getNumericValue(isbn.charAt(i))*(i+1));
    
        }
         
        result = result % 11;
         
        if (result == 10) {
            
            checkDigit = 'X';
            
        } else {
            
            checkDigit = Character.forDigit(result, 10);
            
        }
         
        return checkDigit;
    }
    
        
    public static String removeChars(String isbn) {
        
        String newStr = isbn.replace("-", "");
        newStr = newStr.replace(" ", "");
        
        return newStr;
    }
   

}
