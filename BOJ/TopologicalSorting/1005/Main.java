import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int t, n, k, destination;
    static ArrayList<Integer> buildings;
    static ArrayList<Integer> inDegree;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();
    

    static void topologicalSorting() {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            if (inDegree.get(i) == 0)
                q.add(i);
        }

        int result = 0;
        while(q.isEmpty() == false) {
            int node = q.poll();
            result += node;

            for(int nextNode : graph[node]) {
                inDegree.set(nextNode, inDegree.get(nextNode-1));
                if (inDegree.get(nextNode) == 0)
                    q.add(nextNode);
            }
        }
        sb.append(result).append('\n');
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            buildings = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                buildings.add(Integer.parseInt(st.nextToken()));
            
            graph = new ArrayList[n+1];
            for(int j=1; j<=n; j++)
                graph[j] = new ArrayList<>();

            inDegree = new ArrayList<>();
            for(int j=0; j<=n; j++)
                inDegree.add(0);

            for(int j=0; j<k; k++) {
                st = new StringTokenizer(br.readLine());
                int source = Integer.parseInt(st.nextToken());
                int destination = Integer.parseInt(st.nextToken());

                inDegree.set(destination, inDegree.get(destination)+1);
                graph[source].add(destination);
            }

            destination = Integer.parseInt(br.readLine());
            topologicalSorting();
        }

        System.out.println(sb.toString());
    }
}
