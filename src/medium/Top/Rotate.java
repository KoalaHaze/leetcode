package medium.Top;

/*
* 48. 旋转图像
* */
public class Rotate {
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        for (int i=0;i<(n/2+n%2);i++){
            for (int j=0;j<n/2;j++){
                /*int col = j;
                int row = i;
                int[] tmp = new int[4];
                for (int k=0;k<4;k++){
                    tmp[k] = matrix[row][col];
                    int temp = row;
                    row = col;
                    col = n-1-temp;
                }

                for (int k=0;k<4;k++){
                    matrix[row][col] = tmp[(k+3)%4];
                    int temp = row;
                    row = col;
                    col = n-1-temp;
                }*/

                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;

            }
        }

    }

    public static void main(String[] args) {
        int[][] t = {{1,2,3},{4,5,6},{7,8,9}};
        new Rotate().rotate(t);
    }
}
