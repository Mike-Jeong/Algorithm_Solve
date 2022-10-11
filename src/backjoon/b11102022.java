package backjoon;

import java.io.*;
import java.util.*;

//오큰수
//11102022

public class b11102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] nums = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < n; i++) {

			/*
			 * 스택이 비어있지 않으면서
			 * 현재 원소가 스택의 맨 위 원소가 가리키는 원소보다 큰 경우
			 * 해당 조건을 만족할 때 까지 stack의 원소를 pop하면서
			 * 해당 인덱스의 값을 현재 원소로 바꿔준다.
			 */
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				nums[stack.pop()] = nums[i];
			}

			stack.push(i);
		}

		/*
		 * 스택의 모든 원소를 pop하면서 해당 인덱스의 value를
		 * -1로 초기화한다.
		 */
		while (!stack.isEmpty()) {
			nums[stack.pop()] = -1;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(nums[i]).append(' ');
		}

		System.out.println(sb);

	}
}

// 해결을 못해서
// https://st-lab.tistory.com/196
// 해당 블로그의 풀이과정을 참고함
// 다시 풀어봐야함