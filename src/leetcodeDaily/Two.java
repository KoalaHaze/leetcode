package leetcodeDaily;

import java.util.*;

/**
 * @Description
 * @Author 80672
 * @Date 2022/1/12 14:24
 * @Version 1.0
 */
public class Two {

    /**
     * 334. 递增的三元子序列
     * medium
     * 0112
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        int third;
        for (int i = 1; i < nums.length; i++) {
            third = nums[i];
            if (third > second) {
                return true;
            } else if (third > first) {
                second = third;
            } else {
                first = third;
            }
        }
        return false;
    }


    /**
     * 539. 最小时间差
     * medium
     * 0118
     *
     * @param timePoints
     * @return
     */
    public int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        if (len >= 60 * 24) {
            return 0;
        }
        Collections.sort(timePoints);
        int min = Integer.MAX_VALUE, last = transform(timePoints.get(0)), first = transform(timePoints.get(0));
        for (int i = 1; i < len; i++) {
            int now = transform(timePoints.get(i));
            min = Math.min(min, now - last);
            last = now;
        }
        min = Math.min(min, first + 1440 - last);

        return min;
    }

    private int transform(String point) {
        String[] split = point.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    /**
     * 1688. 比赛中的配对次数
     * easy
     * 0125
     *
     * @param n
     * @return
     */
    public static int numberOfMatches(int n) {
        int res = 0;
        while (n > 1) {
            if (n % 2 == 1) {
                res += (n - 1) / 2;
                n = (n - 1) / 2 + 1;
            } else {
                res += n / 2;
                n = n / 2;
            }
        }

        return res;
    }

    /**
     * 2047. 句子中的有效单词数
     * 0127
     * easy
     *
     * @param sentence
     * @return
     */
    public int countValidWords(String sentence) {
        String[] strings = sentence.split(" ");
        String pattern1 = "([a-z]+-[a-z]+){0,1}[a-z]*[!.,]{0,1}";

        int res = 0;
        for (String s : strings) {
            if (!s.isEmpty() && s.matches(pattern1)) {
                res++;
            }
        }


        return res;
    }


    /**
     * 1996. 游戏中弱角色的数量
     * medium
     * 0128
     *
     * @param properties
     * @return
     */
    public static int numberOfWeakCharacters(int[][] properties) {
        int res = 0;
        Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        int max = Integer.MIN_VALUE;
        for (int[] p : properties) {
            if (p[1] >= max) {
                max = p[1];
            } else {
                res++;
            }
        }
        return res;
    }


    /**
     * 540. 有序数组中的单一元素
     * medium
     * 0214
     *
     * @param nums
     * @return
     */
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length - 1;
        int l = 0, r = n, mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }
        return nums[r];
    }

    /**
     * 1791. 找出星型图的中心节点
     * easy
     * 0218
     *
     * @param edges
     * @return
     */
    public int findCenter(int[][] edges) {
        int[] ints0 = edges[0];
        int[] ints1 = edges[1];
        if (ints0[0] == ints1[0] || ints0[0] == ints1[1]) {
            return ints0[0];
        } else {
            return ints0[1];
        }

    }

    /**
     * 43. 字符串相乘
     * medium
     * 0222
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int l1 = num1.length();
        int l2 = num2.length();
        int[] result = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; i--) {
            int c1 = num1.charAt(i) - '0';
            for (int j = l2 - 1; j >= 0; j--) {
                int c2 = num2.charAt(j) - '0';
                int index = l1 - 1 + l2 - 1 - (i + j);
                int prod = c1 * c2 + result[index];
                result[index] = prod % 10;
                result[index + 1] += prod / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--) {
            if (i == result.length - 1 && result[i] == 0) {
                continue;
            }
            sb.append(result[i]);
        }

        return sb.toString();
    }

    /**
     * 6. Z 字形变换
     * medium
     * 0301
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        // i 是当前字符对应的行索引，[0, numRows-1]
        int i = 0;
        // flag 是 方向替代符，当i=numRows时，进行反向
        int flag = -1;
        for (int j = 0; j < s.length(); j++) {
            list.get(i).append(s.charAt(j));
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        return String.join("", list);
    }

    /**
     * 2104. 子数组范围和
     * 0304
     * medium
     *
     * @param nums
     * @return
     */
    public static long subArrayRanges(int[] nums) {
//       long sum = 0;
//       for (int i=0;i<nums.length-1;i++){
//           int min = nums[i], max = nums[i];
//           for (int j = i+1; j < nums.length; j++) {
//               min = Math.min(min, nums[j]);
//               max = Math.max(max, nums[j]);
//               sum += max - min;
//           }
//       }
//       return sum;

        int len = nums.length;
        long[] max = monotonousAdd(nums, true);
        long[] min = monotonousAdd(nums, false);
        long res = 0;
        for (int i = 0; i < len; i++) {
            res += (max[i] - min[i]) * nums[i];
        }
        return res;
    }

    // 单调增栈
    private static long[] monotonousAdd(int[] nums, boolean isAdd) {
        int len = nums.length;
        // res -- 返回数组，a -- 左侧数组， b -- 右侧数组
        int[] a = new int[len], b = new int[len];
        Deque<Integer> deque = new ArrayDeque<>();
        // 左侧
        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && (isAdd ? nums[deque.peekLast()] <= nums[i] : nums[deque.peekLast()] >= nums[i])) {
                deque.pollLast();
            }
            a[i] = deque.isEmpty() ? -1 : deque.peekLast();
            deque.addLast(i);
        }
        deque.clear();
        // 右侧
        for (int i = len - 1; i >= 0; i--) {
            while (!deque.isEmpty() && (isAdd ? nums[deque.peekLast()] < nums[i] : nums[deque.peekLast()] > nums[i])) {
                deque.pollLast();
            }
            b[i] = deque.isEmpty() ? len : deque.peekLast();
            deque.addLast(i);
        }
        long[] res = new long[len];
        for (int i = 0; i < len; i++) {
            res[i] = (i - a[i]) * (b[i] - i);
        }
        return res;
    }


    /**
     * 599. 两个列表的最小索引总和
     *
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (i > minIndex) {
                break;
            }
            String s = list2[i];
            if (map.containsKey(s)) {
                int index = map.get(s) + i;
                if (index == minIndex) {
                    res.add(s);
                } else if (index < minIndex) {
                    res.clear();
                    res.add(s);
                    minIndex = index;
                }
            }
        }

        return res.toArray(new String[res.size()]);
    }

    /**
     * 2038. 如果相邻两个颜色均相同则删除当前颜色
     * medium
     * 0322
     *
     * @param colors
     * @return
     */
    public boolean winnerOfGame(String colors) {
        int aTime = 0, bTime = 0;
        int aNum = 0, bNum = 0;
        for (int i = 0; i < colors.length(); i++) {
            char c = colors.charAt(i);
            if (c == 'A') {
                aNum += 1;
                if (aNum >= 3) {
                    aTime += 1;
                }
                bNum = 0;
            } else {
                bNum += 1;
                if (bNum >= 3) {
                    bTime += 1;
                }
                aNum = 0;
            }
        }
        return aTime > bTime;
    }

    /**
     * 693. 交替位二进制数
     * easy
     * 0328
     *
     * @param n
     * @return
     */
    public boolean hasAlternatingBits(int n) {
        int last = n % 2;
        n = n / 2;
        while (n > 0) {
            if (last == n % 2) {
                return false;
            }
            last = n % 2;
            n = n / 2;
        }
        return true;
    }

    /**
     * 728. 自除数
     * 0331
     * easy
     *
     * @param left
     * @param right
     * @return
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDivide(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean isSelfDivide(int num) {
        int s = num;
        while (s > 0) {
            int i = s % 10;
            if (i == 0 || num % i != 0) {
                return false;
            }
            s = s / 10;
        }
        return true;
    }


    /**
     * 796. 旋转字符串
     * 0407
     * easy
     *
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        // 方法一、执行用时：5 ms, 在所有 Java 提交中击败了6.40%的用户
//        int len = s.length();
//        for (int i=0;i<len;i++){
//            char c = s.charAt(0);
//            s = s.substring(1) + c;
//            if (s.equals(goal)){
//                return true;
//            }
//        }
//        return false;

//         方法二、执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
        return (s + s).contains(goal);
    }


    /**
     * 357. 统计各位数字都不同的数字个数
     * medium
     * 0411
     * <p>
     * 0 -> 1
     * 1 -> 10 = 1 * 10+0
     * 2 -> 91 = 10 * 9 +1
     * 3 -> 739 = 91 * 8 + 10 + 1
     *
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        int tem = 0;
        for (int i = 0; i < n; i++) {
            res[i + 1] = res[i] * (10 - i) + tem;
            tem += res[i];
        }
        return res[n];
    }

    /**
     * 806. 写字符串需要的行数
     * easy
     * 0412
     *
     * @param widths
     * @param s
     * @return
     */
    public int[] numberOfLines(int[] widths, String s) {
        int[] res = new int[2];
        int row = 1, unit = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (unit + widths[index] > 100) {
                row++;
                unit = widths[index];
            } else {
                unit += widths[index];
            }
        }
        res[0] = row;
        res[1] = unit;
        return res;
    }


    /**
     * 1672. 最富有客户的资产总量
     * easy
     * 0414
     *
     * @param accounts
     * @return
     */
    public int maximumWealth(int[][] accounts) {
        int temp = Integer.MIN_VALUE;
        for (int[] ac : accounts) {
            int cur = 0;
            for (int i : ac) {
                cur += i;
            }
            if (cur > temp) {
                temp = cur;
            }
        }
        return temp;
    }


    /**
     * 386. 字典序排数
     * medium
     * 0418
     *
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {

        List<Integer> list = new LinkedList<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            list.add(num);
            if (num * 10 <= n) {
                num *= 10;
            } else {
                while (num % 10 == 9 || num + 1 > n) {
                    num /= 10;
                }
                num++;
            }
        }
        return list;
    }


    /**
     * 821. 字符的最短距离
     * easy
     * 0419
     *
     * @param s
     * @param c
     * @return
     */
    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int index = 0;
            while (i + index < len || i - index >= 0) {
                if (i + index < len && s.charAt(i + index) == c) {
                    res[i] = index;
                    break;
                }
                if (i - index >= 0 && s.charAt(i - index) == c) {
                    res[i] = index;
                    break;
                }
                index++;
            }
        }
        return res;
    }


    /**
     * 824. 山羊拉丁文
     * easy
     * 0421
     *
     * @param sentence
     * @return
     */
    public String toGoatLatin(String sentence) {
        StringBuilder res = new StringBuilder();
        String[] strs = sentence.split(" ");
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            StringBuilder sb = new StringBuilder();
            int j = i;
            if (str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i' || str.charAt(0) == 'o' || str.charAt(0) == 'u' || str.charAt(0) == 'A' || str.charAt(0) == 'E' || str.charAt(0) == 'I' || str.charAt(0) == 'O' || str.charAt(0) == 'U') {
                sb.append(str).append("ma");
            } else {
                sb.append(str.substring(1)).append(str.charAt(0)).append("ma");
            }
            while (j >= 0) {
                sb.append("a");
                j--;
            }
            res.append(sb).append(" ");
        }
        return res.toString().trim();
    }


    /**
     * 396. 旋转函数
     * medium
     * 0422
     *
     * @param nums
     * @return
     */
    public int maxRotateFunction(int[] nums) {
        int len = nums.length, sum = Arrays.stream(nums).sum();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[0] += nums[i] * i;
        }
        for (int i = 1; i < len; i++) {
            arr[i] = arr[i - 1] - nums[len - i] * len + sum;
        }

        return Arrays.stream(arr).max().getAsInt();
    }

    /**
     * 868. 二进制间距
     * easy
     * 0424
     *
     * @param n
     * @return
     */
    public int binaryGap(int n) {
        int res = 0;
        int temp = 1;
        boolean flag = false;
        while (n != 0) {
            if ((n & 1) == 1) {
                if (flag) {
                    res = Math.max(res, temp);
                }
                flag = true;
                temp = 1;
            } else {
                temp++;
            }
            n >>= 1;
        }
        return res;
    }


    /**
     * 713. 乘积小于 K 的子数组
     * medium
     * 0505
     *
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0, temp = 1, left = 0;
        for (int i = 0; i < nums.length; i++) {
            temp *= nums[i];
            while (temp >= k && left <= i) {
                temp /= nums[left++];
            }
            res += i - left + 1;
        }
        return res;
    }

    /**
     * 942. 增减字符串匹配
     * easy
     * 0509
     *
     * @param s
     * @return
     */
    public int[] diStringMatch(String s) {
        int len = s.length();
        int[] res = new int[len + 1];
        int max = len, min = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == 'D') {
                res[i] = max--;
            } else if (c == 'I') {
                res[i] = min++;
            }
        }
        res[len] = min;
        return res;
    }


    /**
     * 面试题 01.05. 一次编辑
     * 0513
     * medium
     *
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {
        String s1 = first, s2 = second;
        if (first.length() > second.length()) {
            s1 = second;
            s2 = first;
        }
        if (s2.length() - s1.length() > 1) {
            return false;
        }
        int i = s1.length(), j = s2.length(), diff = 0;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                if (diff > 0) {
                    return false;
                }
                diff++;
                if (i != j) {
                    j--;
                    continue;
                }
            }
            i--;
            j--;
        }
        return true;
    }


    /**
     * 462. 最少移动次数使数组元素相等 II
     * 0519
     * medium
     *
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length, mid = nums[len / 2];
        return Arrays.stream(nums).map(i -> Math.abs(i - mid)).sum();
    }

    /**
     * 面试题 17.11. 单词距离
     * medium
     * 0527
     *
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int findClosest(String[] words, String word1, String word2) {
        int count = 0, first = 0, second = 0, res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                first = i;
                count++;
            }
            if (words[i].equals(word2)) {
                second = i;
                count++;
            }
            if (count >= 2) {
                res = Math.min(res, Math.abs(first - second));
            }
        }
        return res;
    }

    /**
     * 473. 火柴拼正方形
     * medium
     * 20220601
     *
     * @param matchsticks
     * @return
     */
    int[] ms;

    public boolean makesquare(int[] matchsticks) {

        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        int avg = sum / 4, len = matchsticks.length;
        ms = matchsticks;
        Arrays.sort(ms);
        return dfsMakesquare(len - 1, new int[4], avg);
    }

    private boolean dfsMakesquare(int i, int[] ints, int avg) {
        if (i <= 0) {
            for (int i1 : ints) {
                if (i1 != avg) {
                    return false;
                }
            }
            return true;
        }
        for (int j = 0; j < 4; j++) {
            int index = ms[i];
            if (ints[j] + index > avg) {
                continue;
            }
            ints[j] += index;
            if (dfsMakesquare(i - 1, ints, avg)) {
                return true;
            }
            ints[j] -= index;
        }
        return false;
    }

    /**
     * 1037. 有效的回旋镖
     * easy
     * 0608
     *
     * @param points
     * @return
     */
    public boolean isBoomerang(int[][] points) {
        if (points.length != 3) {
            return false;
        }
        return (points[1][0] - points[0][0]) * (points[2][1] - points[0][1]) != (points[2][0] - points[0][0]) * (points[1][1] - points[0][1]);
    }


    /**
     * 926. 将字符串翻转到单调递增
     * 0611
     * medium
     *
     * @param s
     * @return
     */
    public int minFlipsMonoIncr(String s) {
        int dp0 = 0, dp1 = 0;
        for (char c : s.toCharArray()) {
            int tmp0 = dp0 + (c - '0');
            int tmp1 = Math.min(dp0, dp1) + ('1' - c);
            dp0 = tmp0;
            dp1 = tmp1;
        }
        return Math.min(dp0, dp1);
    }


    /**
     * 1051. 高度检查器
     * easy
     * 0613
     *
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {

        int[] h1 = Arrays.copyOf(heights, heights.length);
        Arrays.sort(h1);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (h1[i] != heights[i]) {
                res++;
            }
        }
        return res;
    }

    /**
     * 498. 对角线遍历
     * medium
     * 0614
     *
     * @param mat
     * @return
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int i = 0, index = 0;
        while (i < m + n) {
            if (i % 2 == 0) {
                int row = i < m ? i : m - 1;
                int col = i - row;
                while (row >= 0 && col < n) {
                    res[index] = mat[row][col];
                    row--;
                    col++;
                    index++;
                }
            } else {
                int row = i < n ? 0 : i - n + 1;
                int col = i - row;
                while (row < m && col >= 0) {
                    res[index] = mat[row][col];
                    row++;
                    col--;
                    index++;
                }
            }
            i++;
        }
        return res;
    }


    /**
     * 532. 数组中的 k-diff 数对
     * medium
     * 0616
     *
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int res = 0;
        for (int i : nums) {
            if (!map.containsKey(i) || map.get(i) == 0) {
                continue;
            }
            if (k == 0) {
                res += map.get(i) > 1 ? 1 : 0;
            } else {
                int a = i + k, b = i - k;
                if (map.containsKey(a) && map.get(a) > 0) {
                    res++;
                }
                if (map.containsKey(b) && map.get(b) > 0) {
                    res++;
                }
            }
            map.put(i, 0);
        }

        return res;
    }


    /**
     * 1089. 复写零
     * easy
     * 0617
     *
     * @param arr
     */
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        int i = 0, j = 0;
        while (i < len) {
            if (arr[j] == 0) {
                i++;
            }
            i++;
            j++;
        }
        i--;
        j--;
        while (j >= 0) {
            if (i < len) {
                arr[i] = arr[j];
            }
            if (arr[j] == 0 && --i >= 0) {
                arr[i] = 0;
            }
            i--;
            j--;
        }

    }


    /**
     * 324. 摆动排序 II
     * 0628
     * medium
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length, m = (n + 1) / 2, i = m - 1, j = n - 1, k = 0;
        while (k < n) {
            nums[k++] = arr[i--];
            if (k < n) {
                nums[k++] = arr[j--];
            }
        }
    }

    /**
     * 535. TinyURL 的加密与解密
     * 0629
     * medium
     */
    public class Codec {
        HashMap<String, String> encodeMap = new HashMap<>(), decodeMap = new HashMap<>();
        int k = 7;
        String prefix = "http://tinyurl.com/";
        String str = "abcdefghijkmnopqretuvwxyzABCDEFGHIJKLMNOPQRSTUVWXY1234567890";
        Random random = new Random();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if (encodeMap.containsKey(longUrl)) {
                return encodeMap.get(longUrl);
            }
            while (true) {
                char[] c = new char[k];
                for (int i = 0; i < k; i++) {
                    c[i] = str.charAt(random.nextInt(str.length()));
                }
                String shortUrl = prefix + c.toString();
                if (!decodeMap.containsKey(shortUrl)) {
                    decodeMap.put(shortUrl, longUrl);
                    encodeMap.put(longUrl, shortUrl);
                    break;
                }
            }
            return encodeMap.get(longUrl);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return decodeMap.getOrDefault(shortUrl, "");
        }
    }


    /**
     * 1175. 质数排列
     * easy
     * 0630
     *
     * @param n
     * @return
     */
    int mod = (int) (1e9 + 7);
    static int[] factorial = new int[101];

    static {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= 100; i++) {
            boolean flag = false;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(i);
            }
            factorial[i] = list.size();
        }
    }

    public int numPrimeArrangements(int n) {
        long res = 1;
        int a = factorial[n], b = n - a;
        for (int i = a; i > 1; i--) {
            res = (res * i) % mod;
        }
        for (int i = b; i > 1; i--) {
            res = (res * i) % mod;
        }
        return (int) res;

    }

    /**
     * 1403. 非递增顺序的最小子序列
     * easy
     * 0804
     *
     * @param nums
     * @return
     */
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int sum = Arrays.stream(nums).sum();
        int res = 0, len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            res += nums[i];
            list.add(nums[i]);
            if (res > sum / 2) {
                break;
            }
        }
        return list;
    }


    /**
     * 640. 求解方程
     * medium
     * 0810
     *
     * @param equation
     * @return
     */
    public String solveEquation(String equation) {
        String[] arr = equation.split("(?=[-+=])");
        StringBuilder sb = new StringBuilder();
        for (String a : arr) {
            sb.append(a.replace("0x", "0"));
        }
        equation = sb.toString();
        int xNum = 0, sum = 0, len = equation.length();
        boolean plus = true, eq = false, containX = false;
        for (int i = 0; i < len; i++) {
            char c = equation.charAt(i);
            if (c == '=') {
                eq = true;
                plus = true;
                continue;
            } else if (c == '+') {
                plus = true;
                continue;
            } else if (c == '-') {
                plus = false;
                continue;
            } else {
                int num = 0;
                while (i < len && equation.charAt(i) >= '0' && equation.charAt(i) <= '9') {
                    num = num * 10 + (equation.charAt(i) - '0');
                    if (i + 1 < len && ((equation.charAt(i + 1) >= '0' && equation.charAt(i + 1) <= '9') || equation.charAt(i + 1) == 'x')) {
                        i++;
                    } else {
                        break;
                    }
                }
                if (i < len && equation.charAt(i) == 'x') {
                    num = num == 0 ? 1 : num;
                    containX = true;
                    if (plus ^ eq) {
                        xNum += num;
                    } else {
                        xNum -= num;
                    }
                } else {
                    if (plus ^ eq) {
                        sum += num;
                    } else {
                        sum -= num;
                    }
                }
            }
        }
        String res;
        if (xNum == 0) {
            res = sum != 0 ? "No solution" : "Infinite solutions";
        } else {
            res = "x=" + (-sum / xNum);
        }
        return res;
    }


    /**
     * 1417. 重新格式化字符串
     * 0811
     * easy
     *
     * @param s
     * @return
     */
    public String reformat(String s) {
        Stack<Character> alpStack = new Stack<>();
        Stack<Character> numStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                numStack.push(c);
            } else {
                alpStack.push(c);
            }
        }
        int alpLen = alpStack.size(), numLen = numStack.size();
        if (Math.abs(alpLen - numLen) > 1) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        if (alpLen > numLen) {
            while (!alpStack.isEmpty()) {
                res.append(alpStack.pop());
                if (!numStack.isEmpty()) {
                    res.append(numStack.pop());
                }
            }
        } else {
            while (!numStack.isEmpty()) {
                res.append(numStack.pop());
                if (!alpStack.isEmpty()) {
                    res.append(alpStack.pop());
                }
            }
        }
        return res.toString();
    }


    /**
     * 1224. 最大相等频率
     * hard
     * 0818
     *
     * @param nums
     * @return
     */
    public int maxEqualFreq(int[] nums) {
        int len = nums.length;
        // 存储每个数字出现的次数
        int[] count = new int[100001];
        // 存储出现次数的次数
        int[] sum = new int[100001];
        // 出现次数的最大次数
        int max = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int num = nums[i], c = ++count[num];
            sum[c]++;
            sum[c - 1]--;
            max = Math.max(max, c);
            int length = i + 1;
            // 更新res条件：
            // 1、max = 1 则任意一个数字出现的次数都为1
            // 2、max * sum[max] + 1  = length 则表示一个数字只出现了一次，其余都为max次
            // 3、(max-1)*sum[max-1] + max = length 则表示一个数字只出现了max次，其余都为max-1次
            if (max == 1 || max * sum[max] + 1 == length || (max - 1) * sum[max - 1] + max == length) {
                res = length;
            }
        }

        return res;
    }


    /**
     * 1450. 在既定时间做作业的学生人数
     * easy
     * 0819
     *
     * @param startTime
     * @param endTime
     * @param queryTime
     * @return
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                res++;
            }
        }
        return res;
    }


    /**
     * 1460. 通过翻转子数组使两个数组相等
     * easy
     * 0824
     *
     * @param target
     * @param arr
     * @return
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : target) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        for (int a : arr) {
            Integer orDefault = map.getOrDefault(a, 0);
            if (orDefault <= 0) {
                return false;
            }
            map.put(a, orDefault - 1);
        }
        return true;
    }


    /**
     * 1464. 数组中两元素的最大乘积
     * easy
     * 0826
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }


    /**
     * 1470. 重新排列数组
     * easy
     * 0829
     *
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int i = 0, r = n, l = 0;
        while (l < n) {
            res[i++] = nums[l++];
            res[i++] = nums[r++];
        }
        return res;
    }


    /**
     * 1475. 商品折扣后的最终价格
     * easy
     * 0901
     *
     * @param prices
     * @return
     */
    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int discount = 0;
            for (int j = i + 1; j < len; j++) {
                if (prices[j] <= prices[i]) {
                    discount = prices[j];
                    break;
                }
            }
            res[i] = prices[i] - discount;
        }
        return res;
    }


    /**
     * 1592. 重新排列单词间的空格
     * easy
     * 0907
     *
     * @param text
     * @return
     */
    public String reorderSpaces(String text) {
        int oldLen = text.length();
        int newLen = text.replace(" ", "").length();
        if (oldLen == newLen) {
            return text;
        }
        String[] split = text.split(" ");
        int num = 0;
        for (String s : split) {
            if (s.isEmpty() || "".equals(s)) {
                continue;
            }
            num++;
        }

        int interval = num == 1 ? 0 : (oldLen - newLen) / (num - 1);
        int remain = num == 1 ? (oldLen - newLen) : (oldLen - newLen) % (num - 1);
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            if (s.isEmpty() || "".equals(s)) {
                continue;
            }
            sb.append(s);
            for (int i = 0; i < interval; i++) {
                sb.append(" ");
            }
        }
        sb.delete(sb.length() - interval, sb.length());
        for (int i = 0; i < remain; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }


    /**
     * 667. 优美的排列 II
     * 0908
     * medium
     *
     * @param n
     * @param k
     * @return
     */
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int index = 0;
        int left = 1, right = n;
        while (index < k) {
            res[index++] = left++;
            if (index < k) {
                res[index++] = right--;
            }
        }
        if (k % 2 == 0) {
            // 降序
            while (index < n) {
                res[index++] = right--;
            }
        } else {
            while (index < n) {
                res[index++] = left++;
            }
        }

        return res;
    }


    /**
     * 面试题 17.19. 消失的两个数字
     * hard
     * 0926
     *
     * @param nums
     * @return
     */
    public int[] missingTwo(int[] nums) {
        int[] res = new int[2];
        int sum = 0, nSum = 0;
        for (int n : nums) {
            sum += n;
        }
        int len = nums.length + 2;
        for (int i = 1; i <= len; i++) {
            nSum += i;
        }
        int diff = nSum - sum;  // x+y
        int mid = diff / 2;
        int half = 0, nHalf = 0;
        for (int n : nums) {
            if (n <= mid) {
                half += n;
            }
        }
        for (int i = 1; i <= mid; i++) {
            nHalf += i;
        }
        int n1 = nHalf - half;
        int n2 = diff - n1;
        res[0] = n1;
        res[1] = n2;

        return res;
    }


    /**
     * 0927
     * 面试题 01.02. 判定是否互为字符重排
     * easy
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < len1; i++) {
            char c = s2.charAt(i);
            Integer aDefault = map.getOrDefault(c, 0);
            if (aDefault <= 0) {
                return false;
            }
            map.put(c, aDefault - 1);
        }

        return true;
    }


    /**
     * 面试题 17.09. 第 k 个数
     * 0928
     * medium
     *
     * @param k
     * @return
     */
    public int getKthMagicNumber(int k) {
        int[] nums = new int[k + 1];
        nums[0] = 1;
        int k3 = 0, k5 = 0, k7 = 0, index = 1;
        while (index < k) {
            int n3 = nums[k3] * 3;
            int n5 = nums[k5] * 5;
            int n7 = nums[k7] * 7;
            nums[index] = Math.min(n3, Math.min(n5, n7));
            if (nums[index] == n3) {
                k3++;
            }
            if (nums[index] == n5) {
                k5++;
            }
            if (nums[index] == n7) {
                k7++;
            }
            index++;
        }
        return nums[k - 1];
    }


    /**
     * 面试题 01.09. 字符串轮转
     * easy
     * 0929
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return (s2 + s2).contains(s1);
    }


    /**
     * 面试题 01.08. 零矩阵
     * medium
     * 0930
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[] rowZero = new int[r];
        int[] colZero = new int[c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    rowZero[i] = 1;
                    colZero[j] = 1;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (rowZero[i] == 1 || colZero[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    /**
     * 870. 优势洗牌
     * 1008
     * medium
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx1 = new Integer[n], idx2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx1[i] = i;
            idx2[i] = i;
        }
        Arrays.sort(idx1, Comparator.comparingInt(i -> nums1[i]));
        Arrays.sort(idx2, Comparator.comparingInt(i -> nums2[i]));
        int[] res = new int[n];
        int left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums1[idx1[i]] > nums2[idx2[left]]) {
                res[idx2[left++]] = nums1[idx1[i]];
            } else {
                res[idx2[right--]] = nums1[idx1[i]];
            }
        }
        return res;
    }

    /**
     * 856. 括号的分数
     * 1009
     * medium
     *
     * @param s
     * @return
     */
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(0);
            } else {
                Integer pop = stack.pop();
                int t = stack.isEmpty() ? 0 : stack.pop();
                stack.add(t + Math.max(pop * 2, 1));
            }
        }

        return stack.peek();
    }


    /**
     * 1790. 仅执行一次字符串交换能否使两个字符串相等
     * easy
     * 1011
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        int n = 0;
        char[] char1 = new char[2];
        char[] char2 = new char[2];
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (n >= 2) {
                    return false;
                }
                char1[n] = s1.charAt(i);
                char2[n] = s2.charAt(i);
                n++;
            }
        }
        if (n == 0) {
            return true;
        }
        if (n == 2 && char1[0] == char2[1] && char1[1] == char2[0]) {
            return true;
        }
        return false;
    }


    /**
     * 769. 最多能完成排序的块
     * 1013
     * medium
     *
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        int res = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                res++;
            }
        }
        return res;
    }


    /**
     * 904. 水果成篮
     * 1017
     * medium
     */
    public int totalFruit(int[] fruits) {
        int len = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, max = 0;
        for (int r = 0; r < len; r++) {
            int fruit = fruits[r];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
            while (map.size() > 2) {
                int f = fruits[left++];
                map.put(f, map.get(f) - 1);
                if (map.get(f) == 0) {
                    map.remove(f);
                }
            }
            max = Math.max(max, r - left + 1);
        }

        return max;
    }


    /**
     * 779. 第K个语法符号
     * medium
     * 1020
     */
    public int kthGrammar(int n, int k) {
        if (k == 1) {
            return 0;
        }
        if (k > 1 << (n - 2)) {
            return 1 - kthGrammar(n - 1, k - (1 << (n - 2)));
        }
        return kthGrammar(n - 1, k);
    }


    /**
     * 1822. 数组元素积的符号
     * 1027
     * easy
     *
     * @param nums
     * @return
     */
    public int arraySign(int[] nums) {
        int res = 1;
        for (int i : nums) {
            if (i == 0) {
                return 0;
            } else if (i < 0) {
                res *= -1;
            }
        }
        return res;
    }


    /**
     * 1662. 检查两个字符串数组是否相等
     * 1101
     * easy
     *
     * @param word1
     * @param word2
     * @return
     */
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String str1 = String.join("", word1);
        String str2 = String.join("", word2);
        return str1.equals(str2);
    }


    /**
     * 1668. 最大重复子字符串
     * easy
     * 1103
     *
     * @param sequence
     * @param word
     * @return
     */
    public int maxRepeating(String sequence, String word) {
        int res = 0;
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        while (flag) {
            sb.append(word);
            if (sequence.contains(sb.toString())) {
                res++;
            } else {
                flag = false;
            }
        }
        return res;
    }


    /**
     * 816. 模糊坐标
     * 1107
     * medium
     *
     * @param s
     * @return
     */
    public List<String> ambiguousCoordinates(String s) {
        List<String> list = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            for (String x : getGenNums(s.substring(0, i))) {
                for (String y : getGenNums(s.substring(i))) {
                    list.add(new StringBuilder("(").append(x).append(", ").append(y).append(")").toString());
                }
            }
        }

        return list;
    }

    private List<String> getGenNums(String substring) {
        List<String> list = new ArrayList<>();
        String left, right;
        int i = 1;
        while (i <= substring.length()) {
            left = substring.substring(0, i);
            right = substring.substring(i++);
            if ((!left.equals("0") && left.charAt(0) == '0') || // 对于逗号左侧【整数】，不允许以0开头，除非这个整数就是0本身
                    (!right.isEmpty() && right.charAt(right.length() - 1) == '0')) continue; // 对于逗号右侧【小数】，不允许以0作为结尾
            if (right.isEmpty()) list.add(left);
            else list.add(new StringBuilder(left).append(".").append(right).toString());
        }
        return list;
    }


    /**
     * 1684. 统计一致字符串的数目
     * easy
     * 1108
     *
     * @param allowed
     * @param words
     * @return
     */
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        a:
        for (String word : words) {
            b:
            for (int i = 0; i < word.length(); i++) {
                if (!set.contains(word.charAt(i))) {
                    continue a;
                }
            }
            res++;
        }

        return res;
    }

    /**
     * 12. 整数转罗马数字
     * 1110
     * medium
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();

    }

    /**
     * 1710. 卡车上的最大单元数
     * easy
     * 1115
     *
     * @param boxTypes
     * @param truckSize
     * @return
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] unit = new int[boxTypes.length];
        int index = 0;
        for (int[] box : boxTypes) {
            map.put(box[1], map.getOrDefault(box[1], 0) + box[0]);
            unit[index++] = box[1];
        }
        Arrays.sort(unit);
        for (int i = unit.length - 1; i >= 0; i--) {
            Integer num = map.get(unit[i]);
            if (truckSize >= num) {
                res += unit[i] * num;
                map.put(unit[i], 0);
                truckSize -= num;
            } else {
                res += unit[i] * truckSize;
                break;
            }
        }


        return res;
    }


    /**
     * 795. 区间子数组个数
     * medium
     * 1124
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
//    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
//        int res = 0, mid = -1, greater = -1;
//
//
//    }


    /**
     * 1758. 生成交替二进制字符串的最少操作数
     * easy
     * 1129
     *
     * @param s
     * @return
     */
    public int minOperations(String s) {
        int len = s.length();
        int c = 0;
        for (int i=0;i<len;i++){
            if (s.charAt(i) - '0' != i % 2){
                c ++;
            }
        }
        return Math.min(c, len - c);
    }


    /**
     * 1796. 字符串中第二大的数字
     * 1203
     * easy
     *
     * @param s
     * @return
     */
    public int secondHighest(String s) {
        int length = s.length();
        int[] num = new int[10];
        for (int i=0;i<length;i++){
            int c = s.charAt(i) - '0';
            if (c < 10){
                num[c] ++;
            }
        }
        boolean flag = false;
        for (int i = 9;i>=0;i--){
            if (num[i] > 0){
                if (!flag){
                    flag = true;
                }else {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(new Two().minOperations("10010100"));

//        System.out.println(new January().numSubarrayBoundedMax(new int[]{73, 55, 36, 5, 55, 14, 9, 7, 72, 52}, 32, 69));

//        System.out.println(Arrays.asList("sdd".split(",")));

//        System.out.println(new January().kthGrammar(4,8));

//        System.out.println(new January().scoreOfParentheses("(())"));

//        int[] nums = {1};
//        System.out.println(new January().missingTwo(nums));

//        System.out.println(new January().constructArray(3,2));

//        System.out.println(new January().reorderSpaces("  hello"));
//        int[] nums = {100000, 100000};
//        System.out.println(new January().maxEqualFreq(nums));

//        System.out.println(new January().solveEquation("0x=0"));

//        int[] num = {1, 3, 1, 5, 4};
//        System.out.println(new January().findPairs(num, 0));
//        int[] num = {1, 1, 2, 2, 2};
//        System.out.println(new January().makesquare(num));

//        int[] nums = {1,0,0,8,6};
//        System.out.println(new January().minMoves2(nums));

//        System.out.println(new January().oneEditAway("teacher","bleacher"));

//        System.out.println(numberOfMatches(18));

//        int[][] p = {{5, 5}, {6, 3}, {3, 6}};
//        System.out.println(numberOfWeakCharacters(p));

//        int[] num = {1, 1, 2, 3, 3, 4, 4, 8, 8};
//        System.out.println(singleNonDuplicate(num));

//        System.out.println(multiply("123", "456"));

//        System.out.println(convert("PAYPALISHIRING", 3));

//        int[] num = {4, -2, -3, 4, 1};
//        System.out.println(subArrayRanges(num));

//        System.out.println(new January().selfDividingNumbers(1,22));
//        System.out.println(new January().rotateString("abcde","cdeab"));

//        System.out.println(new January().countNumbersWithUniqueDigits(4));

//        System.out.println(new January().lexicalOrder(13));


////        System.out.println(new January().shortestToChar("baaa", 'b'));
//        int[] nums = {4,3,2,6};
//        System.out.println(new January().maxRotateFunction(nums));

//        System.out.println(new January().binaryGap(8));
    }
}
