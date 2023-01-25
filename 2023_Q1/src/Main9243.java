import java.util.Scanner;

public class Main9243 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        String res = sc.next();

        boolean flag = false;
        if(n % 2 == 0) {
            if(str.equals(res)) flag = true;
        } else {
            flag = true;
          for(int i = 0; i < str.length(); i++) {
              if(str.charAt(i) == res.charAt(i)) {
                  flag = false;
                  break;
              }
          }
        }

        if(flag) System.out.println("Deletion succeeded");
        else System.out.println("Deletion failed");
    }
}
