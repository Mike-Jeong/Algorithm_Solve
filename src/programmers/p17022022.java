package programmers;

import java.util.*;

//메뉴 리뉴얼
//17022022

public class p17022022 {
    public static void main(String[] args) throws Exception {
        Solution50 s = new Solution50();

        String[] a = { "XYZ", "XWY", "WXA" };
        int[] b = { 2, 3, 4 };

        System.out.println(s.solution(a, b));
    }
}

class Solution50 {

    Map<String, Integer> combi_count = new LinkedHashMap<>();
    String current_string;
    Map<Integer, Integer> max = new LinkedHashMap<>();

    public String[] solution(String[] orders, int[] course) {

        ArrayList<String> ans = new ArrayList<>();

        for (int num : course) {

            max.put(num, 2);
            for (String order : orders) {
                current_string = order;
                for (int i = 0; i < current_string.length() - 1; i++) {
                    findCombi(current_string.substring(i, i + 1), i, num);
                }
            }
        }

        for (String m : combi_count.keySet()) {
            if (max.get(m.length()) == combi_count.get(m)) {
                ans.add(m);
            }
        }

        Collections.sort(ans);

        String[] answer = ans.toArray(new String[ans.size()]);
        return answer;
    }

    public void findCombi(String combi, int index, int n_combi) {

        if (combi.length() == n_combi) {

            char[] charArr = combi.toCharArray();
            Arrays.sort(charArr);
            String str = new String(charArr);
            if (combi_count.containsKey(str)) {
                combi_count.replace(str, combi_count.get(str), combi_count.get(str) + 1);
                max.replace(n_combi, max.get(n_combi), Math.max(max.get(n_combi), combi_count.get(str)));
                return;
            }
            combi_count.put(str, 1);
            return;
        }

        StringBuilder sb = new StringBuilder(combi);

        for (int i = index + 1; i < current_string.length(); i++) {
            sb.append(current_string.charAt(i));
            findCombi(sb.toString(), i, n_combi);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}