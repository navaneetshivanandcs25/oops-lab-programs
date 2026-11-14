


import java.util.Scanner;

class EmailOperations {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Accept email address
        System.out.print("Enter student email address: ");
        String email = sc.nextLine();

        // 1. Find length
        System.out.println("Length of email: " + email.length());

        // 2. Extract username
        int pos = email.indexOf('@');
        String username = email.substring(0, pos);
        System.out.println("Username: " + username);

        // 3. Extract and compare domain
        String domain = email.substring(pos + 1);
        System.out.println("Domain: " + domain);

        if (domain.equals("bmsce.ac.in")) {
            System.out.println("Email belongs to BMSCE.");
        } else {
            System.out.println("Email does not belong to BMSCE.");
        }

        // 4. Convert email to lowercase
        String lower = email.toLowerCase();
        System.out.println("Lowercase email: " + lower);

        // 5. Check starting prefix
        System.out.print("Enter prefix to check: ");
        String prefix = sc.nextLine();

        if (email.startsWith(prefix)) {
            System.out.println("Email starts with the given prefix.");
        } else {
            System.out.println("Email does not start with the given prefix.");
        }

        // 6. Check ending domain
        if (email.endsWith("bmsce.ac.in")) {
            System.out.println("Email ends with valid domain.");
        } else {
            System.out.println("Email does not end with valid domain.");
        }

        // 7. Replace domain
        String updated = email.replace("bmsce.ac.in", "cse.bmsce.ac.in");
        System.out.println("Updated email: " + updated);

        // 8. Check character or sequence
        System.out.print("Enter sequence to search: ");
        String sequence = sc.nextLine();

        if (email.contains(sequence)) {
            System.out.println("Email contains the given sequence.");
        } else {
            System.out.println("Email does not contain the given sequence.");
        }

        // 9. Remove leading and trailing spaces
        String trimmed = email.trim();
        System.out.println("Trimmed email: " + trimmed);

        // 10. Compare two email addresses
        System.out.print("Enter another email address: ");
        String email2 = sc.nextLine();

        if (email.equalsIgnoreCase(email2)) {
            System.out.println("Both email addresses are identical.");
        } else {
            System.out.println("Both email addresses are different.");
        }

        sc.close();
    }
}

