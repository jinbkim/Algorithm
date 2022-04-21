import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int numbers[];
    static int prefixSum[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        numbers = new int[n+1];
        prefixSum = new int[n+1];
        for(int i=1; i<=n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i-1] + numbers[i];
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int sum = prefixSum[destination] - prefixSum[source-1];
            sb.append(sum).append('\n');
        }
        System.out.println(sb.toString());
    }
}
