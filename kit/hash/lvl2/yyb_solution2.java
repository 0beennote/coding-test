class Solution {
    public int solution(String[][] clothes) {

        Map<String, List<String>> clothMap = new HashMap<String, List<String>>();
        for(String[] cloth : clothes) {
            // Same Key && Same Value
            if(clothMap.containsKey(cloth[1]) && clothMap.get(cloth[1]).contains(cloth[0])) {
                continue;
            // Same Key && Different Value
            } else if(clothMap.containsKey(cloth[1]) && !clothMap.get(cloth[1]).contains(cloth[0])) {
                List<String> valueList = new ArrayList<String>();
                valueList.addAll(clothMap.get(cloth[1]));
                valueList.add(cloth[0]);
                clothMap.put(cloth[1], valueList);
            } else {
                List<String> valueList = new ArrayList<String>();
                valueList.add(cloth[0]);
                clothMap.put(cloth[1], valueList);
            }
        }

        // List size of keys
        List<Integer> intList = new ArrayList<Integer>();
        for (Map.Entry<String, List<String>> entry : clothMap.entrySet()) {
            intList.add(entry.getValue().size());
        }

        int answer = 1;
        int index = 0;
        // What the...
        while(index < clothMap.size()) {
            index++;
        }

        return answer;
    }
}
