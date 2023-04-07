import java.util.Scanner;

public class Main23027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        if(str.contains("A")) {
            str = str.replaceAll("B", "A");
            str = str.replaceAll("C", "A");
            str = str.replaceAll("D", "A");
            str = str.replaceAll("F", "A");
        } else if(str.contains("B") && !str.contains("A")) {
            str = str.replaceAll("C", "B");
            str = str.replaceAll("D", "B");
            str = str.replaceAll("F", "B");
        } else if(!str.contains("A") && !str.contains("B") && str.contains("C")) {
            str = str.replaceAll("D", "C");
            str = str.replaceAll("F", "C");
        } else {
            int len = str.length();
            str= "";
            for(int i = 0; i < len; i++) str += "A";
        }
        System.out.println(str);
    }
}
