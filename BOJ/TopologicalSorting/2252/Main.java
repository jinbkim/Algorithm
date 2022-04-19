import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int inDegree[];
    static ArrayList<Integer>[] graph;

    static void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while(q.isEmpty() == false) {
            int node = q.poll();
            sb.append(node).append(' ');

            for(int nextNode : graph[node]) {
                if (--inDegree[nextNode] == 0)
                    q.add(nextNode);
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++)
            graph[i] = new ArrayList<>();

        inDegree = new int[n+1];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());

            inDegree[destination]++;
            graph[source].add(destination);
        }

        topologicalSort();
    }
}
