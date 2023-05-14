import java.util.Scanner;

public class Main10769 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int len = str.length();
        int happy = 0;
        int sad = 0;

        if(str.contains(":-)")) {
            str = str.replaceAll(":-\\)", "");
            happy = (len - str.length())/3;
        }

        len = str.length();
        if(str.contains(":-(")) {
            str = str.replaceAll(":-\\(", "");
            sad = (len - str.length())/3;
        }

        if(happy > sad) System.out.println("happy");
        else if(happy == sad && happy == 0) System.out.println("none");
        else if(happy == sad) System.out.println("unsure");
        else System.out.println("sad");
    }
}
