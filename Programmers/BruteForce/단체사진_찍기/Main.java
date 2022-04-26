import java.util.HashMap;
import java.util.Map;

class Condition {
    char person1;
    char person2;
    char operator;
    char num;

    Condition(char person1, char person2, char operator, char num) {
        this.person1 = person1;
        this.person2 = person2;
        this.operator = operator;
        this.num = num;
    }
}

class Solution {
    static Map<Character, Integer> map = new HashMap<>();
    static Condition[] conditions;
    static int answer, conditionNum;
    static boolean[] visit;
    static char[] people = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

    static boolean checkCondition() {
        for(int i=0; i<conditionNum; i++) {
            char operator = conditions[i].operator;
            int locationDiff = Math.abs(map.get(conditions[i].person1)-map.get(conditions[i].person2));
            int conditionDiff = conditions[i].num - '0' + 1;

            if (operator == '=' && locationDiff != conditionDiff)
                return false;
            else if (operator == '<' && locationDiff >= conditionDiff)
                return false;
            else if (operator == '>' && locationDiff <= conditionDiff)
                return false;
        }

        return true;
    }

    static void dfs(int i) {
        if (i == 8) {
            if (checkCondition())
                answer++;
            return ;
        }

        for(int j=0; j<8; j++) {
            if (visit[j] == false) {
                visit[j] = true;
                map.put(people[j], i);
                dfs(i+1);
                visit[j] = false;
            }
        }
    }

    static void parseCondition(String[] data) {
        conditions = new Condition[conditionNum];
        for(int i=0; i<conditionNum; i++)
            conditions[i] = new Condition(data[i].charAt(0), data[i].charAt(2), data[i].charAt(3), data[i].charAt(4));
    }

    public int solution(int n, String[] data) {
        answer = 0;
        conditionNum = n;
        parseCondition(data);

        visit = new boolean[8];
        dfs(0);

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(2, new String[]{"N~F=0", "R~T>2"}));
        System.out.println(solution.solution(2, new String[]{"M~C<2", "C~M>1"}));
    }
}
