package programmers;

//import java.util.*;

//소수 만들기
//07012022

public class p07012022 {
    public static void main(String[] args) throws Exception {
        Solution09 s = new Solution09();

        int[] a = {1,2,7,6,4};

        System.out.println(s.solution(a));
    }
}

class Solution09 {

    public int solution(int[] nums) {
        /*int answer = 0;
        int prime = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i+1; j < nums.length; j++) {

                for (int k = j+1; k < nums.length; k++) {

                    prime = nums[i] + nums[j] + nums[k];
                    
                    int check = 0;

                    for (int l = 2; l < prime; l++) {
                        
                        if (prime %l == 0) {
                            
                            check++;
                        }

                    }

                    if (check == 0) {
                        answer++;
                    }
                    
                }
            }
        }

        return answer; }}*/
        //1차 답안

            int answer = 0;
            int prime = 0;
    
            for (int i = 0; i < nums.length; i++) {
    
                for (int j = i+1; j < nums.length; j++) {
    
                   loop:
                    for (int k = j+1; k < nums.length; k++) {
    
                        prime = nums[i] + nums[j] + nums[k];
                        
                        for (int l = 2; l < prime; l++) {
                            
                            if (prime % l == 0) {
                                
                                continue loop;
                            }  
                        }

                        answer++;  
                       
                    }
                }
            }
            
            return answer;
        }
        //수정본
    }
