import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TextFormatter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text to format:");
        String text = scanner.nextLine();

        System.out.println("Enter the desired line width:");
        int width = scanner.nextInt();

        // Split text into words
        List<String> words = splitIntoWords(text);

        // Justify text
        String justifiedText = justifyText(words, width);

        // Center-align text
        String centeredText = centerAlignText(words, width);

        // Performance comparison
        long[] performance = comparePerformance(words, width);

        // Display formatted text
        System.out.println("\n--- Original Text ---");
        System.out.println(text);

        System.out.println("\n--- Left-Justified Text ---");
        displayFormattedText(justifiedText);

        System.out.println("\n--- Center-Aligned Text ---");
        displayFormattedText(centeredText);

        System.out.println("\n--- Performance Analysis ---");
        System.out.println("StringBuilder Time (ns): " + performance[0]);
        System.out.println("String Concatenation Time (ns): " + performance[1]);

        scanner.close();
    }
    public static List<String> splitIntoWords(String text) {
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isWhitespace(c)) {
                if (word.length() > 0) {
                    words.add(word.toString());
                    word.setLength(0);
                }
            } else {
                word.append(c);
            }
        }
        if (word.length() > 0) {
            words.add(word.toString());
        }
        return words;
    }
    public static String justifyText(List<String> words, int width) {
        StringBuilder result = new StringBuilder();
        List<String> currentLine = new ArrayList<>();
        int currentLength = 0;

        for (String word : words) {
            // Check if adding the new word would make the line too long.
            // The '+ currentLine.size()' accounts for the spaces between words.
            if (!currentLine.isEmpty() && (currentLength + word.length() + currentLine.size() > width)) {
                // The current line is full. Format and append it to the result.
                int spacesNeeded = width - currentLength;
                int gaps = currentLine.size() - 1;

                if (gaps <= 0) { // If there's only one word on the line
                    result.append(currentLine.get(0));
                    for (int i = 0; i < spacesNeeded; i++) {
                        result.append(" ");
                    }
                } else {
                    int spacesPerGap = spacesNeeded / gaps;
                    int extraSpaces = spacesNeeded % gaps;
                    for (int i = 0; i < currentLine.size() - 1; i++) {
                        result.append(currentLine.get(i));
                        for (int j = 0; j < spacesPerGap; j++) {
                            result.append(" ");
                        }
                        if (extraSpaces > 0) {
                            result.append(" ");
                            extraSpaces--;
                        }
                    }
                    result.append(currentLine.get(currentLine.size() - 1));
                }
                result.append("\n");

                // Start a new line with the current word
                currentLine.clear();
                currentLength = 0;
            }

            // Add the current word to the new or existing line
            currentLine.add(word);
            currentLength += word.length();
        }

        // Handle the last line (left-aligned)
        if (!currentLine.isEmpty()) {
            result.append(String.join(" ", currentLine));
        }

        return result.toString();
    }
    public static String centerAlignText(List<String> words, int width) {
        StringBuilder result = new StringBuilder();
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            if (!currentLine.isEmpty() && currentLine.length() + word.length() + 1 > width) {
                int padding = (width - currentLine.length()) / 2;
                for (int i = 0; i < padding; i++) {
                    result.append(" ");
                }
                result.append(currentLine).append("\n");
                currentLine.setLength(0);
            }
            if (currentLine.length() > 0) {
                currentLine.append(" ");
            }
            currentLine.append(word);
        }

        if (currentLine.length() > 0) {
            int padding = (width - currentLine.length()) / 2;
            for (int i = 0; i < padding; i++) {
                result.append(" ");
            }
            result.append(currentLine);
        }

        return result.toString();
    }
    public static long[] comparePerformance(List<String> words, int width) {
        long startTimeBuilder = System.nanoTime();
        justifyText(words, width);
        long endTimeBuilder = System.nanoTime();

        long startTimeString = System.nanoTime();
        // A simplified justification for comparison purposes
        String result = "";
        for(String word : words) {
            result += word + " ";
        }
        // "Use" the result to avoid the compiler warning in your screenshot
        if (result.length() > -1) { // This is always true
           // Do nothing, just "use" the variable
        }
        long endTimeString = System.nanoTime();

        return new long[]{endTimeBuilder - startTimeBuilder, endTimeString - startTimeString};
    }

    public static void displayFormattedText(String formattedText) {
        if(formattedText == null || formattedText.isEmpty()) return;
        String[] lines = formattedText.split("\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.printf("%d: %s (%d chars)%n", i + 1, lines[i], lines[i].length());
        }
    }
}