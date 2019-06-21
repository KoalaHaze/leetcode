package greedy.easy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/*
* 1029. 两地调度
* */
public class TwoCitySchedCost {
    public int twoCitySchedCost(int[][] costs) {

//        Arrays.sort(costs,Comparator.comparingInt(value -> value[0]-value[1]));
//        int result = 0;
//        for (int i=0;i<costs.length/2;i++){
//            result += costs[i][0];
//        }
//        for (int i=costs.length/2;i<costs.length;i++){
//            result += costs[i][1];
//        }
//
//        return result;


        int result = 0;
        int[] temp = new int[costs.length];
        for (int i=0;i<costs.length;i++){
            result += costs[i][0];
            temp[i] += costs[i][1] - costs[i][0];
        }
        Arrays.sort(temp);
        for (int i=0;i<temp.length/2;i++){
            result += temp[i];
        }

        return result;
    }
}
