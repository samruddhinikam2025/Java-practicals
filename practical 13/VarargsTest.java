class VarargsTest {

    static void fun(String... s) {
        System.out.println("String varargs");
    }

    static void fun(int... i) {
        System.out.println("Int varargs");
    }

    public static void main(String[] args) {
        // fun(); // ❌ ambiguous

        fun("Hello", "World"); // String varargs
        fun(1, 2, 3);         // Int varargs
    }
}