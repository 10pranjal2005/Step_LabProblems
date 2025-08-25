import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmailAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> emails = new ArrayList<>();

        System.out.println("Enter email addresses (type 'done' to finish):");
        while (true) {
            String email = scanner.nextLine();
            if (email.equalsIgnoreCase("done")) {
                break;
            }
            emails.add(email);
        }

        // Analyze and display results
        analyzeAndDisplay(emails);

        scanner.close();
    }
    public static boolean validateEmail(String email) {
        int atSymbolIndex = email.indexOf('@');
        if (atSymbolIndex == -1 || email.lastIndexOf('@') != atSymbolIndex) {
            return false;
        }
        if (email.indexOf('.', atSymbolIndex) == -1) {
            return false;
        }
        return !email.substring(0, atSymbolIndex).isEmpty() && !email.substring(atSymbolIndex + 1).isEmpty();
    }
    public static String[] extractComponents(String email) {
        if (!validateEmail(email)) {
            return new String[] { "N/A", "N/A", "N/A", "N/A" };
        }
        int atSymbolIndex = email.indexOf('@');
        String username = email.substring(0, atSymbolIndex);
        String domain = email.substring(atSymbolIndex + 1);
        int dotIndex = domain.lastIndexOf('.');
        String domainName = domain.substring(0, dotIndex);
        String extension = domain.substring(dotIndex + 1);
        return new String[] { username, domain, domainName, extension };
    }
    public static void analyzeAndDisplay(ArrayList<String> emails) {
        int validCount = 0;
        int invalidCount = 0;
        int totalUsernameLength = 0;
        Map<String, Integer> domainCounts = new HashMap<>();

        System.out.println("\n--- Email Analysis Results ---");
        System.out.printf("%-30s %-15s %-15s %-15s %-10s %s%n", "Email", "Username", "Domain", "Domain Name", "Extension", "Valid/Invalid");

        for (String email : emails) {
            boolean isValid = validateEmail(email);
            if (isValid) {
                validCount++;
            } else {
                invalidCount++;
            }

            String[] components = extractComponents(email);
            if (isValid) {
                totalUsernameLength += components[0].length();
                domainCounts.put(components[1], domainCounts.getOrDefault(components[1], 0) + 1);
            }
            System.out.printf("%-30s %-15s %-15s %-15s %-10s %s%n", email, components[0], components[1], components[2], components[3], isValid ? "Valid" : "Invalid");
        }

        System.out.println("\n--- Email Statistics ---");
        System.out.println("Total Valid Emails: " + validCount);
        System.out.println("Total Invalid Emails: " + invalidCount);
        if (validCount > 0) {
            System.out.printf("Average Username Length: %.2f%n", (double) totalUsernameLength / validCount);
        }
        if (!domainCounts.isEmpty()) {
            String mostCommonDomain = "";
            int maxCount = 0;
            for (Map.Entry<String, Integer> entry : domainCounts.entrySet()) {
                if (entry.getValue() > maxCount) {
                    mostCommonDomain = entry.getKey();
                    maxCount = entry.getValue();
                }
            }
            System.out.println("Most Common Domain: " + mostCommonDomain);
        }
    }
}