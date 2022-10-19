    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class Main4458 {
        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < N; i++) {
                String str = bf.readLine();
                sb.append(Character.toUpperCase(str.charAt(0)));
                sb.append(str.substring(1, str.length())).append("\n");
            }
            System.out.println(sb.toString());
        }
    }
