import java.util.Scanner;

public class Main {

    public static boolean[] visit;
    public static int[] arr;

    public static void printSequence(int n, int m, int depth) {
        if (depth == m) {
            for (int value : arr)
                System.out.print(value + " ");
            System.out.println();
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        visit = new boolean[n];
        arr = new int[m];

        printSequence(n, m, 0);
    }
}
