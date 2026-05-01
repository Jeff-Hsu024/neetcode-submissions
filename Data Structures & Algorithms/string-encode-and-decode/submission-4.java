class Solution {
    private final String salt = "#12@1211@@!";

    private final java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
    private final java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();

    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : strs) {
            String encodedStr =
                encoder.encodeToString((salt + str).getBytes());
            stringBuffer.append(encodedStr).append(".");
        }

        stringBuffer.setLength(stringBuffer.length() - 1);

        return stringBuffer.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty()) {
            return List.of();
        }

        List<String> strs = new ArrayList<>();
        String[] parts = str.split("\\.");
        for (String part : parts) {
            byte[] decodedByte = decoder.decode(part);
            String decodedStrWithSalt = new String(decodedByte);
            String decodedStr = decodedStrWithSalt.replaceFirst(salt, "");
            strs.add(decodedStr);
        }

        return strs;
    }
}
