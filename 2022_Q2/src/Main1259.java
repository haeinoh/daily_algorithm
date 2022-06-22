import java.util.Scanner;

public class Main1259 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            StringBuilder num = new StringBuilder(sc.next());
            if(num.toString().equals("0")) break;
            String rev = new StringBuilder(num).reverse().toString();
            if(num.toString().equals(rev)) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
