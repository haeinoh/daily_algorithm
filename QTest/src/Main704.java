public class Main704 {
    //피보나치수열
    public static int DFS(int n) { // n번째 항
        if(n == 1) return 1;
        else if(n == 2) return 1;
        else return DFS(n-1) + DFS(n-2);
    }

    public static void main(String[] args) {
        System.out.println(DFS(10));
    }
}
