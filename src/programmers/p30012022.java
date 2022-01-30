package programmers;

import java.util.*;

//다트 게임
//30012022

public class p30012022 {
    public static void main(String[] args) throws Exception {
        Solution31 s = new Solution31();
        String a = "10D4S10D"; 
        System.out.println(s.solution(a));

    }
}

class Solution31 {

    public int solution(String dartResult) {
        int answer = 0;
        List<Integer> digitlist = new LinkedList<>();

        for (int i = 0; i < dartResult.length(); i++) {
            if (Character.isDigit(dartResult.charAt(i))) {

                if (Character.isDigit(dartResult.charAt(i + 1))) {
                    digitlist.add(Integer.parseInt(dartResult.substring(i, i + 2)));
                    i++;
                    continue;
                }

                digitlist.add(Character.getNumericValue(dartResult.charAt(i)));
            }

            else {
                switch (dartResult.charAt(i)) {

                    case 'S':
                        digitlist.set(digitlist.size() - 1, (int) Math.pow(digitlist.get(digitlist.size() - 1), 1));

                        break;

                    case 'D':
                    digitlist.set(digitlist.size() - 1, (int) Math.pow(digitlist.get(digitlist.size() - 1), 2));

                        break;

                    case 'T':
                    digitlist.set(digitlist.size() - 1, (int) Math.pow(digitlist.get(digitlist.size() - 1), 3));

                        break;

                    case '*':

                    digitlist.set(digitlist.size() - 1, digitlist.get(digitlist.size() - 1) * 2);

                    if (digitlist.size()>1) {
                        digitlist.set(digitlist.size() - 2, digitlist.get(digitlist.size() - 2) * 2);
                    }
                    
                        break;

                    case '#':

                    digitlist.set(digitlist.size() - 1, digitlist.get(digitlist.size() -1 ) * - 1);

                        break;

                    default:
                        break;
                }
            }
        }
        
        for (Integer integer : digitlist) {
            answer += integer;
        }

        return answer;
    }
}