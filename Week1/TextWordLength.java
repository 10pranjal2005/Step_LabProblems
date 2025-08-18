import java.util.Scanner;

public class TextWordLength {

    static String[] splitWords(String text) {
        StringBuilder word = new StringBuilder();
        String[] temp = new String[text.length()];
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c != ' ') {
                word.append(c);
            } else if (word.length() > 0) {
                temp[count++] = word.toString();
                word.setLength(0);
            }
        }
        if (word.length() > 0) temp[count++] = word.toString();
        String[] words = new String[count];
        for (int i = 0; i < count; i++) words[i] = temp[i];
        return words;
    }

    static int strLen(String s) {
        int len = 0;
        try {
            while (true) { 
                s.charAt(len); 
                len++; 
            }
        } catch (IndexOutOfBoundsException e) {}
        return len;
    }

    static String[][] wordLenArr(String[] words) {
        String[][] arr = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            arr[i][0] = words[i];
            arr[i][1] = String.valueOf(strLen(words[i]));
        }
        return arr;
    }

    static int[] minMaxLen(String[][] arr) {
        if (arr.length == 0) return new int[]{0, 0};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String[] a : arr) {
            int l = Integer.parseInt(a[1]);
            if (l < min) min = l;
            if (l > max) max = l;
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        sc.close();

        if (text.trim().isEmpty()) {
            System.out.println("No words entered.");
            return;
        }

        String[] words = splitWords(text);
        String[][] arr = wordLenArr(words);
        int[] mm = minMaxLen(arr);

        for (String[] a : arr) 
            System.out.println(a[0] + " : " + a[1]);

        System.out.println("Shortest: " + mm[0]);
        System.out.println("Longest: " + mm[1]);
    }
}
