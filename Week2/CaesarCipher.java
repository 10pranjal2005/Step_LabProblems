import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text to encrypt:");
        String originalText = scanner.nextLine();

        System.out.println("Enter the shift value:");
        int shift = scanner.nextInt();

        // Encrypt the text
        String encryptedText = encrypt(originalText, shift);

        // Decrypt the text
        String decryptedText = decrypt(encryptedText, shift);

        // Display ASCII values
        displayAsciiValues("Original Text", originalText);
        displayAsciiValues("Encrypted Text", encryptedText);

        // Validate decryption
        boolean isValid = validateDecryption(originalText, decryptedText);

        // Display results
        System.out.println("\n--- Encryption and Decryption Results ---");
        System.out.println("Original Text: " + originalText);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
        System.out.println("Decryption Validation: " + (isValid ? "Successful" : "Failed"));

        scanner.close();
    }
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result.append((char) ((c - base + shift) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }
    public static void displayAsciiValues(String label, String text) {
        System.out.print("\n" + label + " ASCII Values: ");
        for (char c : text.toCharArray()) {
            System.out.print((int) c + " ");
        }
        System.out.println();
    }
    public static boolean validateDecryption(String originalText, String decryptedText) {
        return originalText.equals(decryptedText);
    }
}