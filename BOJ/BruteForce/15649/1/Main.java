import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static boolean[] visit;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void printSequence(int n, int m, int depth) {
        if (depth == m) {
            for (int value : arr)
                sb.append(value).append(' ');
            sb.append('\n');
            return ;
        }

        for(int i=0; i<n; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                arr[depth] = i+1;
                printSequence(n, m, depth+1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        visit = new boolean[n];
        arr = new int[m];

        printSequence(n, m, 0);
        System.out.print(sb.toString());
    }
}
