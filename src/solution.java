import java.util.ArrayList;
import java.util.Arrays;

public class solution {
//    ****************1****************
//    1、在一个二维数组中（每个一维数组的长度相同），
//    每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
//    请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    public static boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == target) return true;
            }
        }
        return false;
    }

    public static boolean Find2(int target,int[][] array)
    {
        int rows=array.length;
        if(rows==0) return false;
        int columns=array[0].length;
        if(columns==0) return false;

        int row=rows-1;
        int col=0;
        while(row>=0&&col<columns)
        {
            if(array[row][col]>target) {row--;}
            else
                if(array[row][col]<target) {col++;}
            else
                if(array[row][col]==target) {return true;}
        }
        return false;
    }

//    ****************2******************
//    将空格替换为%20
    public static String replaceSpace(String str)
    {
        return str.toString().replace(" ","%20");
    }

    //*************3***************
    //输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
    public class ListNode{
      int val;
      ListNode next=null;
      ListNode(int val){
          this.val=val;
        }
    };
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();
        ListNode tmp=listNode;
        while(tmp!=null){
            list.add(0,tmp.val);
            tmp=tmp.next;
        }
        return list;
    }


//    ******************4******************
//    输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
//    假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//    例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val=x;}
    }

    public TreeNode reConstructBinaryTree(int[] pre,int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        //在中序中找到前序的根
        for (int i = 0; i < in.length; i++)
        {
            if(in[i]==pre[0]){
                //左子树，注意copyOfRange函数，左闭右开
                root.left=reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                //右子树，注意copyOfRange函数左闭右开
                root.right=reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return root;
    }
}
