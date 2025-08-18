import java.util.Scanner;

public class TrimString {

    // returns {startIndexInclusive, endIndexExclusive} after trimming spaces using charAt()
    static int[] findTrimIndices(String s) {
        int n = s.length();
        int start = 0;
        while (start < n && s.charAt(start) == ' ') start++;
        int end = n - 1;
        while (end >= start && s.charAt(end) == ' ') end--;
        if (start > end) return new int[] {0, 0}; // all spaces -> empty
        return new int[] { start, end + 1 };
    }

    // create substring using charAt() from start (inclusive) to end (exclusive)
    static String manualSubstring(String s, int start, int endExclusive) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < endExclusive; i++) sb.append(s.charAt(i));
        return sb.toString();
    }

    // compare two strings using charAt()
    static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) != b.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        sc.close();

        int[] idx = findTrimIndices(text);
        String trimmedManual = manualSubstring(text, idx[0], idx[1]);
        String trimmedBuiltin = text.trim();

        System.out.println("Manual trimmed : \"" + trimmedManual + "\"");
        System.out.println("Built-in trim  : \"" + trimmedBuiltin + "\"");
        System.out.println("Equal? " + (compareStrings(trimmedManual, trimmedBuiltin) ? "Yes" : "No"));
    }
}