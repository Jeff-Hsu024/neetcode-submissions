class Solution {
    public int characterReplacement(String s, int k) {
        var chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int most = 0;
        int l = 0;

        for (int r = 0; r < chars.length; r++) {
            var c = chars[r];
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
            most = Math.max(most, map.get(c));

            var len = r - l + 1;
            if (len - most <= k) {
                res = Math.max(res, len);
            } else {
                var oc = chars[l];
                map.put(oc, map.get(oc) - 1);
                l = l + 1;
            }
        }

        return res;
    }
}
