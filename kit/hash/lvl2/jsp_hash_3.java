import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Solution {
    public int solution(String[][] clothes) {
		Map<String, Integer> map = new ConcurrentHashMap<>();
		for (String[] clothe : clothes) {
			map.compute(clothe[1], (k, v) -> (v == null) ? 1 : ++v);
		}
		int answer = 1;
		for (Integer value : map.values()) {
			answer = answer * (value + 1);
		}
		return answer - 1;
    }
}
