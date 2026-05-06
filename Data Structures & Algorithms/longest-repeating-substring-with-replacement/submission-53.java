class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        var chars = s.toCharArray();
        Map<Character, Integer> win = new HashMap<>();
        int l = 0;
        int most = 0;

        for (int r = 0; r < chars.length; r++) {
            var c = chars[r];
            win.put(c, win.getOrDefault(c, 0) + 1);

            most = Math.max(most, win.get(c));
            var len = r - l + 1;
            if (len - most <= k) {
                res = Math.max(res, len);
            } else {
                var oc = chars[l];
                win.put(oc, win.get(oc) - 1);
                l++;
            }
        }

        return res;
    }
}
