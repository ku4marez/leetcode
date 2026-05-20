package algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {

    @Test
    void isPalindrome() {
        assertTrue(ArithmeticOperations.isPalindrome(121));
        assertFalse(ArithmeticOperations.isPalindrome(-121));
        assertFalse(ArithmeticOperations.isPalindrome(10));
    }

    @Test
    void isHappy() {
        assertTrue(ArithmeticOperations.isHappy(19));
        assertFalse(ArithmeticOperations.isHappy(2));
    }

    @Test
    void addDigits() {
        assertEquals(2, ArithmeticOperations.addDigits(236));
        assertEquals(0, ArithmeticOperations.addDigits(0));
    }

    @Test
    void isUgly() {
        assertTrue(ArithmeticOperations.isUgly(6));
        assertTrue(ArithmeticOperations.isUgly(15));
        assertFalse(ArithmeticOperations.isUgly(14));
    }
}
