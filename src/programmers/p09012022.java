package programmers;

import java.util.*;

//완주하지 못한 선수
//09012022

public class p09012022 {
    public static void main(String[] args) throws Exception {
        Solution10 s = new Solution10();

        String[] a = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                "Change uid4567 Ryan" };

        System.out.println(s.solution(a));
    }
}

class Solution10 {

    public String[] solution(String[] record) {

        Map<String, String> idnmap = new LinkedHashMap<String, String>();
        ArrayList<String[]> logs = new ArrayList<String[]>();

        for (String string : record) {

            String[] word = string.split(" ");
            String[] log = new String[2];

            switch (word[0]) {
                case "Enter":

                    if (!idnmap.containsKey(word[1])) {

                        idnmap.put(word[1], word[2]);
                    }

                    else {

                        idnmap.put(word[1], word[2]);
                    }

                    log[0] = word[1];
                    log[1] = "들어왔습니다";

                    logs.add(log);

                    break;

                case "Leave":

                    log[0] = word[1];
                    log[1] = "나갔습니다";

                    logs.add(log);

                    break;

                default:

                    idnmap.replace(word[1], word[2]);

                    break;
            }

        }

        String[] answer = new String[logs.size()];

        for (int i = 0; i < answer.length; i++) {

            answer[i] = idnmap.get(logs.get(i)[0]).toString() + " " + logs.get(i)[1].toString(); 
        }

        return answer;
    }
}