import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

class Pair {
    TreeNode node;
    int col;
    Pair(TreeNode node, int col) {
        this.node = node;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        // TreeMap to store nodes sorted by vertical level
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            Map<Integer, List<Integer>> levelMap = new HashMap<>();

            for (int i = 0; i < size; i++) {
                Pair temp = q.poll();
                levelMap.putIfAbsent(temp.col, new ArrayList<>());
                levelMap.get(temp.col).add(temp.node.val);

                if (temp.node.left != null) q.offer(new Pair(temp.node.left, temp.col - 1));
                if (temp.node.right != null) q.offer(new Pair(temp.node.right, temp.col + 1));
            }

            // Sort nodes at each vertical level
            for (int col : levelMap.keySet()) {
                List<Integer> list = levelMap.get(col);
                Collections.sort(list);
                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).addAll(list);
            }
        }

        res.addAll(map.values());
        return res;
    }
}
