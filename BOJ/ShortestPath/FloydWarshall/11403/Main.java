import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int path[][];
    static int INF = 987654321;

    static void floydWarshall() {
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                for(int k=0; k<n; k++)
                    if (path[j][i] + path[i][k] < path[j][k])
                        path[j][k] = path[j][i] + path[i][k];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        path = new int[n][n];
        StringTokenizer st;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                if (Integer.parseInt(st.nextToken()) == 0)
                    path[i][j] = INF;
                else
                    path[i][j] = 1;
            }
        }

        floydWarshall();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (path[i][j] == INF)
                    sb.append("0 ");
                else
                    sb.append("1 ");
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
