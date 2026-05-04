class Solution {
    public int lengthOfLongestSubstring(String s) {
        var chars = s.toCharArray();
        var len = chars.length;

        Set<Character> set = new HashSet<>();
        int res = 0;
        int l = 0;

        for (int r = 0; r < len; r++) {
            var c = chars[r];
            while (set.contains(c)) {
                var oc = chars[l];
                set.remove(oc);
                l = l + 1;
            }

            set.add(c);
            int length = r - l + 1;
            res = Math.max(res, length);
        }

        return res;
    }
}
