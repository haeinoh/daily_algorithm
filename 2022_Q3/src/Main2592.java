import java.util.*;

public class Main2592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < 10; i++) {
            int value = sc.nextInt();
            sum += value;
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        System.out.println(sum / 10);
        Map.Entry<Integer, Integer> e = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue))
                        .orElse(null);
        System.out.println(e.getKey());
    }
}
