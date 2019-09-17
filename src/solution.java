import java.util.ArrayList;

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

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        
    }
}
