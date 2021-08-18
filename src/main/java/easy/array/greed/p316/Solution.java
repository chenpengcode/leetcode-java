package main.java.easy.array.greed.p316;

/**
 * @Description
 * @Author CP
 * @Date 2020/12/20
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] count = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!vis[c - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c) {
                    char cur = sb.charAt(sb.length() - 1);
                    if (count[cur - 'a'] > 0) {
                        vis[cur - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[c - 'a'] = true;
                sb.append(c);
            }
            count[c - 'a']--;
        }
        return sb.toString();
    }
}
