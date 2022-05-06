class Solution {

    static int n[];
    static int t;
    static int answer;
    static int size;

    static void dfs(int i, int sum) {
        if (i == size) {
            if (sum == t)
                answer++;
            return ;
        }

        dfs(i+1, sum+n[i]);
        dfs(i+1, sum-n[i]);
    }

    public int solution(int[] numbers, int target) {
        n = numbers;
        t = target;
        answer = 0;
        size = numbers.length;

        dfs(0, 0);

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers1 = {1, 1, 1, 1, 1};
        int[] numbers2 = {4, 1, 2, 1};

        System.out.println(solution.solution(numbers1, 3));
        System.out.println(solution.solution(numbers2, 4));
    }
}