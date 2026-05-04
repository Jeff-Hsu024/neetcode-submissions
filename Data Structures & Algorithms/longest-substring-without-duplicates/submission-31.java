class Solution {
    public int lengthOfLongestSubstring(String s) {
        var chars = s.toCharArray();
        var len = chars.length;

        Set<Character> set = new HashSet<>();
        int res = 0;
        int l = 0;

        for (int r = 0; r < len; r++) {
            var c = chars[r];
            var exists = set.contains(c);
            if (!exists) {
                int length = r - l + 1;
                res = Math.max(res, length);
            } else {
                var oc = chars[l];
                while (set.contains(c)) {
                    set.remove(oc);
                    l = l + 1;
                    oc = chars[l];
                }
            }
            set.add(c);
        }

        return res;
    }
}
