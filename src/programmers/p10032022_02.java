package programmers;

//import java.util.*;

//기둥코딩 질문 답변
//10032022

public class p10032022_02 {
    public static void main(String[] args) throws Exception {

        Solution72 s = new Solution72();

       // String a = "Week 1_Course Explanation/it's fun/it's awesome_Hello World_Types of Programming Languages|Week 2_Console output_Variables_Primitive Types|Week 3_Casting_Operator_String_Console input";
        String a = "Apple////|Orange/asdf";

        System.out.println(s.solution(a));
    }
}

class Solution72 {

    public String solution(String s) {

        StringBuilder sb = new StringBuilder();

        String[] list1 = s.split("\\|");

        for (int i = 0; i < list1.length; i++) {

            String[] list2 = list1[i].split("\\_");

            sb.append(i + 1);
            sb.append(") ");
            sb.append(list2[0]);
            sb.append("\n");

            for (int j = 1; j < list2.length; j++) {

                String[] list3 = list2[j].split("\\/");

                sb.append("    ");
                char alpha = (char)(j + 96);
                int iter = (j - 1) / 26;
                for (int k = 0; k < iter + 1; k++) {       
                    sb.append(alpha);
                }
                sb.append(") ");
                sb.append(list3[0]);
                sb.append("\n");

                for (int k = 1; k < list3.length; k++) {
                    sb.append("        - ");
                    sb.append(list3[k]);
                    sb.append("\n");
                }
            }
        }

        return sb.toString();
    }
}
