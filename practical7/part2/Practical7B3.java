class Practical7B3 {

    static int icount(String s1, String s2) {
        int count = 0;
        for (int i = 0; i <= s1.length() - s2.length(); i++) {
            if (s1.startsWith(s2, i)) {
                count++;
            }
        }
        return count;
    }

    static int rcount(String s1, String s2, int index) {
        if (index > s1.length() - s2.length())
            return 0;

        if (s1.startsWith(s2, index))
            return 1 + rcount(s1, s2, index + 1);

        return rcount(s1, s2, index + 1);
    }

    public static void main(String[] args) {

        String s1 = "samruddhinikam";
        String s2 = "sam";
        int runs = 1000;

        long f1tt = 0, f2tt = 0;

        for (int i = 0; i < runs; i++) {

            long start1 = System.nanoTime();
            icount(s1, s2);
            long end1 = System.nanoTime();
            f1tt += (end1 - start1);

            long start2 = System.nanoTime();
            rcount(s1, s2, 0);
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