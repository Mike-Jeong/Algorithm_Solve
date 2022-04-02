package programmers;

//import java.util.*;

//2개 이하로 다른 비트
//02042022

public class p02042022 {

    public static void main(String[] args) throws Exception {

        Solution97 s = new Solution97();

        long[] a = { 2, 7 };

        System.out.println(s.solution(a));

    }
}

class Solution97 {

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;

            } else {
                StringBuilder temp = new StringBuilder();
                String binaryString = Long.toBinaryString(numbers[i]);
                if (!binaryString.contains("0")) {
                    temp.append("10");
                    temp.append(binaryString.substring(1).replace("0", "1"));

                } else {
                    int lastIndex = binaryString.lastIndexOf("0");
                    int firstOneIndex = binaryString.indexOf("1", lastIndex);

                    temp.append(binaryString, 0, lastIndex).append("1");

                    temp.append("0");

                    temp.append(binaryString.substring(firstOneIndex + 1));
                }
                answer[i] = Long.parseLong(temp.toString(), 2);
            }
        }
        return answer;
    }
}