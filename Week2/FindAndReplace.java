import java.util.Scanner;
import java.util.ArrayList;

public class FindAndReplace {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the main text:");
        String mainText = scanner.nextLine();

        System.out.println("Enter the substring to find:");
        String toFind = scanner.nextLine();

        System.out.println("Enter the replacement substring:");
        String toReplace = scanner.nextLine();

        // Find all occurrences of the substring
        ArrayList<Integer> occurrences = findOccurrences(mainText, toFind);

        // Replace the substring manually
        String manualResult = manualReplace(mainText, toFind, toReplace, occurrences);

        // Compare with the built-in replace() method
        boolean isSame = compareWithBuiltIn(mainText, toFind, toReplace, manualResult);

        // Display the results
        System.out.println("\nOriginal Text: " + mainText);
        System.out.println("Manually Replaced Text: " + manualResult);
        System.out.println("Built-in replace() Result: " + mainText.replace(toFind, toReplace));
        System.out.println("Results are the same: " + isSame);

        scanner.close();
    }
    public static ArrayList<Integer> findOccurrences(String text, String toFind) {
        ArrayList<Integer> occurrences = new ArrayList<>();
        int index = text.indexOf(toFind);
        while (index != -1) {
            occurrences.add(index);
            index = text.indexOf(toFind, index + 1);
        }
        return occurrences;
    }
    public static String manualReplace(String text, String toFind, String toReplace, ArrayList<Integer> occurrences) {
        if (occurrences.isEmpty()) {
            return text;
        }

        StringBuilder newText = new StringBuilder();
        int lastIndex = 0;
        for (int index : occurrences) {
            newText.append(text.substring(lastIndex, index));
            newText.append(toReplace);
            lastIndex = index + toFind.length();
        }
        newText.append(text.substring(lastIndex));
        return newText.toString();
    }

    public static boolean compareWithBuiltIn(String text, String toFind, String toReplace, String manualResult) {
        return manualResult.equals(text.replace(toFind, toReplace));
    }
}