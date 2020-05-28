package programmers.hash.unfinished;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args){
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		System.out.println(solution(participant, completion));
	}
    public static String solution(String[] participant, String[] completion) {

        String answer = "";
        int val = 0;
        
        Map<String, Integer> map = new HashMap<>();
        		
        //참가자 Map담기
        for(int i=0; i<participant.length; i++) {
        	if(map.get(i)==null) {
        		map.put(participant[i], 1);
        	}
        	else {
        		val = map.get(i) + 1;
        		map.put(participant[i], val);
//        		System.out.println("??");
        	}
//        	System.out.println("participant="+map.toString());
        }
        //완주자 제외
        for(String comp : completion) {
            val = map.get(comp) - 1;
            map.put(comp,val);
//            System.out.println("completion="+map.toString());
        }
        //출력
        for(String key : map.keySet()) {
            if(map.get(key) == 1) answer = key;
//            System.out.println("key="+map.toString());
        }
        return answer;
    }

}
