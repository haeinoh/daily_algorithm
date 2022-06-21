import java.util.*;

public class Main2108 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }

        Arrays.sort(arr);
        int min = arr[0];
        int max = arr[N-1];
        int freq = Collections.max(map.values());

        ArrayList<Integer> list = new ArrayList<>();
        for(Integer key : map.keySet()){
            if(map.get(key) == freq) list.add(key);
        }

        Collections.sort(list);
        System.out.println(Math.round((sum/(double)N)*10/10.0));
        System.out.println(arr[N/2]);
        if(list.size() == 1) System.out.println(list.get(0));
        else System.out.println(list.get(1));
        System.out.println(max-min);
    }
}
