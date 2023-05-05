import java.util.Scanner;

public class Main15820 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean sample = true;
        boolean secret = true;

        for(int i = 0; i < n; i++) {
            String a = sc.next();
            String b = sc.next();
            if(!a.equals(b)) {
                sample = false;
            }
        }

        for(int j = 0; j < m; j++) {
            String a = sc.next();
            String b = sc.next();
            if(!a.equals(b)) {
                secret = false;
            }
        }

        if(sample && secret) System.out.println("Accepted");
        else if(!sample) System.out.println("Wrong Answer");
        else System.out.println("Why Wrong!!!");
    }
}
