import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

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


//    ****************5**************
//    用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
    Stack<Integer> stack1=new Stack<Integer>();
    Stack<Integer> stack2=new Stack<Integer>();
    public void push(int node)
    {
        stack1.push(node);
    }
    public int pop()
    {
        if(stack2.size()<=0)
        {
            while(stack1.size()!=0)
            {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

//    *********************6*****************
//    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//    输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
//    例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
//    NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0)
        {
            return 0;
        }

        for(int i=0;i<array.length-1;i++)
        {
            if(array[i]>array[i+1])
                return array[i+1];
        }

        return array[0];
    }

    public int minNumberInRotateArray2(int [] array) {
        if(array.length==0)
        {
            return 0;
        }
        Arrays.sort(array);
        return array[0];
    }

    public int minNumberInRotateArray3(int [] array){
        int l=0;
        int r=array.length;
        if (l==r)
            return 0;
        while(l<r)
        {
            int mid=(l+r)/2;
            if(array[l]<array[r])
            {
                return array[l];
            }
            if(array[mid]>array[mid+1])
            {
                return array[mid+1];
            }
            if(array[mid]<array[mid-1])
            {
                return array[mid];
            }

            if(array[mid]>array[0]){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return 0;
    }

//    *********************7*********************
//    现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
//    n<=39
    public int Fibonacci(int n) {
        if(n<=1)
        {
            return n;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

//    *********************8**********************
//    一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上
//    一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
//     递归解法
    public int JumpFloor(int target) {
        if(target==1) return 1;
        if(target==2) return 2;
        if(target==3) return 3;
        return JumpFloor(target-1)+JumpFloor(target-2);
    }

    //迭代解法
    public int JumpFloor1(int target) {
        int pre1=2;
        int pre2=1;
        if(target==1) return 1;
        if(target==2) return 2;
        int re=0;
        for(int i=3;i<=target;i++)
        {
            re=pre1+pre2;
            pre2=pre1;
            pre1=re;
        }
        return re;
    }

//    *********************9**********************
//    一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
//    求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public int JumpFloorII(int target) {
        if(target==1)
            return 1;
        else
            return 2*JumpFloorII(target-1);
    }

//    *********************10**********************
//    我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的
//    小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
    public int RectCover(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        if (target == 3) return 3;
        return RectCover(target - 1) + RectCover(target - 2);
    }
//    *********************11**********************
//    输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
      public int NumberOf1(int n){
          if(n==0) return 0;
          int count=0;
          while(n!=0){
              count++;
              n=n&(n-1);
        }
          return count;
    }
}
