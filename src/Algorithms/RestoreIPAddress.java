package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author skuang
 */
public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        dfs(result, sb, s, 0, 0);
        return result;
    }
    // index is where we at at s, n means the place we are in ip section, should be 0 - 3
    private void dfs(List<String> result, StringBuilder sb, String s, int index, int n) {
        if (n == 4) {
            if (index == s.length())
                result.add(sb.toString());
            return;
        }
        int length = sb.length();
        for (int len = 1; len < 4 && index + len <= s.length(); len++) {
            Integer i = Integer.parseInt(s.substring(index, index + len));
            if (i > 255) continue;
            sb.append(i);
            if (n != 3) sb.append(":");
            dfs(result, sb, s, index + len, n + 1);
            sb.setLength(length);
        }
    }

    public static void main(String[] args) {
        RestoreIPAddress sol = new RestoreIPAddress();
        sol.restoreIpAddresses("25525511135");
        System.out.println();
    }
}
