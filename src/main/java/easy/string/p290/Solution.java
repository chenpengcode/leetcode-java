package main.java.easy.string.p290;

import java.util.*;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/16
 */
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> str2ch = new HashMap<>();
        Map<Character, String> ch2str = new HashMap<>();
        int m = s.length();
        int i = 0;
        for (int p = 0; p < pattern.length(); ++p) {
            char ch = pattern.charAt(p);
            if (i >= m) return false;
            int j = i;
            while (j < m && s.charAt(j) != ' ') {
                ++j;
            }
            String tmp = s.substring(i, j);
            if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                return false;
            }
            if (ch2str.containsKey(ch) && !ch2str.get(ch).equals(tmp)) {
                return false;
            }
            str2ch.put(tmp, ch);
            ch2str.put(ch, tmp);
            i = j + 1;
        }
        return i >= m;
    }

    public static void main(String[] args) {
        String pattern = "abba", str = "dog cat cat dog";
        Solution solution = new Solution();
        System.out.println(solution.wordPattern(pattern, str));
    }
}
