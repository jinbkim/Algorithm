import java.util.Stack;

class Solution
{
    public int solution(String s){
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            stack.add(s.charAt(i));

            while (stack.size() >= 2) {
                char c1 = stack.pop();
                char c2 = stack.pop();

                if (c1 != c2) {
                    stack.add(c2);
                    stack.add(c1);
                    break ;
                }
            }
        }

        if (stack.isEmpty())
            return 1;
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution("baabaa"));
        System.out.println(solution.solution("cdcd"));
    }
}