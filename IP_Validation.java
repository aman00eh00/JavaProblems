import java.util.Scanner;

class IP_Validation {

    public boolean isValid(String str) {
        // Split the string by "."
        String[] address = str.split("\\.");

        // Check if there are exactly 4 parts
        if (address.length != 4) {
            return false;
        }

        // Validate each part of the IP address
        for (String part : address) {
            // Check if the part is empty or longer than 3 characters
            if (part.length() == 0 || part.length() > 3) {
                return false;
            }

            // Check for leading zeros
            if (part.length() > 1 && part.charAt(0) == '0') {
                return false;
            }

            try {
                // Convert part to an integer and check range
                int curr = Integer.parseInt(part);
                if (curr < 0 || curr > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                // If part is not a number, it's an invalid IP address
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IP_Validate ip = new IP_Validate();
        // User input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter IP address: ");
        String IP = sc.nextLine();

        if (ip.isValid(IP)) {
            System.out.println("Valid IP address");
        } else {
            System.out.println("Invalid IP address");
        }

        sc.close();
    }
}
