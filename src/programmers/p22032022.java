package programmers;

//import java.util.*;

//스킬트리
//22032022

public class p22032022 {

    public static void main(String[] args) throws Exception {

        Solution87 s = new Solution87();

        String a = "CBD";
        String[] b = { "BACDE", "CBADF", "AECB", "BDA" };

        System.out.println(s.solution(a, b));

    }
}

class Solution87 {

    public int solution(String skill, String[] skill_trees) {

        int answer = 0;

        for (String string : skill_trees) {
            if (check(skill, string)) {
                answer++;
            }
        }
        
        return answer;
    }

    public boolean check(String skill, String skill_tree) {

        for (int i = 1; i < skill.length(); i++) {
            if (skill_tree.contains(String.valueOf(skill.charAt(i)))) {

                String ck = skill_tree.substring(0, skill_tree.indexOf(String.valueOf(skill.charAt(i))));
                
                if (!ck.contains(String.valueOf(skill.charAt(i - 1)))) {
                    return false;
                }
            }
        }

        return true;
    }
}