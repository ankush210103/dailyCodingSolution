
class Solution {

    public static void generate(int n, List<String> str, int l, int r, String s) {
       
        if (l == n && r == n) {
            str.add(s);
            return;
        }

        
        if (l < n) {
            generate(n, str, l + 1, r, s + "(");
        }

        if (r < l) {
            generate(n, str, l, r + 1, s + ")");
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> str = new ArrayList<>();
        generate(n, str, 0, 0, "");
        return str;
    }
}