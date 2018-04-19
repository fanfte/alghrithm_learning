package com.fanfte.algorithm.tree;



public class ReorderTree {

    class TreeNode{
        private int value;
        public TreeNode(int value) {
            this.value = value;
        }
        private TreeNode left;
        private TreeNode right;
    }

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root =re(pre,0,pre.length-1,in,0,in.length-1);//传入前序遍历和中序遍历的序列，返回还原的二叉树。
        return root;
    }

    public TreeNode re(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){
        if(startPre>endPre||startIn>endIn){//判定是否序列是否便利完。
            return null;
        }
        TreeNode root =new TreeNode(pre[startPre]);//存入节点
        for(int i=startIn;i<=endIn;i++){//从中序遍历开始，寻找和根节点相同的元素。
            if(in[i]==pre[startPre]){//找到了之后分为左右子树，递归进行查找。
                //i-startIn 表示从中序遍历序列开始处向右找了i-startIn个元素，即为前序遍历左序列的偏移量
                root.left=re(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=re(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {1,2,4,7,3,5,6,8};
        int[] arr2 = new int[] {4,7,2,1,5,3,8,6};
        new ReorderTree().reConstructBinaryTree(arr1, arr2);

    }
}
