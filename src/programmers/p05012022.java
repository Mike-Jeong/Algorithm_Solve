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
        ArrayList<Integer> basket = new ArrayList<Integer>();
        //LinkedList basket = new LinkedList<Integer>();

        // 두 방법을 실행했을때, ArrayList를 사용한 방법이 조금 더 빠른 실행시간을 보였다.
        // 그 이유 :
        // ArrayList 는 인덱스 조회를 할때, LinkedList 보다 빠른 실행속도를 보여준다.
        // 그 이유는 리스트 생성시, ArrayList는 배열처럼 값을 특정 장소(공간 = index 번호를 이미 가지고 있음)에 저장하지만,
        // LinkedList의 경우 인덱스 번호를 함께 저장하지 않기에,
        // 특정값의 인덱스를 얻기 위해 모든 리스트의 순서를 하나하나씩 매번 탐색해야한다.

        for (int i : moves) {
            
            loop:
            for (int j = 0; j < board.length; j++) {

                if(board[j][i-1] != 0)
                {
                    basket.add(board[j][i-1]);

                    if (basket.size() > 1 && basket.get(basket.size()-1).equals(basket.get(basket.size()-2))) {
                        // 위의 if 문의 condition을 살펴보면, 매번 인덱스 확인을 통해 특정값들을 비교하는것을 알 수 있다.
                        // 따라서 LinkedList 보다 ArrayList가 더 나은 선택임을 알 수 있다.
                        
                        basket.remove(basket.size()-1);
                        basket.remove(basket.size()-1);
                        //basket.removeLast();
                        //basket.removeLast();

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

//                추가 / 삭제    인덱스 조회
//  ArrayList       slow         fast
// LinkedList       fast         slow