import java.util.Scanner;

public class Main {

    static int maxValue = -1000000000;
    static int minValue = 1000000000;

    static int n;
    static int nums[];
    static int operator[];

    static int[] totalOperator = new int[4];
    static int[] operatorUsed = new int[4];

    static int calculate() {
        int result = nums[0];

        for(int i=1; i<n; i++) {
            if (operator[i-1] == 0)
                result += nums[i];
            else if (operator[i-1] == 1)
                result -= nums[i];
            else if (operator[i-1] == 2)
                result *= nums[i];
            else if (operator[i-1] == 3)
                result /= nums[i];
        }
        return result ;
    }

    static void dfs(int index) {
        if (index == n-1) {
            int result = calculate();
            if (result > maxValue)
                maxValue = result;
            if (result < minValue)
                minValue = result;
            return ;
        }

        for(int i=0; i<4; i++) {
            if (operatorUsed[i] < totalOperator[i]) {
                operatorUsed[i]++;
                operator[index] = i;
                dfs(index+1);
                operatorUsed[i]--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];
        operator = new int[n-1];
        for(int i=0; i<n; i++)
            nums[i] = sc.nextInt();
        totalOperator[0] = sc.nextInt();
        totalOperator[1] = sc.nextInt();
        totalOperator[2] = sc.nextInt();
        totalOperator[3] = sc.nextInt();

        dfs(0);

        System.out.println(maxValue);
        System.out.println(minValue);
    }
}
