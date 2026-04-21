class VarargsDemo {

    static void sum(int... nums) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        System.out.println("Sum = " + total);
    }

    public static void main(String[] args) {
        sum(1, 2);
        sum(1, 2, 3, 4);
    }
}