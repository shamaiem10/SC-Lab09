public class ReentrantRecursiveSum {

    public ReentrantRecursiveSum() {
        // Constructor not needed for static methods
    }

    // Reentrant recursive sum method
    public static int sumArray(int[] arr, int index) {
        if (index < 0) return 0; // base case
        return arr[index] + sumArray(arr, index - 1); // recursive call
    }

    // Thread class to compute sum
    static class SumThread extends Thread {
        private int[] arr;

        SumThread(int[] arr) {
            this.arr = arr;
        }

        @Override
        public void run() {
            int result = sumArray(arr, arr.length - 1);
            System.out.println(Thread.currentThread().getName() + " computed sum: " + result);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        // Simple test
        int total = sumArray(array, array.length - 1);
        System.out.println("Sum of array: " + total);

        // Create multiple threads to demonstrate reentrancy
        Thread t1 = new SumThread(array);
        Thread t2 = new SumThread(array);
        Thread t3 = new SumThread(array);

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}
