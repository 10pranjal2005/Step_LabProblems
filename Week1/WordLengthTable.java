import java.util.Scanner;

public class WordLengthTable {

    // Method to find string length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {}
        return count;
    }

    // Method to split words without split()
    public static String[] splitWords(String str) {
        int len = findLength(str);
        String word = "";
        int spaceCount = 0;

        // count spaces
        for (int i = 0; i < len; i++) if (str.charAt(i) == ' ') spaceCount++;
        String[] words = new String[spaceCount + 1];
        int idx = 0;

        // extract words
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                words[idx++] = word;
                word = "";
            } else {
                word += str.charAt(i);
            }
        }
        words[idx] = word; // last word
        return words;
    }

    // Method to return 2D array [word, length]
    public static String[][] wordWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    // Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] words = splitWords(input);
        String[][] table = wordWithLengths(words);

        System.out.println("\nWord\tLength");
        System.out.println("----------------");
        for (String[] row : table) {
            System.out.println(row[0] + "\t" + Integer.valueOf(row[1])); // convert back to int
        }

        sc.close();
    }
}
