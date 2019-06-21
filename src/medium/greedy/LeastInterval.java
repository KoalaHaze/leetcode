package medium.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* 621. 任务调度器
* */
public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {

        /*HashMap<Character,Integer> hm = new HashMap<>();
        for (char task:tasks){
            if (hm.containsKey(task))
                hm.put(task,hm.get(task)+1);
            else
                hm.put(task,1);
        }
        int result = 0;
        int max = 0;
        for (Map.Entry<Character,Integer> entry:hm.entrySet()){
            result += entry.getValue();
            max = Math.max(max,entry.getValue());
        }
        int count = 0;
        for (Map.Entry<Character,Integer> entry:hm.entrySet()){
            if (entry.getValue() == max)
                count++;
        }
        result = (max-1)*(n+1)+count;
        return Math.max(result,tasks.length);*/

        int[] count = new int[26];
        for (char task:tasks){
            count[task-'A']++;
        }
        Arrays.sort(count);
        int maxCount = 0;
        for (int i=25;i>=0;i--){
            if (count[i] == count[25]){
                maxCount++;
            }else
                break;
        }
        int result = (count[25]-1)*(n+1)+maxCount;
        return Math.max(result,tasks.length);
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        new LeastInterval().leastInterval(tasks,2);
    }
}
