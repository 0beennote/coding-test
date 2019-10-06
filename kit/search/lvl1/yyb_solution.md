Solution1
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[answers.length];

        int numberOfParticipation = 3;
        List<Integer> resultList = new ArrayList<Integer>(numberOfParticipation);

        for(int i=0; i<numberOfParticipation; i++) {
            resultList.add(0);
        }

        // 1번 수포자 정답수
        for(int i=0; i<answers.length; i++) {
            if(i == 0) {
                answer[i] = 1;
            } else if(answer[i-1] == 5) {
                answer[i] = 1;
            } else {
                answer[i] = answer[i-1] + 1;
            }

            if(answer[i] == answers[i]) {
                resultList.set(0, resultList.get(0) + 1);
            }
        }

        // 2번 수포자 정답수
        for(int i=0; i<answers.length; i++) {
            if(i == 0 || i%2 == 0) {
                answer[i] = 2;
            } else {
                if(i < 2) {
                    answer[i] = 1;
                } else if(answer[i-2] == 1) {
                    answer[i] = answer[i-2] + 2;
                } else if(answer[i-2] == 5) {
                    answer[i] = 1;
                } else {
                    answer[i] = answer[i-2] + 1;
                }
            }

            if(answer[i] == answers[i]) {
                resultList.set(1, resultList.get(1) + 1);
            }
        }

        // 3번 수포자 정답수
        for(int i=0; i<answers.length; i++) {
            if(i%2 == 1) {
                answer[i] = answer[i-1];
            } else {
                if(i < 2) {
                    answer[i] = 3;
                } else if(answer[i-2] == 3) {
                    answer[i] = 1;
                } else if(answer[i-2] == 2) {
                    answer[i] = answer[i-2] + 2;
                } else if(answer[i-2] == 5) {
                    answer[i] = 3;
                } else {
                    answer[i] = answer[i-2] + 1;
                }
            }

            if(answer[i] == answers[i]) {
                resultList.set(2, resultList.get(2) + 1);
            }
        }

        int max = 0;
        for(int result : resultList) {
            if(result > max) {
                max = result;
            }
        }

        int[] tmpAnswer = new int[numberOfParticipation];
        int index = 0;
        int numberOfMan = 0;

        if(max > 0) {
            for(int result : resultList) {
                numberOfMan++;
                if(result == max) {
                    tmpAnswer[index] = numberOfMan;
                    index++;
                }
            }
        }

        int[] answerForReturn = Arrays.copyOf(tmpAnswer, index);

        return answerForReturn;
    }
}
```

Solution2
```java
import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	public int[] solution(int[] answers) {
		
		int numberOfParticipants = 3;
        int[] answer = new int[numberOfParticipants];
        int[][] answerOfParticipants = {
        		{1, 2, 3, 4, 5},
        		{2, 1, 2, 3, 2, 4, 2, 5},
        		{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        for(int i=0; i<answers.length; i++) {
        	if(answers[i] == answerOfParticipants[0][i%5]) answer[0]++;
        	if(answers[i] == answerOfParticipants[1][i%8]) answer[1]++;
        	if(answers[i] == answerOfParticipants[2][i%10]) answer[2]++;
        }

        List<Integer> resultList = new ArrayList<Integer>();
        int maxValue = 0;
        for(int i=0; i<answer.length; i++) {
        	if(answer[i] > maxValue) {
        		maxValue = answer[i];
        		
        		resultList = new ArrayList<Integer>();
        		resultList.add(i+1);
        	} else if(answer[i] == maxValue) {
        		resultList.add(i+1);
        	}
        }
        
        int[] answerForReturn = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++) {
        	answerForReturn[i] = resultList.get(i);
        }
        
        return answerForReturn;
    }
}
```
