/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Pair {
    int hd;
    int val;

    Pair(int hd, int val) {
        this.hd = hd;
        this.val = val;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Pair>> map = new TreeMap<>();
        List<List<Integer>> result = new ArrayList<>();
        verticalOrder(root, 0, 0, map);
        for (List<Pair> list : map.values()) {
            Collections.sort(list, (a, b) -> {
                if (a.hd == b.hd) return a.val - b.val;
                return a.hd - b.hd;
            });
            List<Integer> temp = new ArrayList<>();
            for (Pair p : list) {
                temp.add(p.val);
            }
            result.add(temp);
        }
        return result;

    }

    public void verticalOrder(TreeNode root, int hd, int vd, Map<Integer, List<Pair>> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(vd)) {
            map.put(vd, new ArrayList<Pair>());
        }
        map.get(vd).add(new Pair(hd, root.val));

        verticalOrder(root.left, hd + 1, vd - 1, map);
        verticalOrder(root.right, hd + 1, vd + 1, map);
        

    }
}