class Practical7A {

    static long rfact(long n) {
        if (n == 0 || n == 1)
            return 1;
        if (n < 0) {
            System.out.println("n should be greater than 0");
            return 0;
        }
        return n * rfact(n - 1);
    }

    static long ifact(long n) {
        if (n < 0) {
            System.out.println("n should be greater than 0");
            return 0;
        }

        long total = 1;
        for (long i = 1; i <= n; i++) {
            total *= i;
        }
        return total;
    }

    public static void main(String[] args) {

        long n = 20;
        int runs = 1000;

        long f1tt = 0, f2tt = 0;

        for (int i = 0; i < runs; i++) {

            long start1 = System.nanoTime();
            ifact(n);
            long end1 = System.nanoTime();
            f1tt += (end1 - start1);

            long start2 = System.nanoTime();
            rfact(n);
            long end2 = System.nanoTime();
            f2tt += (end2 - start2);
        }

        double f1avg = (double) f1tt / runs;
        double f2avg = (double) f2tt / runs;

        System.out.println("Iterative Total Time (f1tt): " + f1tt);
        System.out.println("Iterative Avg Time (f1avg): " + f1avg);
        System.out.println("Recursive Total Time (f2tt): " + f2tt);
        System.out.println("Recursive Avg Time (f2avg): " + f2avg);
    }
}