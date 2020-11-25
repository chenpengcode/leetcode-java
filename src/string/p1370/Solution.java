package string.p1370;

/**
 * @Description
 * @Author CP
 * @Date 2020/11/25
 */
public class Solution {
    public String sortString(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        int[] h = new int[26];
        for (int i = 0; i < s.length(); i++) {
            h[s.charAt(i) - 'a'] ++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (h[i] > 0) {
                    sb.append((char) (i + 'a'));
                    h[i] --;
                }
            }

            for (int i = 25; i >= 0 ; i--) {
                if (h[i] > 0) {
                    sb.append((char) (i + 'a'));
                    h[i] --;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "rat";
        System.out.println(solution.sortString(s));
    }
}
