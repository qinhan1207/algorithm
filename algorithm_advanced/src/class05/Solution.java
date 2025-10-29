package class05;

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class Info {
        int na;
        int bu;

        public Info(int na, int bu) {
            this.na = na;
            this.bu = bu;
        }
    }

    public int rob(TreeNode root) {
        return Math.max(process(root).na, process(root).bu);
    }

    public Info process(TreeNode node) {
        if (node == null) {
            return new Info(0, 0);
        }

        int na = node.val;
        int bu = 0;

        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);


        na = na + leftInfo.bu + rightInfo.bu;
        bu = bu + Math.max(leftInfo.na, leftInfo.bu) + Math.max(rightInfo.na, rightInfo.bu);

        return new Info(na, bu);

    }
}