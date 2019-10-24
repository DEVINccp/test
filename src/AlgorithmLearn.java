import com.sun.xml.internal.fastinfoset.algorithm.IntEncodingAlgorithm;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;
public class AlgorithmLearn {
    public static void main(String[] args) {
        solution sol = new solution();
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
        Scanner input=new Scanner(System.in);
        int[] array=new int[6];
        int tem=6;
        System.out.println("输入下一个数字：");
        for(int i=0;i<tem;i++)
        {
            array[i]=input.nextInt();
            System.out.println("输入下一个数字：");
        }

        sol.reOrderArray(array);
    }

//    *********************13**********************
//    输入一个链表，输出该链表中倒数第k个结点。
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail(ListNode head,int k){
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
        ListNode pre,nex,mid;
        if(head.next==null){
            return head;
        }
        if(head.next.next==null)
        {
            ListNode tem=head;
            head=head.next;
            head.next=tem;
            tem.next=null;
            return head;
        }
        nex=head.next.next;
        pre=head;
        mid=head.next;
        while(nex.next!=null)
        {
            nex=nex.next;
            mid=mid.next;
            pre=pre.next;
        }
        nex.next=head;
        head=nex;
        mid.next=null;
        return head;
    }
}