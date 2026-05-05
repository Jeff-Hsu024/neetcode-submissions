class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        var chars = s.toCharArray();
        int l = 0;
        int most = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < chars.length; r++) {
            var c = chars[r];
            map.put(c, map.getOrDefault(c, 0) + 1);
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
