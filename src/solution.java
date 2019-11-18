import sun.reflect.generics.tree.Tree;

import java.util.*;

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

//    *********************12**********************
//    给定一个double类型的浮点数base和int类型的整数exponent。
//    求base的exponent次方。保证base和exponent不同时为0
    public double Power(double base, int exponent) {
        double result=1.0;
        if(base==0.0) return 0.0;
        if(exponent==0) return result;
        int tem=exponent>0?exponent:-exponent;
        while(tem!=0)
        {
            result=result*base;
            tem--;
        }
        return exponent>0?result:1/result;
    }

//    *********************12**********************
//    输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
//    使得所有的奇数位于数组的前半部分，所有的偶数位于数组的
//    后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
    public void reOrderArray(int [] array) {
        int len=array.length;
        int oddIndex=0;
        int evenIndex=0;
        for(int i=0;i<len;i++)
        {
            if(array[i]%2==1)
            {
                int tem=array[i];
                for(int j=i;j>oddIndex;j--)
                {
                    array[j]=array[j-1];
                }
                array[oddIndex]=tem;
                oddIndex++;
            }
        }
        for(int i=0;i<len;i++)
        {
            System.out.println(array[i]+" | ");
        }
    }

//    *********************13**********************
//    输入一个链表，输出该链表中倒数第k个结点。
    public ListNode FindKthToTail(ListNode head, int k){
        ListNode p=head,q=head;
        int count=0;
        for(;p!=null;count++)
        {
            if(count>=k)
                q=q.next;
            p=p.next;
        }
        return count<k?null:q;
    }

//    *********************14**********************
//    输入一个链表，反转链表后，输出新链表的表头。
    public ListNode ReverseList(ListNode head) {
        ListNode pre=null,nex;
        if(head==null||head.next==null){
            return head;
        }
        while(head.next!=null)
        {
            nex=head.next;
            head.next=pre;
            pre=head;
            head=nex;
        }
        head.next=pre;
        return head;
    }

//    *********************14**********************
//    输入两个单调递增的链表，输出两个链表合成后的链表，
//    当然我们需要合成后的链表满足单调不减规则。
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode pre=list1;
        ListNode nex=list1.next;
        ListNode p=list2;
        while(p!=null&&nex!=null)
        {
            System.out.println(pre.val);
            if(nex.val>=p.val)
            {
                pre.next=p;
                ListNode pNext=p.next;
                p.next=nex;
                p=pNext;
                pre=pre.next;
            }
            else{
                pre=pre.next;
                nex=nex.next;
            }
        }
        if(p!=null&&nex==null)
        {
            pre.next=p;
        }
        return list1;
    }
    //递归解法
    public ListNode Merge1(ListNode list1,ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.val<list2.val)
        {
            list1.next=Merge1(list1.next,list2);
            return list1;
        }
        else
        {
            list2.next=Merge1(list1,list2.next);
            return list2;
        }
    }

//    *********************14**********************
//    输入两棵二叉树A，B，判断B是不是A的子结构。
//    我们约定空树不是任意一个树的子结构
    public boolean judge(TreeNode root1,TreeNode root2)
    {
        if(root2==null) return true;
        if(root1==null) return false;
        if(root1.val==root2.val)
            return judge(root1.left,root2.left)&&judge(root1.right,root2.right);
        return false;
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2){
        if(root1==null||root2==null) return false;
        if(root1.val==root2.val)
            if(judge(root1,root2))
                return true;
        return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }


//    *********************15**********************
//    操作给定的二叉树，将其变换为源二叉树的镜像。
    public void Mirror(TreeNode root) {
        if(root==null) return;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        Mirror(root.left);
        Mirror(root.right);
    }

//    *********************16**********************
//    输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字,
//    例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11
//    12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15
//    14,13,9,5,6,7,11,10。
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list=new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0)
        {
            return list;
        }
        int up=0;
        int down=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        while(true)
        {
            for(int fromLeftToRight=left;fromLeftToRight<=right;fromLeftToRight++)
            {
                list.add(matrix[up][fromLeftToRight]);
            }
            up++;
            if(up>down){
                break;
            }

            for(int fromUpToDown=up;fromUpToDown<=down;fromUpToDown++)
            {
                list.add(matrix[fromUpToDown][right]);
            }
            right--;
            if(right<left){
                break;
            }

            for(int fromRightToLeft=right;fromRightToLeft>=left;fromRightToLeft--){
                list.add(matrix[down][fromRightToLeft]);
            }
            down--;
            if(up>down)
            {
                break;
            }

            for(int fromDownToUp=down;fromDownToUp>=up;fromDownToUp--){
                list.add(matrix[fromDownToUp][left]);
            }
            left++;
            if(left>right){
                break;
            }
        }
        return list;
    }

//    ********************17***********************
//    定义栈的数据结构，请在该类型中实现一个能够得到栈中
//    所含最小元素的min函数（时间复杂度应为O（1））。
    private static Stack<Integer> stack=new Stack<Integer>();
    private static Integer minElement=Integer.MAX_VALUE;
    public void push17(int node) {
        if(stack.empty()){
            minElement=node;
            stack.push(node);
        }
        else
        {
            if(node<minElement){
                stack.push(minElement);
                minElement=node;
            }
            stack.push(node);
        }
    }

    public void pop17() {
        if(stack.size()<1) return;
        if(stack.peek()==minElement)
        {
            if(stack.size()>1){
                stack.pop();
                minElement=stack.peek();
            }
            else
            {
                minElement=Integer.MAX_VALUE;
            }
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minElement;
    }

//    ********************17***********************
//    输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
//    假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是
//    该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
//    （注意：这两个序列的长度是相等的）
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack=new Stack<>();
        if(pushA.length<1||popA.length<1||popA.length!=popA.length)
        {
            return false;
        }
        int j=0;
        for(int i=0;i<pushA.length;i++)
        {
            stack.push(pushA[i]);
            while(stack.size()!=0&&stack.peek()==popA[j]){
                stack.pop();
                j++;
            }
        }
        if(stack.size()>0) return false;
        else return true;
    }

//    ********************18***********************
//    从上往下打印出二叉树的每个节点，同层节点从左至右打印。
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        if(root==null||(root.right==null&&root.left==null)) return arrayList;
        queue.add(root);
        while(!queue.isEmpty()){
            if(queue.peek().left!=null) queue.add(queue.peek().left);
            if(queue.peek().right!=null) queue.add(queue.peek().right);
            arrayList.add(queue.peek().val);
            queue.poll();
        }
        return arrayList;
    }

//    ********************19***********************
//    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
//    如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
    public boolean isBST(int[] seq,int start,int end){
        if(start>=end) return true;
        int split=start;
        for(;seq[split]<seq[end]&&split<end;split++);
        for(int i=split;i<end;i++){
            if(seq[i]<seq[end]) return false;
         }
        return isBST(seq,start,split-1)&&isBST(seq,split,end-1);
    }
    public boolean VerifySequenceOfBST(int [] sequence){
        if(sequence==null||sequence.length==0) return false;
        return isBST(sequence,0,sequence.length-1);
    }
}
