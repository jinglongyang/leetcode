/**
 * Created by jinglongyang on 12/16/14.
 */
public class CompareVersionNumbers {
    public static void main(String[] args) {
        System.out.println(new CompareVersionNumbers().compareVersion("1", "0"));
    }

    public int compareVersion(String version1, String version2) {
        if (version1 == null || version1.length() == 0 || version2 == null || version2.length() == 0) {
            throw new IllegalArgumentException("");
        }

        String[] version1Parts = version1.split("\\.");
        String[] version2Parts = version2.split("\\.");
        int i = 0;
        while (i < version1Parts.length || i < version2Parts.length) {
            int tmp1 = i > version1Parts.length ? 0 : Integer.parseInt(version1Parts[i]);
            int tmp2 = i > version2Parts.length ? 0 : Integer.parseInt(version2Parts[i]);
            if (tmp1 > tmp2) {
                return 1;
            }
            if (tmp1 < tmp2) {
                return -1;
            }
            i++;
        }
        return 0;
    }
}
