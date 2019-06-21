package easy;

import java.util.ArrayList;
import java.util.List;

public class Generate {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0)
            return result;

        result.add(new ArrayList<Integer>());
        result.get(0).add(1);

        for (int i=1;i<numRows;i++){
            List<Integer> cur = new ArrayList<>();
            List<Integer> pre = result.get(i-1);
            cur.add(1);
            for (int j=1;j<i;j++){
                cur.add(pre.get(j-1)+pre.get(j));
            }
            cur.add(1);
            result.add(cur);
        }
        return result;
    }

    public static void main(String[] args) {
        new Generate().generate(5);
    }
}
