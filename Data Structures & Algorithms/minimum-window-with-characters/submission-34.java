class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> tmap = new HashMap<>();
        for (var c: t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> win = new HashMap<>();

        int need = t.length();
        int collect = 0;
        int l = 0;

        // start end
        int[] result = new int[] { -1, -1 };

        var chars = s.toCharArray();
        int minSubLen = chars.length + 1;

        for (int r = 0; r < chars.length; r++) {
            var c = chars[r];
            win.put(c, win.getOrDefault(c, 0) + 1);
            if (tmap.containsKey(c) && tmap.get(c) >= win.get(c)) {
                collect = collect + 1;
            }
            // find the sub, so left should increase.
            while (need == collect) {
                int len = r - l;
                if (len < minSubLen) {
                    minSubLen = len;
                    result = new int[] { l, r };
                }

                var oldc = chars[l];
                if (tmap.containsKey(oldc) && tmap.get(oldc) == win.get(oldc)) {
                    collect = collect - 1;
                }
                win.put(oldc, win.get(oldc) - 1);
                l = l + 1;
            }

        }
        
        if (result[0] == -1) {
            return "";
        }

        return s.substring(result[0], result[1] + 1);
    }
}
