import com.sun.xml.internal.fastinfoset.algorithm.IntEncodingAlgorithm;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.rmi.MarshalException;
import java.util.ArrayList;
import java.util.Scanner;
public class AlgorithmLearn {
    public static void main(String[] args) {
        solution sol = new solution();
        ListNode tem1 = new ListNode(1);
        ListNode tem2 = new ListNode(2);
        tem1.next = tem2;
        ListNode tem3 = new ListNode(3);
        tem2.next = tem3;
        ListNode tem4 = new ListNode(4);
        tem3.next = tem4;

        ListNode temp1 = new ListNode(2);
        ListNode temp2 = new ListNode(4);
        temp1.next = temp2;
        ListNode temp3 = new ListNode(6);
        temp2.next = temp3;
        ListNode temp4 = new ListNode(8);
        temp3.next = temp4;

        TreeNode treenode1=new TreeNode(1);
        TreeNode treenode2=new TreeNode(3);
        TreeNode treenode3=new TreeNode(2);
        treenode1.left=treenode2;
        treenode1.right=treenode3;
        TreeNode treenode4=new TreeNode(4);
        TreeNode treenode5=new TreeNode(5);
        TreeNode treenode6=new TreeNode(6);
        TreeNode treenode7=new TreeNode(7);
        treenode2.left=treenode4;
        treenode2.right=treenode5;
        treenode3.left=treenode6;
        treenode3.right=treenode7;
//        ****************1****************
//        Scanner input=new Scanner(System.in);
//        int target=input.nextInt();
//        int x=input.nextInt();
//        int y=input.nextInt();
//        int[][] array=new int[x][y];
//        for(int i=0;i<x;i++)
//        {
//            for(int j=0;j<y;j++)
//            {
//                array[i][j]=input.nextInt();
//            }
//        }
//        System.out.println("yesOrNo:"+ solution.Find2(target,array));

//    ****************2******************
//    将空格替换为%20
//        Scanner input=new Scanner(System.in);
//        String s=input.nextLine();
//        System.out.println(solution.replaceSpace(s));
//    }

//    *********************7*********************
//    现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
//    n<=39
//        Scanner input = new Scanner(System.in);
//        Integer tem = 0;
//        tem = input.nextInt();
//        System.out.println(sol.Fibonacci(tem));

//    *********************8**********************
//    一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上
//    一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
//        Scanner input=new Scanner(System.in);
//        Integer tem =0;
//        tem=input.nextInt();
//        System.out.println(sol.JumpFloor1(tem));

//    *********************9**********************
//    一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
//    求该青蛙跳上一个n级的台阶总共有多少种跳法。
//        Scanner input=new Scanner(System.in);
//        Integer tem=0;
//        tem=input.nextInt();
//        System.out.println(sol.JumpFloorII(tem));

//    *********************10**********************
//    我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的
//    小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
//        Scanner input=new Scanner(System.in);
//        Integer temp=input.nextInt();
//        System.out.println(sol.RectCover(temp));

//    *********************11**********************
//    输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
//        Scanner input=new Scanner(System.in);
//        Integer temp=input.nextInt();
//        System.out.println(sol.NumberOf1(temp));

//    *********************12**********************
//    给定一个double类型的浮点数base和int类型的整数exponent。
//    求base的exponent次方。保证base和exponent不同时为0
//        Scanner input=new Scanner(System.in);
//        double base=input.nextDouble();
//        int exp=input.nextInt();
//        System.out.println(sol.Power(base,exp));

//    *********************12**********************
//    输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
//    使得所有的奇数位于数组的前半部分，所有的偶数位于数组的
//    后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
//        Scanner input=new Scanner(System.in);
//        int[] array=new int[6];
//        int tem=6;
//        System.out.println("输入下一个数字：");
//        for(int i=0;i<tem;i++)
//        {
//            array[i]=input.nextInt();
//            System.out.println("输入下一个数字：");
//        }
//
//        sol.reOrderArray(array);
//    }

//    *********************13**********************
//    输入一个链表，输出该链表中倒数第k个结点。
//    ListNode listNode13;
//    listNode13 = tem1;
//    System.out.println(sol.FindKthToTail(listNode13,2).val);

//    *********************14**********************
//    输入两个单调递增的链表，输出两个链表合成后的链表，
//    当然我们需要合成后的链表满足单调不减规则。

//        ListNode l13=sol.Merge1(tem1,temp1);
//        while(l13!=null)
//        {
//            System.out.println(l13.val);
//            l13=l13.next;
//        }

//    *********************16**********************
//    输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字,
//    例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11
//    12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15
//    14,13,9,5,6,7,11,10。
//        int[][] matrix={{1,2,3,4,5,6}};
//        ArrayList<Integer> list=sol.printMatrix(matrix);
//        for(int i=0;i<list.size();i++)
//        {
//            System.out.println(list.get(i));
//        }

//    ********************17***********************
//    输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
//    假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是
//    该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
//    （注意：这两个序列的长度是相等的）

//        int[] pushA={1,2,3,4,5};
//        int[] popA={4,5,3,2,1};
//        System.out.println(sol.IsPopOrder(pushA,popA));

//    ********************18***********************
//    从上往下打印出二叉树的每个节点，同层节点从左至右打印。
//        ArrayList<Integer> arrayList=sol.PrintFromTopToBottom(treenode1);
//        for(int i=0;i<arrayList.size();i++)
//        {
//            System.out.println(arrayList.get(i));
//        }

//    ********************19***********************
//    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
//    如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
        int[] sequence={7,4,6,5};
        System.out.println(sol.VerifySequenceOfBST(sequence));
    }
}