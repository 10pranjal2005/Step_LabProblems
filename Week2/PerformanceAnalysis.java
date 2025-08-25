import java.util.Scanner;

public class PerformanceAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of iterations (e.g., 1000, 10000, 100000):");
        int iterations = scanner.nextInt();

        // String concatenation
        long[] stringResult = testStringConcatenation(iterations);

        // StringBuilder
        long[] stringBuilderResult = testStringBuilder(iterations);

        // StringBuffer
        long[] stringBufferResult = testStringBuffer(iterations);

        // Display performance comparison in a tabular format
        displayComparison(stringResult, stringBuilderResult, stringBufferResult);

        scanner.close();
    }
    public static long[] testStringConcatenation(int iterations) {
        long startTime = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "a";
        }
        long endTime = System.currentTimeMillis();
        return new long[] { endTime - startTime, result.length() };
    }
    public static long[] testStringBuilder(int iterations) {
        long startTime = System.currentTimeMillis();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            result.append("a");
        }
        long endTime = System.currentTimeMillis();
        return new long[] { endTime - startTime, result.length() };
    }
    public static long[] testStringBuffer(int iterations) {
        long startTime = System.currentTimeMillis();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            result.append("a");
        }
        long endTime = System.currentTimeMillis();
        return new long[] { endTime - startTime, result.length() };
    }
    public static void displayComparison(long[] stringResult, long[] stringBuilderResult, long[] stringBufferResult) {
        System.out.println("\n--- Performance Comparison ---");
        System.out.printf("%-20s %-20s %s%n", "Method", "Time Taken (ms)", "Memory Efficiency");
        System.out.printf("%-20s %-20d %s%n", "String Concatenation", stringResult[0], "Less Efficient");
        System.out.printf("%-20s %-20d %s%n", "StringBuilder", stringBuilderResult[0], "More Efficient");
        System.out.printf("%-20s %-20d %s%n", "StringBuffer", stringBufferResult[0], "More Efficient (Thread-Safe)");
    }
}