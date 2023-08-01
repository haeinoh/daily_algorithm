import java.util.Scanner;

public class Main6830 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String city = "";
        int coldest = 987654321;
        while(sc.hasNext()) {
            String name = sc.next();
            if(name.isEmpty()) break;
            int temp = sc.nextInt();
            if(coldest > temp) {
                coldest = temp;
                city = name;
            }
        }
        System.out.println(city);
    }
}
