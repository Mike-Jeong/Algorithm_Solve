package programmers;

import java.util.*;

//크레인 인형뽑기 게임
//05012022

public class p05012022 {
    public static void main(String[] args) throws Exception {
        Solution05 s = new Solution05();

        int[][] a = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}; 
        int[] b = {1,5,3,5,1,2,1,4};

        System.out.println(s.solution(a,b));
    }
}

class Solution05 {

    public int solution(int[][] board, int[] moves) {

        int answer = 0;
        //ArrayList basket = new ArrayList<Integer>();
        LinkedList basket = new LinkedList<Integer>();

        for (int i : moves) {
            
            loop:
            for (int j = 0; j < board.length; j++) {

                if(board[j][i-1] != 0)
                {
                    basket.add(board[j][i-1]);

                    if (basket.size() > 1 && basket.get(basket.size()-1) == basket.get(basket.size()-2)) {
                        
                        //basket.remove(basket.size()-1);
                        //basket.remove(basket.size()-1);
                        basket.removeLast();
                        basket.removeLast();

                        answer += 2;
                    }

                    board[j][i-1] = 0; 
                    
                    break loop;

                }
            }
        }

        return answer;
    }
}