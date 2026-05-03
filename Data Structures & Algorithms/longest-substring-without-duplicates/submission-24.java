class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int l = 0;
        
        Set<Character> set = new HashSet();
        var chars = s.toCharArray();
        for (int r = 0; r < s.length(); r++) {
            var c = chars[r];
            while (set.contains(c)) {
                var oc = chars[l];
                set.remove(oc);
                l = l + 1;
            }

            set.add(c);
            res = Math.max(set.size(), res);
        }

        return res;
    }
}
