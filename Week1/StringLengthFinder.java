import java.util.Scanner;

public class StringLengthFinder {

    // Method to find string length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count); // try to access characters one by one
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception occurs when count exceeds string length
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a string: ");
        String input = s.nextLine(); // <-- FIXED

        // Calling our custom method
        int customLength = findLength(input);

        // Using built-in length() for comparison
        int builtInLength = input.length();

        // Displaying results
        System.out.println("Length using custom method: " + customLength);
        System.out.println("Length using built-in method: " + builtInLength);

        s.close();
    }
}
