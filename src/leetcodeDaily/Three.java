package leetcodeDaily;

import medium.ListNode;

import java.util.*;

/**
 * @Description
 * @Author 80672
 * @Date 2023/1/6 16:09
 * @Version 1.0
 */
public class Three {

    /**
     * 2180. 统计各位数字之和为偶数的整数个数
     * 0106
     * easy
     *
     * @param num
     * @return
     */
    public int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            int sum = 0, j = i;
            while (j > 0) {
                sum += j % 10;
                j = j / 10;
            }
            if (sum % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 0112
     * 1807. 替换字符串中的括号内容
     * medium
     *
     * @param s
     * @param knowledge
     * @return
     */
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == '(') {
                StringBuilder sb = new StringBuilder();
                while (s.charAt(++index) != ')') {
                    sb.append(s.charAt(index));
                }
                result.append(map.getOrDefault(sb.toString(), "?"));
                index++;
            } else {
                result.append(s.charAt(index++));
            }
        }
        return result.toString();
    }

    /**
     * 2287. 重排字符形成目标字符串
     * 0113
     * easy
     *
     * @param s
     * @param target
     * @return
     */
    public int rearrangeCharacters(String s, String target) {
        int res = 0;
        int[] times = new int[26];
        for (int i = 0; i < s.length(); i++) {
            times[s.charAt(i) - 'a']++;
        }
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < target.length(); i++) {
                if (times[target.charAt(i) - 'a']-- <= 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res++;
            }
        }
        return res;
    }

    /**
     * 0116
     * 1813. 句子相似性 III
     * medium
     *
     * @param sentence1
     * @param sentence2
     * @return
     */
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() == sentence2.length()) {
            return sentence1.equals(sentence2);
        }
        // 1 大   2 小
        if (sentence1.length() < sentence2.length()) {
            String s = sentence1;
            sentence1 = sentence2;
            sentence2 = s;
        }
        String[] split1 = sentence1.split(" ");
        String[] split2 = sentence2.split(" ");
        int len1 = split1.length, len2 = split2.length;
        if (len2 >= len1) {
            return false;
        }
        int index1 = 0, index2 = 0;
        boolean flag = false;
        while (index2 < len2) {
            if (split1[index1].equals(split2[index2])) {
                index1++;
                index2++;
            } else if (!flag) {
                index1 = len1 - (len2 - index2);
                flag = true;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 1814. 统计一个数组中好对子的数目
     * 0117
     * medium
     *
     * @param nums
     * @return
     */
    public int countNicePairs(int[] nums) {
        int res = 0;
        final Integer d = 1000000007;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int v = 0, m = n;
            while (m > 0) {
                v = v * 10 + m % 10;
                m /= 10;
            }

            res = (map.getOrDefault(n-v, 0) + res ) % d;
            map.put(n-v, map.getOrDefault(n-v, 0)+1);

        }
        return res;
    }

    /**
     * 1669. 合并两个链表
     * medium
     * 0130
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode pre = list1;
        for (int i=0;i<a-1;i++){
            pre = pre.next;
        }
        ListNode aft = pre;
        for (int i=0;i<b-a+2;i++){
            aft = aft.next;
        }
        pre.next = list2;
        while (list2.next != null){
            list2 = list2.next;
        }
        list2.next = aft;
        return list1;
    }

    public static void main(String[] args) {
        Three three = new Three();
        int[] nums = new int[]{42, 11, 1, 97};
        System.out.println(three.countNicePairs(nums));

//        System.out.println("" + three.areSentencesSimilar("a A", "aAAa"));

//        System.out.println(three.rearrangeCharacters("abcba", "abc"));

//        System.out.println(three.countEven(4));
    }
}
