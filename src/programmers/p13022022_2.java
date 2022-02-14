package programmers;

import java.util.*;

//전화번호 목록
//13022022

public class p13022022_2 {
    public static void main(String[] args) throws Exception {
        Solution46 s = new Solution46();

        String[] a = {"119", "97674223", "1195524421"};

        System.out.println(s.solution(a));
    }
}

class Solution46 {

    public boolean solution(String[] phone_book) {
        
        Set<String> set = new HashSet<>();
        for (String string : phone_book) {
            set.add(string);
        }
        
        for (String string : set) {
            for (int i = 1; i < string.length(); i++) {
                if (set.contains(string.substring(0,i))) {
                    return false;
                }
            }
        }

        return true;
    }
}