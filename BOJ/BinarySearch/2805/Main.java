import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int heightMax = 0;
    static int[] trees;
    static int n, m;

    static boolean isPossible(int h) {
        int sum = 0;

        for(int i=0; i<n; i++) {
            if (trees[i]-h > 0)
                sum += (trees[i]-h);
        }
        // System.out.println("h : " + h + ", sum : " + sum);
        if (sum >= m)
            return true;
        return false;
    }

    static void binarySearch(int start, int end) {
        int mid = (start+end)/2;

        if (end < start)
            return ;

        if (isPossible(mid) == true) {
            if (heightMax < mid)
                heightMax = mid;
            binarySearch(mid+1, end);
        }
        else
            binarySearch(start, mid-1);

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        trees = new int[n];
        for(int i=0; i<n; i++)
            trees[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(trees);

        binarySearch(0, trees[n-1]);
        System.out.println(heightMax);
    }
}
