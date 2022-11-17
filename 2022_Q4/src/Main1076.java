import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main1076 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("black", 0);
        map.put("brown", 1);
        map.put("red", 2);
        map.put("orange", 3);
        map.put("yellow", 4);
        map.put("green", 5);
        map.put("blue", 6);
        map.put("violet", 7);
        map.put("grey", 8);
        map.put("white", 9);

        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i++) arr[i] = (int) (1*(Math.pow(10,i)));

        String a = sc.next();
        String b = sc.next();
        String c = sc.next();

        long value = Long.parseLong(String.valueOf(map.get(a))+String.valueOf(map.get(b)))*arr[map.get(c)];
        System.out.println(value);
    }
}
