public class NonReentrantRecursiveSum {

    // ❌ Shared mutable data → NOT reentrant
    private static int total = 0;

    // Non-reentrant recursive sum method
    public static int sumArrayNonReentrant(int[] arr, int index) {
        if (index < 0) return total;
        total += arr[index];
        return sumArrayNonReentrant(arr, index - 1);
    }

    // ✅ Synchronized version (thread-safe)
    public static synchronized int sumArrayNonReentrantSync(int[] arr, int index) {
        if (index < 0) return total;
        total += arr[index];
        return sumArrayNonReentrantSync(arr, index - 1);
    }

    // Thread class for testing
    static class SumThread extends Thread {
        private int[] arr;
        private boolean sync;

        SumThread(int[] arr, boolean sync) {
            this.arr = arr;
            this.sync = sync;
        }

        @Override
        public void run() {
            // Reset shared total before each test run
            total = 0;

            if (sync)
                System.out.println(getName() + " (SYNC) → " + sumArrayNonReentrantSync(arr, arr.length - 1));
            else
                System.out.println(getName() + " (NO SYNC) → " + sumArrayNonReentrant(arr, arr.length - 1));
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        System.out.println("🚫 Non-Reentrant Without Sync (Incorrect Results Expected)");
        Thread t1 = new SumThread(array, false);
        Thread t2 = new SumThread(array, false);
        Thread t3 = new SumThread(array, false);
        t1.start(); t2.start(); t3.start();

        try { Thread.sleep(1000); } catch (Exception e) {}

        System.out.println("\n✅ Non-Reentrant WITH Sync (Correct Results Expected)");
        Thread t4 = new SumThread(array, true);
        Thread t5 = new SumThread(array, true);
        Thread t6 = new SumThread(array, true);
        t4.start(); t5.start(); t6.start();
    }
}
