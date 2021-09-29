// A simple example to get you started
// JUnit assertion - the default Java assertion library
// https://junit.org/junit5/

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ISBNCheckerTest {
   
    @Test
    void should_only_be_digits() {
        String expected = "9780131495050";
        String actual = ISBNChecker.removeChars("978-0- 13-1495 05-0");
        System.out.println(actual);
        assertEquals(expected, actual);
    }
    
    @Test
    void check_digit_should_be_0() {
        int expected = 0;
        int actual = ISBNChecker.calculateCheckDigit("5");
        assertEquals(expected, actual);
    }
    
    @Test
    void check_digit_should_be_5() {
        int expected = 5;
        int actual = ISBNChecker.calculateCheckDigit("56");
        assertEquals(expected, actual);
    }
    
    @Test
    void check_digit_should_be_9_with_isbn_13() {
        int expected = 9;
        int actual = ISBNChecker.calculateCheckDigit("9780262134729");
        assertEquals(expected, actual);
    } 
    
    
    @Test
    void check_digit_should_be_0_with_isbn_13() {
        int expected = 0;
        int actual = ISBNChecker.calculateCheckDigit("9780131495050");
        assertEquals(expected, actual);
    }
    
    @Test
    void check_digit_should_be_7_with_isbn_10() {
        char expected = 'X';
        char actual = ISBNChecker.calculateTenCheckDigit("123456789X");
        assertEquals(expected, actual);
    }
    
    @Test
    void check_digit_should_be_2_with_isbn_10() {
        char expected = '2';
        char actual = ISBNChecker.calculateTenCheckDigit("0470845252");
        assertEquals(expected, actual);
    }
    
    @Test
    void should_be_valid_isbn_13_1() {
        boolean expected = true;
        boolean actual = ISBNChecker.isValidISBN("9780131495050");
        assertEquals(expected, actual);
    }
    
    @Test
    void should_be_valid_isbn_13_2() {
        boolean expected = true;
        boolean actual = ISBNChecker.isValidISBN("9780 471 48648 0");
        assertEquals(expected, actual);
    }
    
    @Test
    void should_be_valid_isbn_13_3() {
        boolean expected = true;
        boolean actual = ISBNChecker.isValidISBN("978-0596809485");
        assertEquals(expected, actual);
    }
    
    @Test
    void should_be_valid_isbn_13_4() {
        boolean expected = true;
        boolean actual = ISBNChecker.isValidISBN("978-0-13-149505-0");
        assertEquals(expected, actual);
    }
   
    @Test
    void should_be_valid_isbn_13_5() {
        boolean expected = true;
        boolean actual = ISBNChecker.isValidISBN("978-0-262-13472-9");
        assertEquals(expected, actual);
    }
    
    @Test
    void should_be_valid_isbn_10_1() {
        boolean expected = true;
        boolean actual = ISBNChecker.isValidISBN("0471958697");
        assertEquals(expected, actual);
    }
    
    
    @Test
    void should_be_valid_isbn_10_2() {
        boolean expected = true;
        boolean actual = ISBNChecker.isValidISBN("0 471 60695 2");
        assertEquals(expected, actual);
    }
    
    @Test
    void should_be_valid_isbn_10_3() {
        boolean expected = true;
        boolean actual = ISBNChecker.isValidISBN("0-470-84525-2");
        assertEquals(expected, actual);
    }
    
    @Test
    void should_be_valid_isbn_10_4() {
        boolean expected = true;
        boolean actual = ISBNChecker.isValidISBN("0-321-14653-0");
        assertEquals(expected, actual);
    }
    
    
    
    
}
