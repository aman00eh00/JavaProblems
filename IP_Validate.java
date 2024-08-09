import java.util.Scanner;

class IP_Validate {

    public boolean isValid(String str) {
        // Write your code here
        String[] address = str.split("\\.");

        if (address.length != 4) {
            return false;
        }

        for (int i = 0; i < address.length; i++) {
            if (address[i].length() == 0 || address[i].length() > 3) {
                return false;
            }

            if (address[i].length() > 1 && address[i].charAt(0) == '0') {
                return false;
            }

            int curr = Integer.parseInt(address[i]);

            if (curr < 0 || curr > 255) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IP_Validate ip = new IP_Validate();
        // user input
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