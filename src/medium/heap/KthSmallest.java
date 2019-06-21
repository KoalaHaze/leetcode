package medium.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
* 378. 有序矩阵中第K小的元素
* */
public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null)
            return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (pq.size() < k)
                    pq.add(matrix[i][j]);
                else if (matrix[i][j] < pq.peek()){
                    pq.poll();
                    pq.add(matrix[i][j]);
                }

            }
        }
        return pq.peek();
    }
}
