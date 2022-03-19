package programmers;

import java.util.*;

//여행경로
//19032022

public class p19032022 {

    public static void main(String[] args) throws Exception {

        Solution84 s = new Solution84();

       // String[][] a = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" }};
       // String[][] a = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } };
       // String[][] a = { { "ICN", "B" }, { "B", "ICN" }, { "ICN", "A" }, { "A", "D" }, { "D", "A" } };
       // String[][] a = { { "ICN", "AAA" }, { "ICN", "AAA" }, { "ICN", "AAA" }, { "AAA", "ICN" }, { "AAA", "ICN" } };
       // String[][] a = { { "ICN", "COO" }, { "ICN", "BOO" }, { "COO", "ICN" }, { "BOO", "DOO" } };
       // String[][] a = { { "ICN", "SFO" }, { "SFO", "ICN" }, { "ICN", "SFO" }, { "SFO", "QRE" } };
        String[][] a = { { "ICN", "BOO" }, { "ICN", "COO" }, { "COO", "DOO" }, { "DOO", "COO" }, { "BOO", "DOO" }, {"DOO", "BOO"} , {"BOO", "ICN"}, {"COO", "BOO"} };

        System.out.println(s.solution(a));

    }
}

class Solution84 {

    Map<String, LinkedList<String>> routes = new HashMap<>();
    ArrayList<String> ans = new ArrayList<>();
    int target;

    public String[] solution(String[][] tickets) {

        for (String[] strings : tickets) {
            if (routes.containsKey(strings[0])) {
                routes.get(strings[0]).add(strings[1]);
            } else {
                LinkedList<String> list = new LinkedList<>();
                list.add(strings[1]);
                routes.put(strings[0], list);
            }
        }

        for (String strings : routes.keySet()) {
            Collections.sort(routes.get(strings));
        }

        target = tickets.length;

        recursion("ICN", 0);

        String[] answer = ans.toArray(new String[ans.size()]);

        return answer;
    }

    public boolean recursion(String destination, int count) {

        ans.add(destination);

        if (!routes.containsKey(destination) || routes.get(destination).size() == 0) {

            if (count == target) {
                return true;
            }

            ans.remove(ans.size()-1);
            return false;
        }

        Queue<String> arrivals = routes.get(destination);

        boolean ck = false;

        int s = arrivals.size();

        for (int i = 0; i < s; i++) {

            String check = arrivals.poll();

            if (recursion(check, count + 1)) {
                ck = true;
                return true;
            }
            arrivals.add(check);
        }

        if (!ck) {
            ans.remove(ans.size()-1);
        }

        return ck;

    }
}
