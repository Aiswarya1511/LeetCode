class Solution {

    public String longestPalindrome(String s) {
        int strtIndex = 0;
        int endIndex = 0;
        int strLength = s.length();

        for (int i = 0; i < strLength; i++) {

            int[] odd = expandFromCenter(s, i, i);

            if (odd[1] - odd[0] > endIndex - strtIndex) {
                strtIndex = odd[0];
                endIndex = odd[1];
            }

            int[] even = expandFromCenter(s, i, i + 1);

            if (even[1] - even[0] > endIndex - strtIndex) {
                strtIndex = even[0];
                endIndex = even[1];
            }
        }

        return s.substring(strtIndex, endIndex + 1);
    }

    private int[] expandFromCenter(String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return new int[]{left + 1, right - 1};
    }
}