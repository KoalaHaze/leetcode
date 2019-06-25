package medium.Top;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* 46. 全排列
* */
public class Permute {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] tmp = new boolean[nums.length];
        backTrack(nums,new ArrayList<>(),tmp);
        return result;
    }

    public void backTrack(int[] nums,List<Integer> list,boolean[] tmp){
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i=0;i<nums.length;i++){
            if (tmp[i])
                continue;
            tmp[i] = true;
            list.add(nums[i]);
            backTrack(nums,list,tmp);
            tmp[i] = false;
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] n = {1,2,3};
        new Permute().permute(n);
    }
}
