package backjoon;

import java.io.*;
import java.util.*;

//암호 만들기
//07042022

public class b07042022 {

    static char[] alphabet;
    static LinkedList<Character> gather;
    static int n_Password;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        n_Password = Integer.parseInt(str[0]);
        int n_Alphabet = Integer.parseInt(str[1]);

        alphabet = new char[n_Alphabet];
        gather = new LinkedList<>();

        str = br.readLine().split(" ");

        for (int i = 0; i < n_Alphabet; i++) {
            char a = str[i].charAt(0);
            alphabet[i] = a;
            if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
                gather.add(a);
            }
        }

        Arrays.sort(alphabet);

        sb = new StringBuilder();

        if (!gather.isEmpty()) {
            recursion(0, 0);
        }
    }

    public static void recursion(int count, int index) {

        if (count >= n_Password || index == alphabet.length) {

            if (count == n_Password) {
                int g = 0;
                int rest;

                for (int i = 0; i < n_Password; i++) {
                    for (char character : gather) {
                        if (sb.charAt(i) == character) {
                            g++;
                        }
                    }
                }

                rest = count - g;

                if (g > 0 && rest > 1) {
                    System.out.println(sb);
                }
            }

            return;
        }

        sb.append(alphabet[index]);
        recursion(count + 1, index + 1);
        sb.deleteCharAt(sb.length() - 1);
        recursion(count, index + 1);

    }
}
