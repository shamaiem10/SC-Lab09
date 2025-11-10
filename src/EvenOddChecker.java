public class EvenOddChecker {

    public static void main(String[] args) {
        int[] testNumbers = {0, 1, 2, -1, -2, 17, -17,
                             Integer.MAX_VALUE, Integer.MIN_VALUE};

        for (int n : testNumbers) {
            System.out.println("Number: " + n);
            System.out.println("isEven: " + isEven(n));
            System.out.println("isOdd: " + isOdd(n));
            System.out.println("----------------------");
        }
    }

    public static boolean isEven(int n) {
        // Reduce number to avoid deep recursion
        if (n > 1 || n < -1) {
            n = n % 2; 
        }

        if (n == 0) return true;
        if (n == 1 || n == -1) return false;

        return isOdd(n - 1);
    }

    public static boolean isOdd(int n) {
        // Reduce number to avoid deep recursion
        if (n > 1 || n < -1) {
            n = n % 2;
        }

        if (n == 0) return false;
        if (n == 1 || n == -1) return true;

        return isEven(n - 1);
    }
}
