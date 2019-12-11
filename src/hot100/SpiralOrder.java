package hot100;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if((matrix==null||matrix.length==0))
            return res;
        int row = matrix.length,col=matrix[0].length;

        int r1=0,c1=0,r2=row-1,c2=col-1;
        while (r1 <= r2 && c1 <= c2){
            for (int i=c1;i<=c2;i++)
                res.add(matrix[r1][i]);
            r1++;
            for (int i=r1;i<=r2;i++)
                res.add(matrix[i][c2]);
            c2--;
            if (r1 <= r2 && c1 <= c2) {
                for (int i = c2; i >= c1; i--)
                    res.add(matrix[r2][i]);
                r2--;
                for (int i = r2; i >= r1; i--)
                    res.add(matrix[i][c1]);
                c1++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] r = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(new SpiralOrder().spiralOrder(r));
    }
}
