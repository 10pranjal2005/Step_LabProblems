import java.util.Scanner;

public class CaseConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text to convert:");
        String inputText = scanner.nextLine();

        // Convert to uppercase
        String upperCaseText = toUpperCase(inputText);

        // Convert to lowercase
        String lowerCaseText = toLowerCase(inputText);

        // Convert to title case
        String titleCaseText = toTitleCase(inputText);

        // Compare with built-in methods
        boolean upperCaseMatch = compareWithBuiltIn(upperCaseText, inputText.toUpperCase());
        boolean lowerCaseMatch = compareWithBuiltIn(lowerCaseText, inputText.toLowerCase());

        // Display the results in a tabular format
        System.out.println("\n--- Case Conversion Results ---");
        System.out.printf("%-15s %-30s %s%n", "Conversion", "Result", "Matches Built-in");
        System.out.printf("%-15s %-30s %b%n", "Uppercase", upperCaseText, upperCaseMatch);
        System.out.printf("%-15s %-30s %b%n", "Lowercase", lowerCaseText, lowerCaseMatch);
        System.out.printf("%-15s %-30s%n", "Title Case", titleCaseText);

        scanner.close();
    }
    public static char toUpperCase(char c) {
        if (c >= 'a' && c <= 'z') {
            return (char) (c - 32);
        }
        return c;
    }
    public static String toUpperCase(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append(toUpperCase(c));
        }
        return result.toString();
    }
    public static char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32);
        }
        return c;
    }
    public static String toLowerCase(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append(toLowerCase(c));
        }
        return result.toString();
    }
    public static String toTitleCase(String text) {
        StringBuilder result = new StringBuilder();
        boolean capitalize = true;
        for (char c : text.toCharArray()) {
            if (Character.isWhitespace(c)) {
                capitalize = true;
                result.append(c);
            } else if (capitalize) {
                result.append(toUpperCase(c));
                capitalize = false;
            } else {
                result.append(toLowerCase(c));
            }
        }
        return result.toString();
    }
    public static boolean compareWithBuiltIn(String customResult, String builtInResult) {
        return customResult.equals(builtInResult);
    }
}