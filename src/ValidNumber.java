/**
 * Created by jinglongyang on 11/9/14.
 */
public class ValidNumber {
    public static void main(String[] args) {
        System.out.println(new ValidNumber().isNumber("3"));
    }

    public boolean isNumber(String s) {
        if (s == null || s.trim().length() == 0) return false;

        String[] parts = s.trim().split("e");
        if (parts.length == 0 || parts.length > 2) return false;
        if (!isNum(parts[0])) return false;
        return parts.length == 2 ? isNum(parts[1]) : true;
    }

    private boolean isNum(String s) {
        if (s.length() == 0) return false;
        char c = s.charAt(0);
        String tmp = s;
        boolean dot = false;
        if ('+' == c || '-' == c || '.' == c) {
            tmp = s.substring(1);
            if ('.' == c) dot = true;
        }
        if (tmp.length() == 0) return false;
        for (int i = 0; i < tmp.length(); i++) {
            c = tmp.charAt(i);
            if ('.' == c) {
                if (dot) return false;
                dot = true;
            } else if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
