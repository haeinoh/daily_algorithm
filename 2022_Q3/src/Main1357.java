import java.util.Scanner;

public class Main1357 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder a = new StringBuilder(sc.next());
        StringBuilder b = new StringBuilder(sc.next());
        int sum = Integer.parseInt(String.valueOf(a.reverse())) + Integer.parseInt(String.valueOf(b.reverse()));

        StringBuilder ans = new StringBuilder(String.valueOf(sum)).reverse();
        System.out.println(Integer.parseInt(ans.toString()));
    }
}