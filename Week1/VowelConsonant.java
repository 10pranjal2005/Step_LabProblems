import java.util.Scanner;

public class VowelConsonant {

    // 0 = not a letter, 1 = vowel, 2 = consonant
    static int charType(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch = (char) (ch + ('a' - 'A')); // convert using ASCII
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return 1;
            return 2;
        }
        return 0;
    }

    // returns [vowelCount, consonantCount]
    static int[] countVowelsConsonants(String s) {
        int v = 0, c = 0;
        for (int i = 0; i < s.length(); i++) {
            int t = charType(s.charAt(i));
            if (t == 1) v++;
            else if (t == 2) c++;
        }
        return new int[] { v, c };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        sc.close();

        int[] vc = countVowelsConsonants(text);
        System.out.println("Vowels: " + vc[0]);
        System.out.println("Consonants: " + vc[1]);
    }
}