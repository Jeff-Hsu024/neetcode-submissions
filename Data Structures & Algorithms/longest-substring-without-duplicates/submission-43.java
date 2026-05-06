class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int l = 0;
        Set<Character> set = new HashSet<>();
        var chars = s.toCharArray();
        for (int r = 0; r < chars.length; r++) {
            var c = chars[r];
            while (set.contains(c)) {
                var oc = chars[l];
                set.remove(oc);
                l++;
            }
            set.add(c);
            res = Math.max(res, set.size());
        }

        return res;
    }
}
