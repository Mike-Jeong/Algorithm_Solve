package programmers;

import java.util.*;
import java.util.Map.Entry;

//베스트앨범
//16032022

public class p16032022 {

    public static void main(String[] args) throws Exception {

        Solution81 s = new Solution81();

        String[] a = {"classic", "pop", "classic", "classic", "pop"};
        int[] b = {500, 600, 150, 800, 2500};

        System.out.println(s.solution(a, b));

    }
}

class Solution81 {

    public int[] solution(String[] genres, int[] plays) {

        Map<String,Integer> count_song = new HashMap<>();
        Map<String,ArrayList<Integer>> song_list = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            if (count_song.containsKey(genres[i])) {
                count_song.replace(genres[i], count_song.get(genres[i]), count_song.get(genres[i]) + plays[i]);
                song_list.get(genres[i]).add(i);
            } else {
                count_song.put(genres[i], plays[i]);
                song_list.put(genres[i], new ArrayList<>());
                song_list.get(genres[i]).add(i);
                
            }
        }

		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(count_song.entrySet());

		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
		
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
			{
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});

        int[] answer;
        List<Integer> as = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            ArrayList<Integer> sl = song_list.get(list_entries.get(i).getKey());

            if (sl.size() != 1) {
                Collections.sort(sl, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        o1 = plays[o1];
                        o2 = plays[o2];
                        return o2.compareTo(o1);
                    }
                });
                as.add(sl.get(0));
                as.add(sl.get(1));
            } else {
                as.add(sl.get(0));
            }
        }

        answer = as.stream().mapToInt(i->i).toArray();


        return answer; // 런타임 오류 뿜뿜.... 왜인지 모르겠음
    }
}

/*
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<Integer, String> indexHashMap = new HashMap<>(); // index를 기반으로 찾는 로직,
        HashMap<String, Integer>  totalPlayHashMap = new HashMap<>(); // generes의 값, plays의 값의 합 (genres간의 비교를 위함)

        ArrayList<Integer> answerArrayList = new ArrayList<>(); // 정답을 저장할 ArrayList


        for(int i = 0; i < genres.length; i++){
            if (totalPlayHashMap.containsKey(genres[i])) {
                // 해당 key를 가진 value가 존재하는 경우, 기존 value에 현재 값을 더한다.
                totalPlayHashMap.put(genres[i], totalPlayHashMap.get(genres[i]) + plays[i]);
            }
            else {
                totalPlayHashMap.put(genres[i], plays[i]);
            }
            // index를 key로 하기 때문에, 중복 확인 불필요
            indexHashMap.put(i, genres[i]);
        }

        // key값을 받아 playHashMap의 value값을 기반으로 내림차순 정렬
        String[] sortGenres = totalPlayHashMap.keySet().toArray(new String[0]);
        Arrays.sort(sortGenres, new Comparator<String>() {
            @Override
            public int compare(String key1, String key2) {
                return totalPlayHashMap.get(key2) - totalPlayHashMap.get(key1);
            }
        });


        // Genres값을 내림차순 순서대로 찾는다.
        for (String key : sortGenres) {
            ArrayList<Integer> tempArrayList = new ArrayList<>();
            // index를 기반으로 genres와 같은 value값을 찾아 ArrayList에 저장한다.
            for (int i = 0; i < genres.length; i++) {
                if (key.equals(indexHashMap.get(i))) {
                    tempArrayList.add(i);
                }
            }
            if(tempArrayList.size() < 2){
                // 값이 2개 미만일 때, 정렬 불필요
                answerArrayList.add(tempArrayList.get(0));
            }
            else {
                // key를 기준으로 받아온 index를 plays[index]를 기준으로하여 내림차순으로 정렬
                Integer[] sortPlays = tempArrayList.toArray(new Integer[0]);
                Arrays.sort(sortPlays, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer index1, Integer index2) {
                        return plays[index2] - plays[index1];
                    }
                });
                // 2개 이상이기 때문에, 위에서 부터 순서대로 2개 추가
                answerArrayList.add(sortPlays[0]);
                answerArrayList.add(sortPlays[1]);
            }
        }
        // ArrayList를 int 배열로 변경
        int[] answer = answerArrayList.stream().mapToInt(i->i).toArray();
        return  answer;
    }
} // 답안 퍼옴
*/