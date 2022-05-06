class Solution {    
    public String solution(int n) {
        char words[] = {'4', '1', '2'};

        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            int reminder = n%3;

            if (reminder == 0)
                n--;
            sb.insert(0, words[reminder]);
            n/=3;
        }

        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for(int i=1; i<=20; i++)
            System.out.println(solution.solution(i));
    }
}