import java.util.Scanner;

public class CustomSplitExample {

    // Method to find string length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // stop when index out of bounds
        }
        return count;
    }

    // Method to split string into words without using split()
    public static String[] splitWords(String str) {
        int len = findLength(str);
        String word = "";
        int countSpaces = 0;

        // count spaces to find number of words
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') countSpaces++;
        }

        String[] words = new String[countSpaces + 1];
        int index = 0;

        // build words manually
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                words[index++] = word;
                word = "";
            } else {
                word += str.charAt(i);
            }
        }
        words[index] = word; // last word
        return words;
    }

    // Compare two string arrays
    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    // Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // Custom split
        String[] customSplit = splitWords(input);

        // Built-in split
        String[] builtinSplit = input.split(" ");

        // Show results
        System.out.println("\nCustom Split:");
        for (String w : customSplit) System.out.println(w);

        System.out.println("\nBuilt-in Split:");
        for (String w : builtinSplit) System.out.println(w);

        // Compare both
        System.out.println("\nAre both splits identical? " + compareArrays(customSplit, builtinSplit));

        sc.close();
    }
}
