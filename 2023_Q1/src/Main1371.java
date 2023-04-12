import java.util.*;

public class Main1371 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        HashMap<Character, Integer> map = new HashMap<>();

        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(ch >= 'a' && ch <= 'z') map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }


        int findMax = Collections.max(map.values());
        ArrayList<Character> list = new ArrayList<>();
        for(Map.Entry<Character, Integer> m: map.entrySet()) {
                if(m.getValue() == findMax) {
                    list.add(m.getKey());
                }
        }

        Collections.sort(list);

        StringBuilder answer = new StringBuilder();
        for (Character character : list) answer.append(character);
        System.out.println(answer);
    }
}
