class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;

        Map<Character, Integer> map = new HashMap<>();
        var charArray = s.toCharArray();

        int most = 0;
        int l = 0;

        for (int r = 0; r < charArray.length; r++) {
            var c = charArray[r];
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);

            most = Math.max(most, map.get(c));
            var winlen = r - l + 1;
            
            if (winlen - most <= k) {
                res = Math.max(res, winlen);
            } else {
                map.put(charArray[l], map.get(charArray[l]) - 1);
                l = l + 1;
            }
        }
        return res;
    }
}
