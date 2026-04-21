import java.util.regex.Pattern;

public class Example {

    public static void main(String[] args) {

        // Check for exactly 2 arguments
        if (args.length != 2) {
            System.out.println("Error: Please provide exactly 2 arguments.");
            return;
        }

        String charInput = args[0];
        String str = args[1];

        // Check if first argument is a single character
        if (charInput.length() != 1) {
            System.out.println("Error: First argument must be a single character.");
            return;
        }

        char ch = charInput.charAt(0);

        // Approach 1: Loop
        System.out.println("Approach 1 (Loop):");
        repeatUsingLoop(ch, str);

        // Approach 2: replaceAll
        System.out.println("Approach 2 (replace method):");
        repeatUsingReplace(ch, str);

        // Approach 3: Recursion
        System.out.println("Approach 3 (Recursion):");
        repeatUsingRecursion(str, ch, 0);
        System.out.println(); // for proper formatting
    }

    // Method 1: Using loop
    static void repeatUsingLoop(char ch, String str) {
        for (char c : str.toCharArray()) {
            if (c == ch) {
                System.out.print(c + " ");
            }
        }
        System.out.println();
    }

    // Method 2: Using replaceAll (fixed with Pattern.quote)
    static void repeatUsingReplace(char ch, String str) {
        String result = str.replaceAll("[^" + Pattern.quote(String.valueOf(ch)) + "]", "");
        System.out.println(result);
    }

    // Method 3: Using recursion
    static void repeatUsingRecursion(String str, char ch, int index) {
        if (index >= str.length()) return;

        if (str.charAt(index) == ch) {
            System.out.print(ch + " ");
        }

        repeatUsingRecursion(str, ch, index + 1);
    }
}