/**
 * Created by jinglongyang on 10/12/14.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int carry = 0;
        int la = a.length(), lb = b.length();
        int i = la - 1, j = lb - 1;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int a1 = i >= 0 ? (a.charAt(i) - '0') : 0;
            int b1 = j >= 0 ? (b.charAt(j) - '0') : 0;
            int tmp = a1 + b1 + carry;
            res.append(tmp % 2);
            carry = tmp / 2;
            i--;
            j--;
        }
        res.reverse();
        return res.toString();
    }
}
