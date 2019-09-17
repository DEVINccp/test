import java.util.Scanner;

public class AlgorithmLearn {
    public static void main(String[] args)
    {
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
        Scanner input=new Scanner(System.in);
        String s=input.nextLine();
        System.out.println(solution.replaceSpace(s));
    }

}