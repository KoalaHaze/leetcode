package array.easy;

import java.util.HashMap;

/*
* 167. 两数之和 II - 输入有序数组
* */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        /*HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            hm.put(numbers[i],i);
        }
        int[] result = new int[2];
        for(int i=0;i<numbers.length-1;i++){
            int sc = target - numbers[i];
            if(hm.containsKey(sc) && hm.get(sc) != i){
                result[0] = Math.min(i+1,hm.get(sc)+1);
                result[1] = Math.max(i+1,hm.get(sc)+1);
            }
        }
        return result;*/

        int start = 0;
        int end = numbers.length-1;
        int[] result = new int[2];
        while (end > start){
            if ((numbers[start] + numbers[end]) == target){
                result[0] = start+1;
                result[1] = end+1;
                break;
            }else if ((numbers[start] + numbers[end]) < target)
                start++;
            else
                end--;
        }
        return result;
    }
}
