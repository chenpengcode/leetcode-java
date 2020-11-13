package string.p344;

import java.util.Arrays;

/**
 * @Description
 * @Author ChenPeng
 * @Date 2020-11-13 22:31
 */
class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int i = 0, j = n - 1;
        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i += 1;
            j -= 1;
        }
    }

    public void reverseString_recu(char[] s) {
        if (s == null || s.length == 1) {
            return;
        }
        reverseHelper(s, 0, s.length - 1);
    }

    private void reverseHelper(char[] s, int left, int right) {
        if (left > right) {
            return;
        }
        swap(s, left, right);
        left += 1;
        right -= 1;
        reverseHelper(s, left, right);
    }

    private void swap(char[] s, int left, int right) {
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
    }

    public static void main(String[] args) {
        String s = "hello";
        char[] c = s.toCharArray();
        Solution solution = new Solution();
        solution.reverseString_recu(c);
        System.out.println(Arrays.toString(c));
    }
}
