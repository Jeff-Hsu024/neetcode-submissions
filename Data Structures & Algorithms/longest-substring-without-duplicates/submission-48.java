class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        var chars = s.toCharArray();
        int l = 0;

        for (int i = 0;i < chars.length; i++) {
            var c = chars[i];

            while (set.contains(c)) {
                var oc = chars[l];
                set.remove(oc);
                l++;
            }

            set.add(c);
            res = Math.max(set.size(), res);
        }


        return res;
    }
}
