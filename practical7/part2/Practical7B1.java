class Practical7B1 {

    static int func(String s1, String s2, int i) {

        if (i > s1.length() - s2.length())
            return 0;

        int count = 0;

        if (s1.substring(i, i + s2.length()).equals(s2)) {
            count = 1;
        }

        return count + func(s1, s2, i + 1);
    }

    public static void main(String[] args) {

        String s1 = "javapractical";
        String s2 = "jaava";
        int runs = 1000;

        long f1tt = 0, f2tt = 0;

        for (int r = 0; r < runs; r++) {

            long start1 = System.nanoTime();

            int countIterative = 0;
            for (int i = 0; i <= s1.length() - s2.length(); i++) {
                if (s1.substring(i, i + s2.length()).equals(s2)) {
                    countIterative++;
                }
            }

            long end1 = System.nanoTime();
            f1tt += (end1 - start1);

            long start2 = System.nanoTime();
            func(s1, s2, 0);
            long end2 = System.nanoTime();
            f2tt += (end2 - start2);
        }

        double f1avg = (double) f1tt / runs;
        double f2avg = (double) f2tt / runs;

        System.out.println("Iterative Total Time: " + f1tt);
        System.out.println("Iterative Avg Time: " + f1avg);
        System.out.println("Recursive Total Time: " + f2tt);
        System.out.println("Recursive Avg Time: " + f2avg);
    }
}