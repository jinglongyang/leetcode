package linkedlist;

import java.util.LinkedList;

/**
 * https://oj.leetcode.com/problems/simplify-path/
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;
        String[] paths = path.split("/+");
        LinkedList<String> list = new LinkedList<>();
        for (String tmp : paths) {
            if ("..".equals(tmp)) {
                if (!list.isEmpty()) {
                    list.removeLast();
                }
            } else if (!"".equals(tmp) && !".".equals(tmp)) {
                list.add(tmp);
            }
        }
        if (list.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String tmp : list) {
            sb.append("/").append(tmp);
        }
        return sb.toString();
    }
}
