import java.util.*;

public class Main11292 {
    public static class Node {
        String name;
        double height;

        public Node(String name, double height) {
            this.name = name;
            this.height = height;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        while(true) {
            int n = sc.nextInt();
            if(n == 0) break;
            ArrayList<Node> list = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                String str = sc.next();
                double val = sc.nextDouble();
                list.add(new Node(str, val));
            }

            Collections.sort(list, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return Double.compare(o2.height , o1.height);
                }
            });

            double max = list.get(0).height;


            for(int i = 0; i < n; i++) {
                if(list.get(i).height != max) break;
                sb.append(list.get(i).name).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
