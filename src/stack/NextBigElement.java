package stack;

import java.util.HashMap;
import java.util.Stack;

/*
* 查找nums2中下一个元素是否比nums1中对应的元素大
* */
public class NextBigElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums1.length];
        HashMap<Integer,Integer> hashMap = new HashMap();

        for (int num:nums2) {
            while(!stack.isEmpty() && stack.peek() < num)
                hashMap.put(stack.pop(),num);

            stack.push(num);
        }

        for (int j=0;j<nums1.length;j++){
            result[j] = hashMap.getOrDefault(nums1[j],-1);
        }

        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        int[] n1 = {4,1,2};
        int[] n2 = {2,3,1,4,7};
        new NextBigElement().nextGreaterElement(n1,n2);

    }
}
