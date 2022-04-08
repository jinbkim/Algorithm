import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static boolean isBigger(int weight1, int height1, int weight2, int height2) {
        if (weight1 > weight2 && height1 > height2)
            return true;
        return false;
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int weight[] = new int[n];
        int height[] = new int[n];
        for(int i=0; i<n; i++) {
            String[] buffer = br.readLine().split(" ");
            weight[i] = Integer.parseInt(buffer[0]);
            height[i] = Integer.parseInt(buffer[1]);
        }

        int rank[] = new int[n];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            rank[i] = 1;
            for(int j=0; j<n; j++) {
                if (isBigger(weight[j], height[j], weight[i], height[i]) == true)
                    rank[i]++;
            }
            sb.append(rank[i] + " ");
        }
        System.out.print(sb.toString());
    }    
}
