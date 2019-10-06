package kit.sort.lvl1;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = {};
        answer = new int[commands.length];

        for(int i = 0; i <commands.length ; i++){

            int[] tempArr = {};
            int[] curCommands = commands[i];

            //if curCommands.length is not 3 error
            if (curCommands.length != 3) return null;            

            int start = curCommands[0];
            int end = curCommands[1];
            int index = curCommands[2];

            //when start > end, return 0
            if (start > end){
                answer[i] = 0;
                continue;
            }
            //when outofindex, return 0
            if ((end-start+1)<index){
                answer[i] = 0;
                continue;
            }

            //get the subArray from input array elements
            tempArr =  Arrays.copyOfRange(array, start-1, end);
            //and then sort the subArray
            Arrays.sort(tempArr);

            try{
                //get the resurt value from the subArray and the input array elements
                answer[i] = tempArr[index-1]; 
            }catch(Exception e){
                e.printStackTrace();
            }
        }        

        return answer;
    }
}
