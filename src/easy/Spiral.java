package easy;

import java.util.ArrayList;
import java.util.List;

public class Spiral {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length < 1)
            return list;
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        int x = 0,y = 0;
        while(n >= x && m >= y){
            for(int i=x;i<=n;i++)
                list.add(matrix[y][i]);
            for (int i=y+1;i<=m;i++)
                list.add(matrix[i][n]);
            if (n>x && m>y){
                for (int i=n-1;i>x;i--)
                    list.add(matrix[m][i]);
                for (int i=m;i>y;i--)
                    list.add(matrix[i][x]);
            }
            x++;y++;
            m--;n--;

        }
        return list;
    }

    public static void main(String[] args) {
        int[][] num = {{1,2,3},{4,5,6},{7,8,9}};
        new Spiral().spiralOrder(num);
    }
}
