package programmers;

import java.util.*;
import java.util.stream.Collectors;

//신고 결과 받기
//15012022

public class p15012022 {
    public static void main(String[] args) throws Exception {
        Solution17 s = new Solution17();

        String[] a = {"con", "ryan"};
        String[] b = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int c = 2;

        for (int d : s.solution(a, b,c)) {
            System.out.println(d);
        }
        
    }
}

class Solution17 {

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String,Integer> report_count = new LinkedHashMap<>();
        Map<String,Integer> mail_count = new LinkedHashMap<>();
        Map<String,Set<String>> reportlist = new HashMap<>();


        for (String string : id_list) {
            Set<String> report_member = new HashSet<>();
            report_count.put(string, 0);
            mail_count.put(string, 0);
            reportlist.put(string, report_member);

        }

        for (String string : report) {
            String[] word = string.split(" ");
            reportlist.get(word[1]).add(word[0]);
        }

        for (String string : id_list) {

            if (reportlist.get(string).size() >= k) {
                for (String string2 : reportlist.get(string)) {
                    mail_count.put(string2, mail_count.get(string2) + 1);
                }
            }
        }

        int[] answer = new int [mail_count.size()];
        int i = 0;
        for (String string3 : mail_count.keySet()) {;
            answer[i] = mail_count.get(string3);
            i++;
        }
        return answer;
    }
}