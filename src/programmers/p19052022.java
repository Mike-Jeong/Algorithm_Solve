package programmers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//?
//19052022

public class p19052022 {

    public static void main(String[] args) throws Exception {

        Solution110 s = new Solution110();

        int[] a = { 7, 10, 4, 5 };
        int[] b = { 5, 4, 3, 1 };
        int[] c = { 4, 6, 2, 8 };

        System.out.println(s.solution(a, b, c));

    }
}

class Solution110 {

    public int solution(int[] amount, int[] value, int[] stomach) {
        List<Meat> meats = IntStream.range(0, amount.length)
                .boxed()
                .map(i -> new Meat(value[i], amount[i]))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int bestMeatConsumption =
                Math.min(meats.get(0).amount / stomach.length,
                        Arrays.stream(stomach).min().getAsInt()) * stomach.length;
        int totalStomach = Arrays.stream(stomach).sum() - bestMeatConsumption;
        int result = bestMeatConsumption * meats.get(0).value;

        for (int i = 1; i < meats.size(); i++) {
            int v = meats.get(i).value;
            int a = meats.get(i).amount;
            int consumption = Math.min(totalStomach, a);
            result += v * consumption;
            totalStomach -= consumption;
            if (totalStomach == 0) {
                break;
            }
        }

        return result;
    }
}

class Meat implements Comparable<Meat> {
    int value;
    int amount;

    public Meat(int value, int amount) {
        this.value = value;
        this.amount = amount;
    }

    @Override
    public int compareTo(Meat o) {
        return this.value - o.value;
    }
}

/*
 * public class p19052022 {
 * 
 * public static void main(String[] args) throws Exception {
 * 
 * Solution110 s = new Solution110();
 * 
 * int[] a = {7, 10, 4, 5};
 * int[] b = {5, 4, 3, 1};
 * int[] c = {4, 6, 2, 8};
 * 
 * System.out.println(s.solution(a, b, c));
 * 
 * }
 * }
 * 
 * class Solution110 {
 * 
 * public int solution(int[] amount, int[] value, int[] stomach) {
 * int answer = 0;
 * return answer;
 * }
 * }
 */