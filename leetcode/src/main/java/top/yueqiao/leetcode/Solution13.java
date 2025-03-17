package top.yueqiao.leetcode;

import java.util.HashMap;

/**
 * @author : yueqiao
 * @date : 2025/3/17 23:17
 */
public class Solution13 {

    private HashMap<Character, Integer> map = new HashMap<>(){
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };


    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.getOrDefault(s.charAt(i + 1), 0)) {
                result -= map.get(s.charAt(i));
            } else {
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }

}
