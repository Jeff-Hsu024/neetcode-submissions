class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;

        var chars = s.toCharArray();
        var len = chars.length;
        var l = 0;

        Map<Character, Integer> map = new HashMap<>();
        int mostc = 0;
        for (int r = 0; r < len; r++) {
            var c = chars[r];
            map.put(c, map.getOrDefault(c, 0) + 1);
            mostc = Math.max(mostc, map.get(c));

            var curlen = r - l + 1;
            var valid = curlen - mostc <= k;
            if (valid) {
                res = Math.max(res, curlen);
            } else {
                var oc = chars[l];
                map.put(oc, map.get(oc) - 1);
                l = l + 1;
            }
        }

        return res;
    }
}
