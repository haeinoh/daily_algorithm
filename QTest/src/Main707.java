import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node lt, rt;
    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}
public class Main707 {
    Node root;
    public static void BFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int L = 0; // root node level

        while(!q.isEmpty()) {
            int len = q.size();
            System.out.print(L + " : ");
            for(int i = 0 ;i < len; i++) {
                Node cur = q.poll();
                System.out.println(cur.data);
                if(cur.lt != null) q.offer(cur.lt);
                if(cur.rt != null) q.offer(cur.rt);
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Main707 tree = new Main707();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}
