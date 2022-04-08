import java.util.Scanner;

public class Main {
    
    public static boolean isBigger(int weight1, int height1, int weight2, int height2) {
        if (weight1 > weight2 && height1 > height2)
            return true;
        return false;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int weight[] = new int[n];
        int height[] = new int[n]; 
        for(int i=0; i<n; i++) {
            weight[i] = sc.nextInt();
            height[i] = sc.nextInt();
        }

        int rank[] = new int[n];
        for(int i=0; i<n; i++) {
            rank[i] = 1;
            for(int j=0; j<n; j++) {
                if (isBigger(weight[j], height[j], weight[i], height[i]) == true)
                    rank[i]++;
            }
            System.out.print(rank[i] + " ");
        }
    }    
}
