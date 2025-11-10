
public class IntegerToStringConversion {

	public IntegerToStringConversion() {
		// TODO Auto-generated constructor stub
	}
	
	// Recursive method to convert integer n to string in given base
	public static String stringValue(int n, int base) {
	    // Validate base
	    if (base < 2 || base > 36) {
	        throw new IllegalArgumentException("Base must be between 2 and 36.");
	    }

	    // Handle negative numbers
	    if (n < 0) {
	        return "-" + stringValue(-n, base);
	    }

	    // Base case: single digit
	    if (n < base) {
	        return String.valueOf(digitToChar(n));
	    }

	    // Recursive case: divide and process higher digits
	    return stringValue(n / base, base) + digitToChar(n % base);
	}
	// Helper method to convert a digit to character
	private static char digitToChar(int digit) {
	    if (digit < 10) {
	        return (char) ('0' + digit); // digits 0-9
	    } else {
	        return (char) ('A' + (digit - 10)); // digits 10-35 → A-Z
	    }
	}

	public static String stringValueIterative(int n, int base) {
	    if (base < 2 || base > 36) {
	        throw new IllegalArgumentException("Base must be between 2 and 36.");
	    }

	    if (n == 0) return "0";

	    boolean negative = n < 0;
	    long num = Math.abs((long) n); // handle Integer.MIN_VALUE
	    StringBuilder sb = new StringBuilder();

	    while (num > 0) {
	        sb.insert(0, digitToChar((int) (num % base)));
	        num /= base;
	    }

	    if (negative) sb.insert(0, "-");
	    return sb.toString();
	}

	public static void main(String[] args) {
	    System.out.println("Recursive Tests:");
	    System.out.println(stringValue(255, 2));    // "11111111"
	    System.out.println(stringValue(255, 16));   // "FF"
	    System.out.println(stringValue(-31, 16));   // "-1F"
	    System.out.println(stringValue(123456, 36));// "2N9C"

	    System.out.println("\nIterative Tests:");
	    System.out.println(stringValueIterative(255, 2));   
	    System.out.println(stringValueIterative(255, 16));  
	    System.out.println(stringValueIterative(-31, 16));  
	    System.out.println(stringValueIterative(123456, 36));

	    // Optional: performance comparison
	    long start = System.nanoTime();
	    stringValue(123456789, 36);
	    long end = System.nanoTime();
	    System.out.println("Recursive Time: " + (end - start) + " ns");

	    start = System.nanoTime();
	    stringValueIterative(123456789, 36);
	    end = System.nanoTime();
	    System.out.println("Iterative Time: " + (end - start) + " ns");
	}


}
