package programmers;

import java.util.*;

//구명보트
//08032022

public class p08032022 {
    public static void main(String[] args) throws Exception {

        Solution69 s = new Solution69();

        int[] a = { 70, 50, 80, 50 };
        int b = 100;

        System.out.println(s.solution(a, b));
    }
}

class Solution69 {

    public int solution(int[] people, int limit) {

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        int answer = 0;

        for (int i = 0; i < people.length; i++) {
            if (people[i] + 40 > limit) {
                answer++;
            } else {
                if (map.containsKey(people[i])) {
                    map.replace(people[i], map.get(people[i]), map.get(people[i]) + 1);
                } else {
                    map.put(people[i], 1);
                }
            }
        }

        while (!map.isEmpty()) {

            if (map.firstKey() + map.lastKey() <= limit) {
                map.replace(map.firstKey(), map.get(map.firstKey()), map.get(map.firstKey()) - 1);

                if (map.get(map.firstKey()) == 0) {
                    map.remove(map.firstKey());
                }

                if (!map.isEmpty()) {
                    map.replace(map.lastKey(), map.get(map.lastKey()), map.get(map.lastKey()) - 1);

                    if (map.get(map.lastKey()) == 0) {
                        map.remove(map.lastKey());
                    }
                }

                answer++;

            } else {
                map.replace(map.lastKey(), map.get(map.lastKey()), map.get(map.lastKey()) - 1);

                if (map.get(map.lastKey()) == 0) {
                    map.remove(map.lastKey());
                }

                answer++;
            }
        }

        return answer;
    }
}
