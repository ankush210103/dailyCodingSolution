class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        solve(s, ans, 0, "", 0);
        return ans;
    }

    public static void solve(String s, List<String> ans, int index, String temp, int count) {
        if (count == 4 && index == s.length()) {
            ans.add(temp);
            return;
        }
        if (count > 4 || index >= s.length()) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) {
                break;
            }
            String str = s.substring(index, index + i);
            if ((str.startsWith("0") && str.length() > 1) || (i == 3 && Integer.parseInt(str) >= 256)) {
                continue;
            }

            solve(s, ans, index + i, temp + str + (count == 3 ? "" : "."), count + 1);
        }
    }
}
