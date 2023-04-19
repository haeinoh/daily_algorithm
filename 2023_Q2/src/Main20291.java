import java.util.*;

public class Main20291 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String[] tmp = sc.next().split("\\.");
            map.put(tmp[1], map.getOrDefault(tmp[1],0)+1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for(String key: list) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
