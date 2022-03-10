package programmers;

//import java.util.*;

//서울에서 김서방 찾기
//12022022

public class p12022022 {
    public static void main(String[] args) throws Exception {
        Solution44 s = new Solution44();

        String[] a = {"Jane", "Kim"};

        System.out.println(s.solution(a));
    }
}

class Solution44 {

    public String solution(String[] seoul) {

        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                return String.format("김서방은 " + i + "에 있다");
            }
        }
        return "";
    }
}