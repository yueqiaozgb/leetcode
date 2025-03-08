package top.yueqiao.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author : yueqiao
 * @Create : 2025/3/8 20:44
 */
public class Solution3 {

    /**
     * 滑动窗口问题
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int[] length = new int[charArray.length];
        map.put(charArray[0], 0);
        length[0] = 1;
        int max = 1;
        for (int i = 1; i < charArray.length; i++) {
            if (!map.containsKey(charArray[i])) {
                map.put(charArray[i], i);
                length[i] = length[i - 1] + 1;
            } else {
                int index = map.get(charArray[i]);
                length[i] = i - index;
                map.clear();
                for (int j = index + 1; j <= i; j++) {
                    map.put(charArray[j], j);
                }
            }
            max = Math.max(max, length[i]);
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

}
