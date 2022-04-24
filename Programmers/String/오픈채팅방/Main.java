import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        Map<String,String> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(String cmd : record) {
            String[] cmdLine = cmd.split(" ");

            if (cmdLine[0].equals("Enter")) {
                map.put(cmdLine[1], cmdLine[2]);
                list.add(cmdLine[1]+"님이 들어왔습니다.");
            }
            else if (cmdLine[0].equals("Leave")) {
                list.add(cmdLine[1]+"님이 나갔습니다.");
            }
            else if (cmdLine[0].equals("Change")) {
                map.put(cmdLine[1], cmdLine[2]);
            }
        }

        String answer[] = new String[list.size()];
        for(int i=0; i<list.size(); i++) {
            String output = list.get(i);
            String id = output.substring(0, output.indexOf("님"));
            answer[i] = output.replace(id, map.get(id));
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String record[] = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String result[] = solution.solution(record);
        for(String str : result)
            System.out.println(str);
    }
}
