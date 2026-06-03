
import java.util.Scanner;

public class panagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNext()) {
            System.out.println("No, some characters are missing.");
            return;
        }
        String str = scanner.next();
        
        int lower_flag = 0;
        int upper_flag = 0;
        int digit_flag = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch >= 'a' && ch <= 'z') {
                lower_flag = lower_flag | (1 << (ch - 'a'));
            }
            
            if (ch >= 'A' && ch <= 'Z') {
                upper_flag = upper_flag | (1 << (ch - 'A'));
            }

            if (ch >= '0' && ch <= '9') {
                digit_flag = digit_flag | (1 << (ch - '0'));
            }
        }

        int target_Alpha = (1 << 26) - 1;
        int target_digit = (1 << 10) - 1;

        if (target_Alpha == lower_flag && 
            target_Alpha == upper_flag && 
            target_digit == digit_flag) {
            System.out.println("Yes, a-z, A-Z, and 0-9 are all present.");
        } else {
            System.out.println("No, some characters are missing.");
        }
        
        scanner.close();
    }
}
