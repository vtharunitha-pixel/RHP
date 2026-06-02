import java.util.Scanner;

public class Main {
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
         lower_flag = lower_flag | (1 << (ch - 'a'));
            
            
        }

        int target = (1 << 26) - 1;
        

        if (target == lower_flag ) {
            System.out.println("Yes, a-z  all present.");
        } else {
            System.out.println("No, some characters are missing.");
        }
        
        scanner.close();
    }
}
