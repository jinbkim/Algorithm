import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int path[][];
    static int INF = 987654321;

    static void floydWarshall() {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                for(int k=1; k<=n; k++) {
                    if (path[j][i] + path[i][k] < path[j][k])
                        path[j][k] = path[j][i] + path[i][k];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;

        path = new int[n+1][n+1];
        for(int i=1; i<=n; i++) 
            Arrays.fill(path[i], INF);

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (weight < path[source][destination])
                path[source][destination] = weight;
        }

        floydWarshall();
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if (path[i][j] == INF || i==j)
                    sb.append("0 ");
                else
                    sb.append(path[i][j] + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
