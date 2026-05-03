class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (var c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int tlen = t.length();

        Map<Character, Integer> window = new HashMap<>();
        int collect = 0;

        var chars = s.toCharArray();
        int l = 0;
        int[] res = new int[] {-1, -1};
        int minlen = s.length() + 1;

        for (int r = 0; r < s.length(); r++) {
            var c = chars[r];
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (tMap.containsKey(c) && tMap.get(c) >= window.get(c)) {
                collect = collect + 1;
            }

            while (collect == tlen) {
                var len = r - l + 1;
                if (len < minlen) {
                    minlen = len;
                    res = new int[] {l, r};
                }

                var oc = chars[l];
                if (tMap.containsKey(oc) && tMap.get(oc) >= window.get(oc)) {
                    collect = collect - 1;
                }
                window.put(oc, window.get(oc) - 1);
                l = l + 1;
            }
        }

        if (res[0] == -1) {
            return "";
        }

        return s.substring(res[0], res[1] + 1);
    }
}
