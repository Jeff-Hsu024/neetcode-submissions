class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int res = 0;

        Map<Character, Integer> win = new HashMap<>();
        int most = 0;

        var chars = s.toCharArray();
        for (int r = 0; r < chars.length; r++) {
            var c = chars[r];
            win.put(c, win.getOrDefault(c, 0) + 1);
            var count = win.get(c);
            most = Math.max(most, count);

            var len = r - l + 1;
            if (len - most <= k) {
                res = Math.max(res, len);
            } else {
                var oc = chars[l];
                win.put(oc, win.get(oc) - 1);
                l = l + 1;
            }

        }

        return res;
    }
}
