package programmers;

import java.util.*;

//여행경로
//19032022

public class p19032022 {

    public static void main(String[] args) throws Exception {

        Solution84 s = new Solution84();

        String[][] a = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } };

        System.out.println(s.solution(a));

    }
}

class Solution84 {

    Map<String, PriorityQueue<String>> routes = new HashMap<>();
    ArrayList<String> ans = new ArrayList<>();
    int target;

    public String[] solution(String[][] tickets) {

        for (String[] strings : tickets) {
            if (routes.containsKey(strings[0])) {
                routes.get(strings[0]).add(strings[1]);
            } else {
                PriorityQueue<String> priorityQueue = new PriorityQueue<>();
                priorityQueue.add(strings[1]);
                routes.put(strings[0], priorityQueue);
            }
        }

        target = tickets.length + 1;

        recursion("ICN", 0);

        String[] answer = ans.toArray(new String[ans.size()]);
        return answer;
    }

    public boolean recursion(String destination, int count) {

        ans.add(destination);
        System.out.println(destination);

        if (!routes.containsKey(destination) || routes.get(destination).size() == 0) {
            if (count == target) {
                return true;
            }
            return false;
        }

        PriorityQueue<String> arrivals = routes.get(destination);

        String[] arrivals_c = arrivals.toArray(new String[arrivals.size()]);

        boolean ck = false;

        for (String string : arrivals_c) {
            arrivals.remove(string);

            ck = recursion(string, count + 1);
            
            if (ck) {
                break;
            }
            
            arrivals.add(string);
        }

        ans.remove(destination);

        return ck;

    }
}