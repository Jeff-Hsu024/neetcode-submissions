class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> tmap = new HashMap<>();
        for (var c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }
        int need = t.length();

        var chars = s.toCharArray();

        int l = 0;
        int collect = 0;
        Map<Character, Integer> win = new HashMap<>();
        int[] result = new int[] {-1, -1};
        int minlen = chars.length + 1;

        for (int r = 0; r < chars.length; r++) {
            var c = chars[r];
            win.put(c, win.getOrDefault(c, 0) + 1);
            if (tmap.containsKey(c) && tmap.get(c) >= win.get(c)) {
                collect = collect + 1;
            }
            // find win, then reduce length by increase l.
            while (need == collect) {
                int curlen = r - l + 1;
                if (minlen > curlen) {
                    minlen = curlen;
                    result[0] = l;
                    result[1] = r;
                }

                var oc = chars[l];
                if (tmap.containsKey(oc) && tmap.get(oc) >= win.get(oc)) {
                    collect = collect - 1;
                }

                win.put(oc, win.get(oc) - 1);
                l = l + 1;
            }
        }

        if (result[0] == -1) {
            return "";
        }

        return s.substring(result[0], result[1] + 1);
    }
}
