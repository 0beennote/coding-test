import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> kindMap = new HashMap();

        for(int i=0; i<clothes.length; i++){
            if ( kindMap.containsKey(clothes[i][1]) ){
                kindMap.put(clothes[i][1], kindMap.get(clothes[i][1])+1);
            }
            else{
               kindMap.put(clothes[i][1], 1);
            }
        }

        Set<Map.Entry<String, Integer>> entries = kindMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            //디폴트(옷없음)까지 곱하고 전체 종류 옷 없는 케이스만 빼면 됨
            int value = entry.getValue();
            answer *= (value + 1);
        }

        return answer-1;
    }
}
