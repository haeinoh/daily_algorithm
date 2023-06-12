import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main1713 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++) {
            int num = sc.nextInt();
            if(list.contains(num)) map.put(num, map.get(num) + 1);
            else if(list.size() < n){
                list.add(num);
                map.put(num, 1);
            } else if(list.size() == n) {
                int min = 987654321;
                int idx = 0;
                for(int j = 0; j < list.size(); j++) {
                    if(map.get(list.get(j)) < min) {
                        min = map.get(list.get(j));
                        idx = j;
                    }
                }
                map.remove(list.get(idx));
                map.put(num, 1);
                list.remove(idx);
                list.add(num);
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) sb.append(list.get(i)).append(" ");

        System.out.println(sb.toString());
    }
}
