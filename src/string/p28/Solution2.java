package string.p28;

/**
 * @Description
 * @Author CP
 * @Date 2021/4/20
 */
public class Solution2 {
    public void getPrefixTable(String needle, int[] prefix) {
        int n = prefix.length;
        prefix[0] = 0;
        int len = 0, i = 1;
        while (i < n) {
            if (needle.charAt(i) == needle.charAt(len)) {
                ++len;
                prefix[i] = len;
                ++i;
            } else {
                if (len == 0) {
                    prefix[i] = 0;
                    ++i;
                } else {
                    len = prefix[len - 1];
                }
            }
        }
        System.arraycopy(prefix, 0, prefix, 1, n - 1);
        prefix[0] = -1;
    }

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n == 0) return 0;
        int[] prefix = new int[n];
        getPrefixTable(needle, prefix);

        int i = 0, j = 0;
        while (i < m) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                if (j == n - 1) return i - j;
                ++i;
                ++j;
            } else {
                j = prefix[j];
                if (j == -1) {
                    ++i;
                    ++j;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.strStr(haystack, needle));
    }
}
