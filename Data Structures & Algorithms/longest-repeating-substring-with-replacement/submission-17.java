class Solution {

    public int characterReplacement(String s, int k) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        var chary = s.toCharArray();
        int l = 0;
        int most = 0;

        for (int r=0; r < s.length(); r++) {
            var c = chary[r];
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
            most = Math.max(most, map.get(c));
            var winLen = r - l + 1;

            if ((winLen - most) <= k) {
                res = Math.max(res, winLen);
            } else {
                var removeC = chary[l];
                map.put(removeC, map.get(removeC) - 1);
                l = l + 1;
            }
        }

        return res;
    }
}
