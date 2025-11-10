import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EvenOddCheckerTest {

    @Test
    void testZero() {
        assertTrue(EvenOddChecker.isEven(0));
        assertFalse(EvenOddChecker.isOdd(0));
    }

    @Test
    void testPositiveNumbers() {
        assertTrue(EvenOddChecker.isEven(10));
        assertFalse(EvenOddChecker.isOdd(10));

        assertTrue(EvenOddChecker.isOdd(7));
        assertFalse(EvenOddChecker.isEven(7));
    }

    @Test
    void testNegativeNumbers() {
        assertTrue(EvenOddChecker.isEven(-20));
        assertFalse(EvenOddChecker.isOdd(-20));

        assertTrue(EvenOddChecker.isOdd(-9));
        assertFalse(EvenOddChecker.isEven(-9));
    }

    @Test
    void testLargeEvenNumber() {
        int largeEven = 1000000; // Safe large even number
        assertTrue(EvenOddChecker.isEven(largeEven));
        assertFalse(EvenOddChecker.isOdd(largeEven));
    }

    @Test
    void testLargeOddNumber() {
        int largeOdd = 999999; // Safe large odd number
        assertFalse(EvenOddChecker.isEven(largeOdd));
        assertTrue(EvenOddChecker.isOdd(largeOdd));
    }
}
