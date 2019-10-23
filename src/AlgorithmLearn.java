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
        Scanner input=new Scanner(System.in);
        Integer tem =0;
        tem=input.nextInt();
        System.out.println(sol.JumpFloor1(tem));
    }
}