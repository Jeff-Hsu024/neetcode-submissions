class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();

        var chars = s.toCharArray();
        int l = 0;
        for (int r = 0; r < chars.length; r++) {
            var c = chars[r];
            while (set.contains(c)) {
                var oc = chars[l];
                set.remove(oc);
                l++;
            }
            set.add(c);
            int curlen = r - l + 1;
            res = Math.max(res, curlen);
        }


        return res;
    }
}
