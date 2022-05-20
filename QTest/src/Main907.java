import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Edge2 implements Comparable<Edge2>{
    public int v1;
    public int v2;
    public int cost;
    Edge2(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge2 ob){ // 비용 정렬 오름차순
        return this.cost-ob.cost;
    }
}
public class Main907 {
    static int[] unf;
    public static int find(int v){
        if(v==unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }
    public static void Union(int x, int y){
        int fa = find(x);
        int fb = find(y);
        if(fa != fb) unf[fa] = fb;
    }
    public void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            unf=new int[n+1];
            ArrayList<Edge2> arr=new ArrayList<>();
            for(int i = 1; i <= n; i++) unf[i]=i;

            for(int i=0; i<m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                arr.add(new Edge2(a, b, c));
            }
            int answer=0;
            Collections.sort(arr);
            for(Edge2 ob : arr){
                int fv1 = find(ob.v1);
                int fv2 = find(ob.v2);
                // 같은 집합일 떼 선택하면 회로가 되서 연결하면 안됨
                if(fv1 != fv2){
                    answer += ob.cost;
                    Union(ob.v1, ob.v2);
                }
            }
            System.out.println(answer);
        }
}
