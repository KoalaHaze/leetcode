package hot100;

import java.util.ArrayList;
import java.util.List;

/*
* 78. 子集
* */
public class Subsets {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> list = new ArrayList<>();
        backTrack(list,0,nums);
        return result;
    }

    public void backTrack(List<Integer> list,int index,int[] nums){
        result.add(new ArrayList<>(list));
        for (int i=index;i<nums.length;i++){
            list.add(nums[i]);
            backTrack(list,i+1,nums);
            list.remove(list.size()-1);
        }

    }

}
