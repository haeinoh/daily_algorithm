import java.util.*;

public class Main4636 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int n = sc.nextInt();
            if(n == -1) break;

            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();

                map.put(sc.next(), a*b*c);
            }

            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet()); // 정렬
            Collections.sort(list, new Comparator<>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });

            System.out.println(list.get(0).getKey() + " took clay from " + list.get(list.size()-1).getKey() +".");
        }
    }
}
