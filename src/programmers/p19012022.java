package programmers;

import java.util.*;

//문자열 압축
//19012022

public class p19012022 {
    public static void main(String[] args) throws Exception {
        Solution22 s = new Solution22();

        String a = "ababcdcdababcdcd";

        System.out.println(s.solution(a));

    }
}

class Solution22 {

    public int solution(String s) {

        for (int i = 1; i <= (s.length() / 2) + 1; i++) {
            StringBuilder newString = new StringBuilder("");
            Map<String, Integer> a = new LinkedHashMap<>();
            
            int j = 0;

            while(true)
            {
                if (j + i + i> s.length()) {
                    break;
                }

                if (s.substring(j, j+i).equals(s.substring(j+i, j+i+i))){
                    if (a.containsKey(s.substring(j, j+i))) {
                        a.replace(s.substring(j, j+i), a.get(s.substring(j, j+i)) + i);
                    }
                    else{a.put(s.substring(j, j+i), 2);} 
                }

                else{
                    
                    for (String key : a.keySet()) {
                        newString.append(a.get(key));
                        newString.append(key);
                        a.remove(key);
                    }

                    newString.append(s.substring(j, j+i));
                    
                }

                j += i; 
            }
            System.out.println(newString);
        }

        return 0;
    }
}


/*public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i < s.length() / 2 + 1; i++) {
            String prev = s.substring(0, i);
            int count = 1;
            String enc = "";
            String last = "";
            for (int j = i; j < s.length(); j += i) {
                if (j + i > s.length()) {
                    last = s.substring(j);
                    continue;
                }
                if (prev.equals(s.substring(j, j + i))) {
                    count++;
                } else {
                    enc += prev;
                    if (count != 1) {
                        enc = count + enc;
                    }
                    prev = s.substring(j, j + i);
                    count = 1;
                }
            }
            enc += prev + last;
            if (count != 1) {
                enc = count + enc;
            } 
            
            answer = Math.min(answer, enc.length());
        }

        return answer;
    }
}*/