class Solution {
    private final String salt = "salt!!@@sqws";
    private final String lengthSpilt = "xqw13dcsa####";
    private final String spilt = ".";

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        };
        StringBuilder sb = new StringBuilder();

        for (var str : strs) {
            sb.append(encodeStr(str)).append(spilt);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        String[] parts = str.split("\\.");

        List<String> decoded = new ArrayList<>();

        for (var part : parts) {
            decoded.add(decodeStr(part));
        }

        return decoded;
    }

    public String encodeStr(String s) {
        var len = s.length();

        StringBuilder sb = new StringBuilder();
        sb.append(len)
        .append(lengthSpilt);
        for (var c : s.toCharArray()) {
            sb.append(c).append(salt);
        }
        return sb.toString();
    }

    public String decodeStr(String s) {
        StringBuilder sb = new StringBuilder();
        int length = Integer.parseInt(s.split(lengthSpilt)[0]);
        if (length == 0) {
            return "";
        }

        for (var part : s.split(lengthSpilt)[1].split(salt)) {
            sb.append(part);
            if (sb.length() == length) {
                break;
            }
        }

        return sb.toString();
    }
}
