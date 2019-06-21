package BitOperation.easy;

/*
* 191. 位1的个数
* */
public class HammingWeight {
    public int hammingWeight(int n) {
        if (n == 0)
            return 0;
        int result = 0;
        for(int i=0;i<32;i++){
            result += n & 1;
            n = n>>1;
        }
        return result;
    }

}
