import java.util.Scanner;

public class Main17249 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] arr = input.split("0");
        System.out.print(arr[0].length() - arr[0].replace("@", "").length());
        System.out.print(" ");
        System.out.println(arr[1].length() - arr[1].replace("@", "").length());
    }
}
