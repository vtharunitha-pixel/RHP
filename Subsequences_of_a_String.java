import java.util.Scanner;

public class Main {
    public static void solve() {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) return;
        
        String s = scanner.next();
        int L = s.length();
        
        for (int ctr = 1; ctr < (1 << L); ctr++) {
            StringBuilder combi = new StringBuilder();
            for (int sh = 0; sh < L; sh++) {
                if ((ctr & (1 << sh)) > 0) {
                    combi.append(s.charAt(sh));
                }
            }
            System.out.println(combi.toString());
        }
        scanner.close();
    }

    public static void main(String[] args) {
        solve();
    }
}
