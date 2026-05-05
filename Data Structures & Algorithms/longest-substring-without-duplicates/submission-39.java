class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        var chars = s.toCharArray();

        Set<Character> win = new HashSet<>();
        int l = 0;

        for (int r = 0; r < chars.length; r++) {
            var c = chars[r];
            while (win.contains(c)) {
                var oc = chars[l];
                win.remove(oc);
                l = l + 1;
            }

            win.add(c);
            res = Math.max(res, win.size());
        }

        return res;
    }
}
